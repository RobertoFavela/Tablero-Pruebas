package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;

import Logica.Array;
import Logica.ControlJuego;
import Logica.Ficha;
import Logica.Jugador;
import javax.swing.BoxLayout;

public class TableroView extends JFrame {

    private Array array;
    private List<Jugador> jugadores;
    private Ficha fichaSeleccionada = null;
    private JPanel botonesPanel;  // Panel para los botones de extremos
    private JPanel fichasJugadorPanel;  // Panel para las fichas de los jugadores

    public TableroView(Array array, List<Jugador> jugadores) {
        this.setSize(1200, 850);
        this.array = array;
        this.jugadores = jugadores;
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel del tablero (centro)
        TableroPanel tableroPanel = new TableroPanel(array);
        add(tableroPanel, BorderLayout.CENTER);

        // Panel contenedor para los botones y las fichas (orientación vertical)
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        add(panelInferior, BorderLayout.SOUTH);

        // Panel para los botones de extremos (inicialmente oculto)
        botonesPanel = new JPanel(new FlowLayout());
        botonesPanel.setVisible(false);  // Ocultamos los botones al inicio
        panelInferior.add(botonesPanel);  // Agregamos los botones al panel inferior

        // Panel para las fichas de los jugadores
        fichasJugadorPanel = new JPanel(new FlowLayout());
        panelInferior.add(fichasJugadorPanel);  // Agregamos las fichas al panel inferior

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        ControlJuego controlJuego = new ControlJuego(jugadores, array);
        // controlJuego.colocarMulaMasAlta();

        // Agregamos las fichas de cada jugador al panel de fichas
        for (Jugador jugador : jugadores) {
            for (Ficha ficha : jugador.getFichas()) {
                String rutaImagen = String.format(
                        "C:\\Users\\favel\\OneDrive\\Documentos\\ITSON\\Tablero-Pruebas\\Prueba-tablero\\src\\img\\ficha%d_%d.png",
                        ficha.getLado1(), ficha.getLado2()
                );
                ImageIcon icono = new ImageIcon(rutaImagen);

                JButton fichaLabel = new JButton(icono);
                fichaLabel.setContentAreaFilled(false);
                fichaLabel.setBorderPainted(false);

                fichaLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fichaSeleccionada = ficha;

                        // Mostrar los botones para seleccionar el extremo
                        mostrarBotonesSeleccion(jugador, fichaLabel, tableroPanel);
                    }
                });

                fichasJugadorPanel.add(fichaLabel);
            }
        }

        tableroPanel.repaint();
    }

    private void mostrarBotonesSeleccion(Jugador jugador, JButton fichaLabel, TableroPanel tableroPanel) {
        // Limpiar cualquier botón previo
        botonesPanel.removeAll();

        // Botón para el extremo 1 (izquierdo)
        JButton botonExtremo1 = new JButton("Extremo 1");
        botonExtremo1.addActionListener(e -> colocarFichaEnExtremo(true, jugador, fichaLabel, tableroPanel));
        botonesPanel.add(botonExtremo1);

        // Botón para el extremo 2 (derecho)
        JButton botonExtremo2 = new JButton("Extremo 2");
        botonExtremo2.addActionListener(e -> colocarFichaEnExtremo(false, jugador, fichaLabel, tableroPanel));
        botonesPanel.add(botonExtremo2);

        // Mostrar el panel con los botones
        botonesPanel.setVisible(true);
        botonesPanel.revalidate();
        botonesPanel.repaint();
    }

    private void colocarFichaEnExtremo(boolean extremoIzquierdo, Jugador jugador, JButton fichaLabel, TableroPanel tableroPanel) {
        boolean colocada;

        // Elegir el método según el extremo seleccionado
        if (extremoIzquierdo) {
            colocada = array.colocarFichaExtremoIzquierdo(fichaSeleccionada);
        } else {
            colocada = array.colocarFichaExtremoDerecho(fichaSeleccionada);
        }

        if (colocada) {
            jugador.eliminarFicha(fichaSeleccionada);

            // Quitar la ficha del panel del jugador
            fichasJugadorPanel.remove(fichaLabel);

            // Ocultar los botones de selección
            botonesPanel.setVisible(false);

            // Refrescar los paneles
            fichasJugadorPanel.revalidate();
            fichasJugadorPanel.repaint();
            tableroPanel.repaint();

            System.out.println("Ficha colocada: " + fichaSeleccionada);
        } else {
            System.out.println("No se pudo colocar la ficha.");
        }
    }

    public class TableroPanel extends JPanel {

        private int[][] tablero;

        public TableroPanel(Array array) {
            this.tablero = array.obtenerTablero();
            setPreferredSize(new Dimension(800, 800));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = 30;

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] != -1) {
                        g.setColor(Color.GRAY);
                        g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                    }

                    g.setColor(Color.BLACK);
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                    g.drawString(String.valueOf(tablero[i][j]),
                            j * cellSize + cellSize / 4,
                            i * cellSize + cellSize / 2);
                }
            }
        }
    }
}

