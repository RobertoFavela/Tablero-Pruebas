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
          tablero = new int[15][15];
          reiniciarTablero();
          tablero[7][7] = 6;
          extremoIzquierdo = 6;
          extremoDerecha = 6;
          extremo1Columna = 7;
          extremo1Fila = 7;
          extremo2Columna = 7;
          extremo2Fila = 7;
     }

     public boolean estaVacio(int fila, int columna) {
          return tablero[fila][columna] == -1;
     }

     /**
      * Verifica si el jugador tiene alguna ficha que coincida con los extremos.
      * Si no tiene fichas válidas, muestra un mensaje de aviso.
      *
      * @param fichasJugador Lista de fichas del jugador.
      * @return true si el jugador tiene fichas válidas, false en caso
      * contrario.
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

     public boolean colocarFicha(Ficha ficha, boolean extremo, String direccion) {

          switch (direccion) {
               case "Izquierda":
                    return colocarFichaIzquierda(ficha, extremo);
               case "Arriba":
                    return colocarFichaArriba(ficha, extremo);
               case "Derecha":
                    return colocarFichaDerecha(ficha, extremo);
               case "Abajo":
                    return colocarFichaAbajo(ficha, extremo);
          }

          return false;  
     }

     public boolean colocarFichaIzquierda(Ficha ficha, boolean extremo) {
          int fila = extremo ? extremo1Fila : extremo2Fila;
          int columna = extremo ? extremo1Columna : extremo2Columna;
          int lado = extremo ? extremoIzquierdo : extremoDerecha;

          if (ficha.esMula()) {
               if (ficha.getLado1() == lado && columna - 3 > 0 && tablero[fila][columna - 1] == -1) {
                    tablero[fila][columna - 1] = ficha.getLado1();
                    lado = ficha.getLado2();
                    columna -= 1;
                    return true;
               }
          }
          if (ficha.getLado1() == lado) {
               if (columna - 2 > 0 && tablero[fila][columna - 1] == -1 && tablero[fila][columna - 2] == -1) {
                    tablero[fila][columna - 1] = ficha.getLado1();
                    tablero[fila][columna - 2] = ficha.getLado2();
                    lado = ficha.getLado2();
                    columna -= 2;
                    return true;
               }
          }
          if (ficha.getLado2() == lado) {
               if (columna - 2 > 0 && tablero[fila][columna - 1] == -1 && tablero[fila][columna - 2] == -1) {
                    tablero[fila][columna - 1] = ficha.getLado2();
                    tablero[fila][columna - 2] = ficha.getLado1();
                    lado = ficha.getLado1();
                    columna -= 2;
                    return true;
               }
          }

          return false;
     }

     public boolean colocarFichaArriba(Ficha ficha, boolean extremo) {
          int fila = extremo ? extremo1Fila : extremo2Fila;
          int columna = extremo ? extremo1Columna : extremo2Columna;
          int lado = extremo ? extremoIzquierdo : extremoDerecha;

          if (ficha.esMula()) {
               if (ficha.getLado1() == lado && fila - 3 < tablero.length && tablero[fila - 1][columna] == -1) {
                    tablero[fila - 1][columna] = ficha.getLado1();
                    lado = ficha.getLado2();
                    fila -= 1;
                    return true;
               }
          }
          if (ficha.getLado1() == lado) {
               if (fila - 2 < tablero.length && tablero[fila - 1][columna] == -1 && tablero[fila - 2][columna] == -1) {
                    tablero[fila - 1][columna] = ficha.getLado1();
                    tablero[fila - 2][columna] = ficha.getLado2();
                    lado = ficha.getLado2();
                    fila -= 2;
                    return true;
               }
          }
          if (ficha.getLado2() == lado) {
               if (fila - 2 < tablero.length && tablero[fila - 1][columna] == -1 && tablero[fila - 2][columna] == -1) {
                    tablero[fila - 1][columna] = ficha.getLado2();
                    tablero[fila - 2][columna] = ficha.getLado1();
                    lado = ficha.getLado1();
                    fila -= 2;
                    return true;
               }
          }

          return false;
     }

     public boolean colocarFichaDerecha(Ficha ficha, boolean extremo) {
          int fila = extremo ? extremo1Fila : extremo2Fila;
          int columna = extremo ? extremo1Columna : extremo2Columna;
          int lado = extremo ? extremoIzquierdo : extremoDerecha;

          if (ficha.esMula()) {
               if (ficha.getLado1() == lado && columna + 3 < tablero[0].length && tablero[fila][columna + 1] == -1) {
                    tablero[fila][columna + 1] = ficha.getLado1();
                    lado = ficha.getLado2();
                    columna += 1;
                    return true;
               }
          }
          if (ficha.getLado1() == lado) {
               if (columna + 2 < tablero[0].length && tablero[fila][columna + 1] == -1 && tablero[fila][columna + 2] == -1) {
                    tablero[fila][columna + 1] = ficha.getLado1();
                    tablero[fila][columna + 2] = ficha.getLado2();
                    lado = ficha.getLado2();
                    columna += 2;
                    return true;
               }
          }
          if (ficha.getLado2() == lado) {
               if (columna + 2 < tablero[0].length && tablero[fila][columna + 1] == -1 && tablero[fila][columna + 2] == -1) {
                    tablero[fila][columna + 1] = ficha.getLado2();
                    tablero[fila][columna + 2] = ficha.getLado1();
                    lado = ficha.getLado1();
                    columna += 2;
                    return true;
               }
          }

          return false;
     }

     public boolean colocarFichaAbajo(Ficha ficha, boolean extremo) {
          int fila = extremo ? extremo1Fila : extremo2Fila;
          int columna = extremo ? extremo1Columna : extremo2Columna;
          int lado = extremo ? extremoIzquierdo : extremoDerecha;

          if (ficha.esMula()) {
               if (ficha.getLado1() == lado && fila + 3 > 0 && tablero[fila + 1][columna] == -1) {
                    tablero[fila + 1][columna] = ficha.getLado1();
                    lado = ficha.getLado2();
                    fila += 1;
                    return true;
               }
          }
          if (ficha.getLado1() == lado) {
               if (fila + 2 > 0 && tablero[fila + 1][columna] == -1 && tablero[fila + 2][columna] == -1) {
                    tablero[fila + 1][columna] = ficha.getLado1();
                    tablero[fila + 2][columna] = ficha.getLado2();
                    lado = ficha.getLado2();
                    fila += 2;
                    return true;
               }
          }
          if (ficha.getLado2() == lado) {
               if (fila + 2 > 0 && tablero[fila + 1][columna] == -1 && tablero[fila + 2][columna] == -1) {
                    tablero[fila + 1][columna] = ficha.getLado2();
                    tablero[fila + 2][columna] = ficha.getLado1();
                    lado = ficha.getLado1();
                    fila += 2;
                    return true;
               }
          }

          return false;
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
