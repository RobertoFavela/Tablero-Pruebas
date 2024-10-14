/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import Logica.Array;
import Logica.ControlJuego;
import Logica.Ficha;
import Logica.Jugador;
import java.util.List;

public class TableroView extends JFrame {

    private Array array;
    private List<Jugador> jugadores; // Cambiado para almacenar la lista de jugadores

    public TableroView(Array array, List<Jugador> jugadores) {
        this.setSize(1200, 850);
        this.array = array;
        this.jugadores = jugadores; // Inicializar la lista de jugadores
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear y agregar el panel del tablero
        TableroPanel tableroPanel = new TableroPanel(array);
        add(tableroPanel, BorderLayout.CENTER);

        // Crear y agregar el panel de fichas del jugador
        JPanel fichasJugadorPanel = new JPanel();
        fichasJugadorPanel.setLayout(new FlowLayout());

        // Inicializar fichas de todos los jugadores
        for (Jugador jugador : jugadores) {
            for (Ficha ficha : jugador.getFichas()) {
                JLabel fichaLabel = new JLabel(new ImageIcon(ficha.getRutaImagen()));
                fichaLabel.setTransferHandler(new FichaTransferHandler(ficha, fichaLabel, fichasJugadorPanel, jugador));
                fichaLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JComponent comp = (JComponent) e.getSource();
                        TransferHandler handler = comp.getTransferHandler();
                        handler.exportAsDrag(comp, e, TransferHandler.MOVE);
                    }
                });
                fichasJugadorPanel.add(fichaLabel);
            }
        }

        add(fichasJugadorPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Llamar al método para colocar la mula más alta en el centro
        ControlJuego controlJuego = new ControlJuego(jugadores, array);
        controlJuego.colocarMulaMasAlta();

        tableroPanel.repaint();
        new DropTarget(tableroPanel, new DropTargetListener() {
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
                System.out.println("Ficha soltada en el tablero");
                try {
                    Transferable transferable = dtde.getTransferable();
                    ImageIcon icon = (ImageIcon) transferable.getTransferData(DataFlavor.imageFlavor);

                    Point dropPoint = dtde.getLocation();
                    int fila = dropPoint.y / 40;
                    int columna = dropPoint.x / 40;

                    // Aquí se busca en todos los jugadores
                    for (Jugador jugador : jugadores) {
                        if (array.estaVacio(fila, columna) && array.estaVacio(fila, columna + 1)) {
                            Ficha fichaColocada = encontrarFichaPorIcono(icon, jugador);
                            if (fichaColocada != null) {
                                array.colocarFichaHorizontal(fichaColocada, fila, columna);

                                jugador.getFichas().remove(fichaColocada);
                                tableroPanel.repaint();

                                for (Component component : fichasJugadorPanel.getComponents()) {
                                    if (component instanceof JLabel) {
                                        JLabel label = (JLabel) component;
                                        if (fichaColocada.getRutaImagen().equals(((ImageIcon) label.getIcon()).getDescription())) {
                                            fichasJugadorPanel.remove(label);
                                            break;
                                        }
                                    }
                                }
                                fichasJugadorPanel.revalidate();
                                fichasJugadorPanel.repaint();
                                break; // Rompe el ciclo si se ha colocado la ficha
                            }
                        }
                    }
                    dtde.dropComplete(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dtde.dropComplete(false);
                }
            }

            // Método actualizado para buscar la ficha en el jugador específico
            private Ficha encontrarFichaPorIcono(ImageIcon icon, Jugador jugador) {
                for (Ficha ficha : jugador.getFichas()) {
                    if (new ImageIcon(ficha.getRutaImagen()).getImage().equals(icon.getImage())) {
                        return ficha;
                    }
                }
                return null;
            }
        });
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
            int cellSize = 40;

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                    g.drawString(String.valueOf(tablero[i][j]), j * cellSize + cellSize / 4, i * cellSize + cellSize / 2);
                }
            }
        }
    }

    class FichaTransferHandler extends TransferHandler {

        private Ficha ficha;
        private JLabel fichaLabel;
        private JPanel fichasJugadorPanel;
        private Jugador jugador; // Guardar referencia al jugador

        public FichaTransferHandler(Ficha ficha, JLabel fichaLabel, JPanel fichasJugadorPanel, Jugador jugador) {
            this.ficha = ficha;
            this.fichaLabel = fichaLabel;
            this.fichasJugadorPanel = fichasJugadorPanel;
            this.jugador = jugador; // Inicializar el jugador
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new Transferable() {
                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[]{DataFlavor.imageFlavor};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return DataFlavor.imageFlavor.equals(flavor);
                }

                @Override
                public Object getTransferData(DataFlavor flavor) {
                    if (DataFlavor.imageFlavor.equals(flavor)) {
                        return new ImageIcon(ficha.getRutaImagen());
                    }
                    return null;
                }
            };
        }

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }
    }
}

