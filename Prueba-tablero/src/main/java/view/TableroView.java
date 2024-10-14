/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
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
import javax.swing.Icon;
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
import java.awt.Component;
import java.util.List;

public class TableroView extends JFrame {

    private Array array;
    private List<Jugador> jugadores;
    private Ficha fichaSeleccionada = null;

    public TableroView(Array array, List<Jugador> jugadores) {
        this.setSize(1200, 850);
        this.array = array;
        this.jugadores = jugadores;
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        TableroPanel tableroPanel = new TableroPanel(array);
        add(tableroPanel, BorderLayout.CENTER);

        JPanel fichasJugadorPanel = new JPanel();
        fichasJugadorPanel.setLayout(new FlowLayout());

        add(fichasJugadorPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        ControlJuego controlJuego = new ControlJuego(jugadores, array);
//        controlJuego.colocarMulaMasAlta();

        for (Jugador jugador : jugadores) {
            for (Ficha ficha : jugador.getFichas()) {
                
                String rutaImagen = String.format("C:\\Users\\favel\\OneDrive\\Documentos\\ITSON\\Tablero-Pruebas\\Prueba-tablero\\src\\img\\ficha%d_%d.png", ficha.getLado1(), ficha.getLado2());
                ImageIcon icono = new ImageIcon(rutaImagen);

                JLabel fichaLabel = new JLabel(icono);
                fichaLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fichaSeleccionada = ficha;
                        System.out.println(fichaSeleccionada);
                        array.colocarFichaHorizontal(fichaSeleccionada);
                        tableroPanel.repaint();
                    }
                });

                fichasJugadorPanel.add(fichaLabel);
            }
        }

        tableroPanel.repaint();

    }

    // Método actualizado para buscar la ficha en el jugador específico
//    private Ficha encontrarFichaPorIcono(ImageIcon icon, Jugador jugador) {
//        for (Ficha ficha : jugador.getFichas()) {
//            if (new ImageIcon(ficha.getRutaImagen()).getImage().equals(icon.getImage())) {
//                return ficha;
//            }
//        }
//        return null;
//    }

    public class TableroPanel extends JPanel {

        private int[][] tablero;

        public TableroPanel(Array array) {
            this.tablero = array.obtenerTablero();
            setPreferredSize(new Dimension(800, 800));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = 60;

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

                //Esto ya ni se va a usar ni para que arreglarlo
                @Override
                public Object getTransferData(DataFlavor flavor) {
                    if (DataFlavor.imageFlavor.equals(flavor)) {
                        return false;
                        //return new ImageIcon(ficha.getRutaImagen());
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
