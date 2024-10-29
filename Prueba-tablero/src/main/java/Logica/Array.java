/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author favel
 */
public class Array {

    private int[][] tablero;
    private int extremoIzquierdo, extremoDerecha;
    private int extremo1Columna, extremo1Fila;
    private int extremo2Columna, extremo2Fila;

    public Array() {
        tablero = new int[9][9];
        reiniciarTablero();
        tablero[4][4] = 6;
        extremoIzquierdo = 6;
        extremoDerecha = 6;
        extremo1Columna = 4;
        extremo1Fila = 4;
        extremo2Columna = 4;
        extremo2Fila = 4;
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == -1;
    }

    /**
     * Verifica si el jugador tiene alguna ficha que coincida con los extremos.
     * Si no tiene fichas válidas, muestra un mensaje de aviso.
     *
     * @param fichasJugador Lista de fichas del jugador.
     * @return true si el jugador tiene fichas válidas, false en caso contrario.
     */
    public boolean verificarPosiblesMovimientos(List<Ficha> fichasJugador) {
        for (Ficha ficha : fichasJugador) {

            if (ficha.getLado1() == extremoIzquierdo || ficha.getLado2() == extremoIzquierdo
                    || ficha.getLado1() == extremoDerecha || ficha.getLado2() == extremoDerecha) {
                return true;
            }
        }
        return false;
    }

    public boolean colocarFichaExtremoIzquierdo(Ficha ficha) {
        // Colocar la ficha si es mula
        if (ficha.esMula()) {
            // Colocar ficha en horizontal hacia la izquierda extremo izquierdo
            if (ficha.getLado1() == extremoIzquierdo && extremo1Columna - 3 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1) {
                System.out.println("Izquierda: Mula hacia la izquierda");
                tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
                extremoIzquierdo = ficha.getLado2();
                extremo1Columna -= 1;
                return true;
            }
            // Colocar ficha en vertical hacia arriba extremo izquierdo
            if (ficha.getLado1() == extremoIzquierdo && extremo1Fila + 3 < tablero.length && tablero[extremo1Fila + 1][extremo1Columna] == -1) {
                System.out.println("Izquierda: Mula hacia arriba");
                tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado1();
                extremoIzquierdo = ficha.getLado2();
                extremo1Fila += 1;
                return true;
            }
            // Colocar ficha en horizontal hacia la derecha extremo izquierdo
            if (ficha.getLado1() == extremoIzquierdo && extremo1Columna + 3 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1) {
                System.out.println("Izquierda: Mula hacia la derecha");
                tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
                extremoIzquierdo = ficha.getLado2();
                extremo1Columna += 1;
                return true;
            }
            // Colocar ficha en vertical hacia abajo extremo izquierdo
            if (ficha.getLado1() == extremoIzquierdo && extremo1Fila - 3 > 0 && tablero[extremo1Fila - 1][extremo1Columna] == -1) {
                System.out.println("Izquierda: Mula hacia abajo");
                tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
                extremoIzquierdo = ficha.getLado2();
                extremo1Fila -= 1;
                return true;
            }
        }
        // Colocar ficha en horizontal hacia la izquierda extremo izquierdo
        if (ficha.getLado1() == extremoIzquierdo && extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
            System.out.println("Izquierda: Horizontal hacia la izquierda");
            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado2();
            extremoIzquierdo = ficha.getLado2();
            extremo1Columna -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoIzquierdo && extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
            System.out.println("Izquierda: Horizontal hacia la izquierda");
            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado2();
            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado1();
            extremoIzquierdo = ficha.getLado1();
            extremo1Columna -= 2;
            return true;
        }
        // Colocar ficha en vertical hacia abajo extremo izquierdo
        if (ficha.getLado1() == extremoIzquierdo && extremo1Fila - 2 > 0 && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
            System.out.println("Izquierda: vertical hacia abajo");
            tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
            tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado2();
            extremoIzquierdo = ficha.getLado2();
            extremo1Fila -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoIzquierdo && extremo1Fila - 2 > 0 && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
            System.out.println("Izquierda: vertical hacia abajo");
            tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado2();
            tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado1();
            extremoIzquierdo = ficha.getLado1();
            extremo1Fila -= 2;
            return true;
        }
        // Colocar ficha en horizontal hacia la derecha extremo izquierdo
        if (ficha.getLado1() == extremoIzquierdo && extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
            System.out.println("Izquierda: horizontal hacia la derecha");
            tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
            tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado2();
            extremoIzquierdo = ficha.getLado2();
            extremo1Columna += 2;
            return true;
        }
        if (ficha.getLado2() == extremoIzquierdo && extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
            System.out.println("Izquierda: horizontal hacia la derecha");
            tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado2();
            tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado1();
            extremoIzquierdo = ficha.getLado1();
            extremo1Columna += 2;
            return true;
        }
        // Colocar ficha en vertical hacia arriba extremo izquierdo
        if (ficha.getLado1() == extremoIzquierdo && extremo1Fila + 2 < tablero.length && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
            System.out.println("Izquierda: vertical hacia arriba");
            tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
            tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado2();
            extremoIzquierdo = ficha.getLado2();
            extremo1Fila -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoIzquierdo && extremo1Fila + 2 < tablero.length && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
            System.out.println("Izquierda: vertical hacia arriba");
            tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado2();
            tablero[extremo1Fila + 2][extremo1Columna] = ficha.getLado1();
            extremoIzquierdo = ficha.getLado1();
            extremo1Fila += 2;
            return true;
        }
        return false;
    }

