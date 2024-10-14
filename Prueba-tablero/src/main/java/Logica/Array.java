/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

public class Array {

    private int[][] tablero;

    public Array() {
        tablero = new int[17][30];
        reiniciarTablero();
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == 0;
    }

    public boolean colocarFichaHorizontal(Ficha ficha, int fila, int columna) {
        if (ficha.esMula()) {
            if (estaVacio(fila, columna)) {
                tablero[fila][columna] = ficha.getLado1();
                return true;
            }
        } else {
            // Verificar si la columna + 1 está dentro del límite
            if (estaVacio(fila, columna) && (columna + 1 < tablero[fila].length) && estaVacio(fila, columna + 1)) {
                tablero[fila][columna] = ficha.getLado1();
                tablero[fila][columna + 1] = ficha.getLado2();
                return true;
            }
        }
        return false;
    }

    public boolean colocarFichaVertical(Ficha ficha, int fila, int columna) {
        if (ficha.esMula()) {
            // Si es mula, solo ocupa un espacio
            if (estaVacio(fila, columna)) {
                tablero[fila][columna] = ficha.getLado1();
                return true;
            }
        } else {
            // Si no es mula, ocupa dos espacios
            if (estaVacio(fila, columna) && estaVacio(fila + 1, columna)) {
                tablero[fila][columna] = ficha.getLado1();
                tablero[fila + 1][columna] = ficha.getLado2();
                return true;
            }
        }
        return false;
    }

    public int obtenerFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void reiniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public int[][] obtenerTablero() {
        return tablero;
    }
}
