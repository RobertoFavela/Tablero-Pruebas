package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.*;
import java.util.List;

import Logica.Array;
import Logica.Ficha;
import Logica.Jugador;
import static main.Main.pozo;

public class TableroView extends JFrame {

      private Array array;
      private Jugador jugador;
      private Ficha fichaSeleccionada = null;
      private JPanel botonesPanel;
      private JPanel fichasJugadorPanel;
      private TableroPanel tableroPanel;
      private int contadorClics = 0;
      private boolean movimiento = false;

      public TableroView(Array array, Jugador jugador) {
            this.array = array;
            this.jugador = jugador;

            setSize(1200, 850);
            setTitle("Tablero de Dominó");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Panel del tablero (centro)
            tableroPanel = new TableroPanel(array);
            add(tableroPanel, BorderLayout.CENTER);

            // Panel contenedor para los botones y las fichas (orientación vertical)
            JPanel panelInferior = new JPanel();
            panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
            add(panelInferior, BorderLayout.SOUTH);

            // Panel para los botones de extremos (inicialmente oculto)
            botonesPanel = new JPanel(new FlowLayout());
            botonesPanel.setVisible(false);
            panelInferior.add(botonesPanel);

            // Panel para las fichas del jugador
            fichasJugadorPanel = new JPanel(new FlowLayout());
            panelInferior.add(fichasJugadorPanel);

            // Añadir fichas del jugador
            for (Ficha ficha : jugador.getFichas()) {
                  if (ficha != null) {
                        agregarFichaAlPanel(ficha);
                  }
            }

            pack();
            setLocationRelativeTo(null);
            setVisible(true);

            iniciarHiloVerificacionFichasDisponibles();
            tableroPanel.repaint();
      }

      private void iniciarHiloVerificacionFichasDisponibles() {
            Thread verificador = new Thread(() -> {
                  while (true) {
                        try {
                              Thread.sleep(1000);

                              movimiento = array.verificarPosiblesMovimientos(jugador.getFichas());
                              System.out.println("Movimiento posible: " + movimiento);

                              if (!movimiento) {
                                    SwingUtilities.invokeLater(this::jalarFichasPozo);
                                    break;
                              }
                        } catch (InterruptedException e) {
                              e.printStackTrace();
                        }
                  }
            });
            fichasJugadorPanel.repaint();
            verificador.start();
      }