    public boolean colocarFichaExtremoDerecho(Ficha ficha) {
        if (ficha.esMula()) {
            // Colocar ficha en horizontal hacia la derecha
            if (ficha.getLado1() == extremoDerecha && extremo2Columna + 1 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1) {
                System.out.println("Derecha: mula hacia la derecha");
                tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
                extremoDerecha = ficha.getLado2();
                extremo2Columna += 1;
                return true;
            }
            // Colocar ficha en vertical hacia abajo
            if (ficha.getLado1() == extremoDerecha && extremo2Fila + 1 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1) {
                System.out.println("Derecha: mula hacia abajo");
                tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado1();
                extremoDerecha = ficha.getLado2();
                extremo2Fila += 1;
                return true;
            }
            // Colocar ficha en horizontal hacia la izquierda
            if (ficha.getLado1() == extremoDerecha && extremo2Columna - 1 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1) {
                System.out.println("Derecha: mula hacia la izquierda");
                tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado1();
                extremoDerecha = ficha.getLado2();
                extremo2Columna -= 1;
                return true;
            }
            // Colocar ficha en vertical hacia arriba
            if (ficha.getLado1() == extremoDerecha && extremo2Fila - 1 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1) {
                System.out.println("Derecha: mula hacia arriba");
                tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado1();
                extremoDerecha = ficha.getLado2();
                extremo2Fila -= 1;
                return true;
            }
        }
        // Colocar ficha en horizontal hacia la derecha
        if (ficha.getLado1() == extremoDerecha && extremo2Columna + 2 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1 && tablero[extremo2Fila][extremo2Columna + 2] == -1) {
            System.out.println("Derecha: horizontal hacia la derecha");
            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado2();
            extremoDerecha = ficha.getLado2();
            extremo2Columna += 2;
            return true;
        }
        if (ficha.getLado2() == extremoDerecha && extremo2Columna + 2 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1 && tablero[extremo2Fila][extremo2Columna + 2] == -1) {
            System.out.println("Derecha: horizontal hacia la derecha");
            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado2();
            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado1();
            extremoDerecha = ficha.getLado1();
            extremo2Columna += 2;
            return true;
        }
        // Colocar ficha en vertical hacia abajo
        if (ficha.getLado1() == extremoDerecha && extremo2Fila + 2 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1 && tablero[extremo2Fila + 2][extremo2Columna] == -1) {
            System.out.println("Derecha: vertical hacia abajo");
            tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado1();
            tablero[extremo2Fila + 2][extremo2Columna] = ficha.getLado2();
            extremoDerecha = ficha.getLado2();
            extremo2Fila += 2;
            return true;
        }
        if (ficha.getLado2() == extremoDerecha && extremo2Fila + 2 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1 && tablero[extremo2Fila + 2][extremo2Columna] == -1) {
            System.out.println("Derecha: vertical hacia abajo");
            tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado2();
            tablero[extremo2Fila + 2][extremo2Columna] = ficha.getLado1();
            extremoDerecha = ficha.getLado1();
            extremo2Fila += 2;
            return true;
        }
        // Colocar ficha en horizontal hacia la izquierda
        if (ficha.getLado1() == extremoDerecha && extremo2Columna - 2 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1 && tablero[extremo2Fila][extremo2Columna - 2] == -1) {
            System.out.println("Derecha: horizontal hacia la izquierda");
            tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado1();
            tablero[extremo2Fila][extremo2Columna - 2] = ficha.getLado2();
            extremoDerecha = ficha.getLado2();
            extremo2Columna -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoDerecha && extremo2Columna - 2 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1 && tablero[extremo2Fila][extremo2Columna - 2] == -1) {
            System.out.println("Derecha: horizontal hacia la izquierda");
            tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado2();
            tablero[extremo2Fila][extremo2Columna - 2] = ficha.getLado1();
            extremoDerecha = ficha.getLado1();
            extremo2Columna -= 2;
            return true;
        }
        // Colocar ficha en vertical hacia arriba
        if (ficha.getLado1() == extremoDerecha && extremo2Fila - 2 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1 && tablero[extremo2Fila - 2][extremo2Columna] == -1) {
            System.out.println("Derecha: vertical hacia arriba");
            tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado1();
            tablero[extremo2Fila - 2][extremo2Columna] = ficha.getLado2();
            extremoDerecha = ficha.getLado2();
            extremo2Fila -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoDerecha && extremo2Fila - 2 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1 && tablero[extremo2Fila - 2][extremo2Columna] == -1) {
            System.out.println("Derecha: vertical hacia arriba");
            tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado2();
            tablero[extremo2Fila - 2][extremo2Columna] = ficha.getLado1();
            extremoDerecha = ficha.getLado1();
            extremo2Fila -= 2;
            return true;
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="colocarFichaHorizontal">
//    public boolean colocarFichaHorizontal(Ficha ficha) {
//        int filas = tablero.length;
//        int columnas = tablero[0].length;
//
//        // Verificar y colocar hacia la izquierda del extremo izquierdo
//        if (ficha.getLado2() == extremoIzquierdo && extremo1Columna - 3 >= 0) {
//            System.out.println("Colocando hacia la izquierda del extremo izquierdo");
//            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado2();
//            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado1();
//
//            extremoIzquierdo = ficha.getLado1();  // Actualizar extremo
//            extremo1Columna -= 2;
//            return true;
//        }
//
//        // Verificar y colocar hacia la derecha del extremo derecho
//        if (ficha.getLado1() == extremoDerecha && extremo2Columna + 3 < columnas) {
//            System.out.println("Colocando hacia la derecha del extremo derecho");
//            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
//            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado2();
//
//            extremoDerecha = ficha.getLado2();  // Actualizar extremo
//            extremo2Columna += 2;
//            return true;
//        }
//
//        // Verificar y colocar la ficha invertida hacia la izquierda del extremo izquierdo
//        if (ficha.getLado1() == extremoIzquierdo && extremo1Columna - 3 >= 0) {
//            System.out.println("Colocando hacia la izquierda (invertido)");
//            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
//            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado2();
//
//            extremoIzquierdo = ficha.getLado2();  // Actualizar extremo
//            extremo1Columna -= 2;
//            return true;
//        }
//
//        // Verificar y colocar la ficha invertida hacia la derecha del extremo derecho
//        if (ficha.getLado2() == extremoDerecha && extremo2Columna + 3 < columnas) {
//            System.out.println("Colocando hacia la derecha (invertido)");
//            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado2();
//            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado1();
//
//            extremoDerecha = ficha.getLado1();  // Actualizar extremo
//            extremo2Columna += 2;
//            return true;
//        }
//
//        // Intentar colocación vertical hacia arriba en el extremo izquierdo
//        if (ficha.getLado2() == extremoIzquierdo && extremo1Fila - 3 >= 0) {
//            System.out.println("Colocando verticalmente hacia arriba en el extremo izquierdo");
//            tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado2();
//            tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado1();
//
//            extremoIzquierdo = ficha.getLado1();  // Actualizar extremo
//            extremo1Fila -= 2;
//            return true;
//        }
//
//        // Intentar colocación vertical hacia arriba en el extremo derecho
//        if (ficha.getLado1() == extremoDerecha && extremo2Fila - 3 >= 0) {
//            System.out.println("Colocando verticalmente hacia arriba en el extremo derecho");
//            tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado1();
//            tablero[extremo2Fila - 2][extremo2Columna] = ficha.getLado2();
//
//            extremoDerecha = ficha.getLado2();  // Actualizar extremo
//            extremo2Fila -= 2;
//            return true;
//        }
//
//        if (ficha.getLado2() == extremoIzquierdo && extremo1Columna - 3 >= 0) {
//            System.out.println("Colocando verticalmente hacia arriba en el extremo izquierdo");
//            tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado2();
//            tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado1();
//
//            extremoIzquierdo = ficha.getLado1();  // Actualizar extremo
//            extremo1Fila += 2;
//            return true;
//        }
//
//        System.out.println("No se pudo colocar la ficha.");
//        return false;
//    }
// </editor-fold>
    public int obtenerFichaEnPosicion(int fila, int columna) {
        return tablero[fila][columna];
    }

    public int obtenerFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void reiniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = -1;
            }
        }
    }

    public int[][] obtenerTablero() {
        return tablero;
    }

    public int getExtremo1() {
        return extremoIzquierdo;
    }

    public void setExtremo1(int extremoIzquierdo) {
        this.extremoIzquierdo = extremoIzquierdo;
    }

    public int getExtremo2() {
        return extremoDerecha;
    }

    public void setExtremo2(int extremoDerecha) {
        this.extremoDerecha = extremoDerecha;
    }
}
