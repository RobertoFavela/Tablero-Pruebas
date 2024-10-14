/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

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
        tablero = new int[10][10];
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

    public boolean colocarFichaHorizontal(Ficha ficha) {
        if (ficha.getLado1() == extremoIzquierdo) {
            System.out.println("entraste al primer if");
            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado2();

            extremoIzquierdo = ficha.getLado2();
            extremo1Columna -= 2;
            return true;
        }
        if (ficha.getLado1() == extremoDerecha) {
            System.out.println("entraste al segundo if");
            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado2();
            extremoDerecha = ficha.getLado2();
            extremo2Columna += 2;
            return true;
        }
        if (ficha.getLado2() == extremoIzquierdo) {
            System.out.println("entraste al tercer if");
            tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado2();
            tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado1();

            extremoIzquierdo = ficha.getLado1();
            extremo1Columna -= 2;
            return true;
        }
        if (ficha.getLado2() == extremoDerecha) {
            System.out.println("entraste al cuarto if");
            tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado2();
            tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado1();
            extremoDerecha = ficha.getLado1();
            extremo2Columna += 2;
            return true;
        }
        return false;
    }

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