      private void agregarFichaAlPanel(Ficha ficha) {
            String rutaImagen = String.format("/imgPartidaFichas/ficha%d_%d.png", ficha.getLado1(), ficha.getLado2());
            URL recurso = getClass().getResource(rutaImagen);

            if (recurso != null) {
                  ImageIcon icono = new ImageIcon(recurso);
                  JButton fichaLabel = new JButton(icono);
                  fichaLabel.setContentAreaFilled(false);
                  fichaLabel.setBorderPainted(false);

                  fichaLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                              fichaSeleccionada = ficha;
                              mostrarBotonesSeleccion(fichaLabel);
                        }
                  });

                  fichasJugadorPanel.add(fichaLabel);
            } else {
                  System.err.println("Imagen no encontrada para: " + rutaImagen);
            }
      }

      private void jalarFichasPozo() {
            contadorClics = 0;
            JDialog dialogo = new JDialog(this, "Selecciona Fichas", true);
            dialogo.setSize(300, 200);
            dialogo.setLayout(new BorderLayout());
            dialogo.setLocationRelativeTo(this);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 4));

            URL recurso = getClass().getResource("/imgPartidaFichas/fichaPozo.png");
            if (recurso != null) {
                  ImageIcon iconoFicha = new ImageIcon(recurso);

                  for (int i = 0; i < 8; i++) {
                        JButton boton = new JButton(iconoFicha);
                        boton.setContentAreaFilled(false);
                        boton.setBorderPainted(false);
                        panel.add(boton);

                        boton.addActionListener(e -> {
                              Ficha fichaNueva = pozo.sacarFicha();
                              if (fichaNueva != null) {
                                    jugador.agregarFicha(fichaNueva);
                                    agregarFichaAlPanel(fichaNueva);

                                    fichasJugadorPanel.revalidate();
                                    fichasJugadorPanel.repaint();
                              }

                              boton.setVisible(false);
                              contadorClics++;

                              if (movimiento || contadorClics == 3) {
                                    dialogo.dispose();
                                    iniciarHiloVerificacionFichasDisponibles();

                                    fichasJugadorPanel.revalidate();
                                    fichasJugadorPanel.repaint();
                              }
                        });
                  }
                  dialogo.add(panel, BorderLayout.CENTER);
                  dialogo.setVisible(true);
            } else {
                  System.err.println("Imagen no encontrada en la ruta especificada: /imgPartidaFichas/fichaPozo.png");
            }
      }

      private void mostrarBotonesSeleccion(JButton fichaLabel) {
            botonesPanel.removeAll();

            // Botones para los extremos
            JButton botonExtremo1 = new JButton("Extremo 1");
            botonExtremo1.addActionListener(e -> mostrarBotonesDireccion(true));
            botonesPanel.add(botonExtremo1);

            JButton botonExtremo2 = new JButton("Extremo 2");
            botonExtremo2.addActionListener(e -> mostrarBotonesDireccion(false));
            botonesPanel.add(botonExtremo2);

            botonesPanel.setVisible(true);
            botonesPanel.revalidate();
            botonesPanel.repaint();
      }

      private void mostrarBotonesDireccion(boolean extremoIzquierdo) {
            botonesPanel.removeAll();

            // Botones para seleccionar dirección
            String[] direcciones = {"Arriba", "Abajo", "Izquierda", "Derecha"};
            for (String direccion : direcciones) {
                  JButton botonDireccion = new JButton(direccion);
                  botonDireccion.addActionListener(e -> colocarFicha(extremoIzquierdo, direccion));
                  botonesPanel.add(botonDireccion);
            }

            botonesPanel.setVisible(true);
            botonesPanel.revalidate();
            botonesPanel.repaint();
      }

      private void colocarFicha(boolean extremoIzquierdo, String direccion) {
            if (fichaSeleccionada != null) {
                  boolean colocada;
                  
                  colocada = array.colocarFicha(fichaSeleccionada, extremoIzquierdo, direccion);
                  

                  if (colocada) {
                        System.out.println("Ficha colocada correctamente.");

                        // Eliminar ficha de la lista del jugador
                        jugador.getFichas().remove(fichaSeleccionada);

                        // Limpiar la selección
                        fichaSeleccionada = null;

                        // Actualizar la interfaz gráfica
                        fichasJugadorPanel.removeAll();
                        for (Ficha ficha : jugador.getFichas()) {
                              agregarFichaAlPanel(ficha);  // Volver a agregar las fichas restantes al panel
                        }

                        fichasJugadorPanel.revalidate();
                        fichasJugadorPanel.repaint();
                        tableroPanel.repaint();  // Asegurarse de repintar el tablero
                  } else {
                        System.out.println("No se pudo colocar la ficha en la dirección: " + direccion);
                        JOptionPane.showMessageDialog(this, "No se pudo colocar la ficha.");
                  }
            }
      }

      public class TableroPanel extends JPanel {

            private final int[][] tablero;

            public TableroPanel(Array array) {
                  this.tablero = array.obtenerTablero();
                  setPreferredSize(new Dimension(800, 800));
            }

            @Override
            protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  int cellSize = 50;

                  for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                              g.setColor(tablero[i][j] != -1 ? Color.GRAY : Color.WHITE);
                              g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                              g.setColor(Color.BLACK);
                              g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                              g.drawString(String.valueOf(tablero[i][j]), j * cellSize + cellSize / 4, i * cellSize + cellSize / 2);
                        }
                  }
            }
      }
}
