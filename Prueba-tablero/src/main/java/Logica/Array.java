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
       * Verifica si el jugador tiene alguna ficha que coincida con los
       * extremos. Si no tiene fichas válidas, muestra un mensaje de aviso.
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

      public boolean colocarFichaExtremoIzquierdo(Ficha ficha, String direccion) {

            if (ficha.esMula()) {
                  switch (direccion) {
                        case "Izquierda":
                              return colocarFichaExtremoIzquierdoMulaHaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoIzquierdoMulaHaciaArriba(ficha);
                        case "Derecha":
                              return colocarFichaExtremoIzquierdoMulaHaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoIzquierdoMulaHaciaAbajo(ficha);
                  }
            }

            if (ficha.getLado1() == extremoIzquierdo) {
                  switch (direccion) {
                        case "Izquierda":
                              return colocarFichaExtremoIzquierdoLado1HaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoIzquierdoLado1HaciaArriba(ficha);
                        case "Derecha":
                              return colocarFichaExtremoIzquierdoLado1HaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoIzquierdoLado1HaciaAbajo(ficha);
                  }
            }

            if (ficha.getLado2() == extremoIzquierdo) {
                  switch (direccion) {
                        case "Izquierda":
                              return colocarFichaExtremoIzquierdoLado2HaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoIzquierdoLado2HaciaArriba(ficha);
                        case "Derecha":
                              return colocarFichaExtremoIzquierdoLado2HaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoIzquierdoLado2HaciaAbajo(ficha);
                  }
            }

            return false;  // Si ninguna condición se cumplió
      }

      public boolean colocarFichaExtremoIzquierdoMulaHaciaIzquierda(Ficha ficha) {
            if (ficha.getLado1() == extremoIzquierdo && extremo1Columna - 3 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1) {
                  System.out.println("Izquierda: Mula hacia la izquierda");
                  tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Columna -= 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoMulaHaciaArriba(Ficha ficha) {
            if (ficha.getLado1() == extremoIzquierdo && extremo1Fila - 3 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1) {
                  System.out.println("Izquierda: Mula hacia arriba");
                  tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Fila -= 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoMulaHaciaDerecha(Ficha ficha) {
            if (ficha.getLado1() == extremoIzquierdo && extremo1Columna + 3 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1) {
                  System.out.println("Izquierda: Mula hacia la derecha");
                  tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Columna += 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoMulaHaciaAbajo(Ficha ficha) {
            if (ficha.getLado1() == extremoIzquierdo && extremo1Fila + 3 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1) {
                  System.out.println("Izquierda: Mula hacia abajo");
                  tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Fila += 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado1HaciaIzquierda(Ficha ficha) {
            if (extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
                  System.out.println("Izquierda: Horizontal hacia la izquierda");
                  tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
                  tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado2();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Columna -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado1HaciaArriba(Ficha ficha) {
            if (extremo1Fila - 2 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
                  System.out.println("Izquierda: vertical hacia arriba");
                  tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
                  tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado2();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Fila -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado1HaciaDerecha(Ficha ficha) {
            if (extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
                  System.out.println("Izquierda: horizontal hacia la derecha");
                  tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
                  tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado2();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Columna += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado1HaciaAbajo(Ficha ficha) {
            if (extremo1Fila + 2 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
                  System.out.println("Izquierda: vertical hacia abajo");
                  tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado1();
                  tablero[extremo1Fila + 2][extremo1Columna] = ficha.getLado2();
                  extremoIzquierdo = ficha.getLado2();
                  extremo1Fila += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado2HaciaIzquierda(Ficha ficha) {
            if (extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
                  System.out.println("Izquierda: Horizontal hacia la izquierda");
                  tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado2();
                  tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado1();
                  extremo1Columna -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado2HaciaArriba(Ficha ficha) {
            if (ficha.getLado2() == extremoIzquierdo && extremo1Fila - 2 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
                  System.out.println("Izquierda: vertical hacia arriba");
                  tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado2();
                  tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado1();
                  extremo1Fila -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado2HaciaDerecha(Ficha ficha) {
            if (ficha.getLado2() == extremoIzquierdo && extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
                  System.out.println("Izquierda: horizontal hacia la derecha");
                  tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado2();
                  tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado1();
                  extremo1Columna += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoIzquierdoLado2HaciaAbajo(Ficha ficha) {
            if (ficha.getLado2() == extremoIzquierdo && extremo1Fila + 2 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
                  System.out.println("Izquierda: vertical hacia abajo");
                  tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado2();
                  tablero[extremo1Fila + 2][extremo1Columna] = ficha.getLado1();
                  extremoIzquierdo = ficha.getLado1();
                  extremo1Fila += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerecho(Ficha ficha, String direccion) {

            if (ficha.esMula()) {
                  switch (direccion) {
                        case "Derecha":
                              return colocarFichaExtremoDerechoMulaHaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoDerechoMulaHaciaAbajo(ficha);
                        case "Izquierda":
                              return colocarFichaExtremoDerechoMulaHaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoDerechoMulaHaciaArriba(ficha);
                  }
            }

            if (ficha.getLado1() == extremoDerecha) {
                  switch (direccion) {
                        case "Derecha":
                              return colocarFichaExtremoDerechoLado1HaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoDerechoLado1HaciaAbajo(ficha);
                        case "Izquierda":
                              return colocarFichaExtremoDerechoLado1HaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoDerechoLado1HaciaArriba(ficha);
                  }
            }

            if (ficha.getLado2() == extremoDerecha) {
                  switch (direccion) {
                        case "Derecha":
                              return colocarFichaExtremoDerechoLado2HaciaDerecha(ficha);
                        case "Abajo":
                              return colocarFichaExtremoDerechoLado2HaciaAbajo(ficha);
                        case "Izquierda":
                              return colocarFichaExtremoDerechoLado2HaciaIzquierda(ficha);
                        case "Arriba":
                              return colocarFichaExtremoDerechoLado2HaciaArriba(ficha);
                  }
            }

            return false;  // Si ninguna condición se cumplió
      }

      public boolean colocarFichaExtremoDerechoMulaHaciaDerecha(Ficha ficha) {
            if (extremo2Columna + 1 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1) {
                  System.out.println("Derecha: mula hacia la derecha");
                  tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
                  extremoDerecha = ficha.getLado2();
                  extremo2Columna += 1;
                  return true;
            }
            return false;

      }

      public boolean colocarFichaExtremoDerechoMulaHaciaAbajo(Ficha ficha) {
            if (extremo2Fila + 1 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1) {
                  System.out.println("Derecha: mula hacia abajo");
                  tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado1();
                  extremoDerecha = ficha.getLado2();
                  extremo2Fila += 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoMulaHaciaIzquierda(Ficha ficha) {
            if (extremo2Columna - 1 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1) {
                  System.out.println("Derecha: mula hacia la izquierda");
                  tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado1();
                  extremoDerecha = ficha.getLado2();
                  extremo2Columna -= 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoMulaHaciaArriba(Ficha ficha) {
            if (extremo2Fila - 1 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1) {
                  System.out.println("Derecha: mula hacia arriba");
                  tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado1();
                  extremoDerecha = ficha.getLado2();
                  extremo2Fila -= 1;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado1HaciaDerecha(Ficha ficha) {
            if (extremo2Columna + 2 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1 && tablero[extremo2Fila][extremo2Columna + 2] == -1) {
                  System.out.println("Derecha: horizontal hacia la derecha");
                  tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado1();
                  tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado2();
                  extremoDerecha = ficha.getLado2();
                  extremo2Columna += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado1HaciaAbajo(Ficha ficha) {
            if (extremo2Fila + 2 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1 && tablero[extremo2Fila + 2][extremo2Columna] == -1) {
                  System.out.println("Derecha: vertical hacia abajo");
                  tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado1();
                  tablero[extremo2Fila + 2][extremo2Columna] = ficha.getLado2();
                  extremoDerecha = ficha.getLado2();
                  extremo2Fila += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado1HaciaIzquierda(Ficha ficha) {
            if (extremo2Columna - 2 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1 && tablero[extremo2Fila][extremo2Columna - 2] == -1) {
                  System.out.println("Derecha: horizontal hacia la izquierda");
                  tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado1();
                  tablero[extremo2Fila][extremo2Columna - 2] = ficha.getLado2();
                  extremoDerecha = ficha.getLado2();
                  extremo2Columna -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado1HaciaArriba(Ficha ficha) {
            if (extremo2Fila - 2 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1 && tablero[extremo2Fila - 2][extremo2Columna] == -1) {
                  System.out.println("Derecha: vertical hacia arriba");
                  tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado1();
                  tablero[extremo2Fila - 2][extremo2Columna] = ficha.getLado2();
                  extremoDerecha = ficha.getLado2();
                  extremo2Fila -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado2HaciaDerecha(Ficha ficha) {
            if (extremo2Columna + 2 < tablero[0].length && tablero[extremo2Fila][extremo2Columna + 1] == -1 && tablero[extremo2Fila][extremo2Columna + 2] == -1) {
                  System.out.println("Derecha: horizontal hacia la derecha");
                  tablero[extremo2Fila][extremo2Columna + 1] = ficha.getLado2();
                  tablero[extremo2Fila][extremo2Columna + 2] = ficha.getLado1();
                  extremoDerecha = ficha.getLado1();
                  extremo2Columna += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado2HaciaAbajo(Ficha ficha) {
            if (extremo2Fila + 2 < tablero.length && tablero[extremo2Fila + 1][extremo2Columna] == -1 && tablero[extremo2Fila + 2][extremo2Columna] == -1) {
                  System.out.println("Derecha: vertical hacia abajo");
                  tablero[extremo2Fila + 1][extremo2Columna] = ficha.getLado2();
                  tablero[extremo2Fila + 2][extremo2Columna] = ficha.getLado1();
                  extremoDerecha = ficha.getLado1();
                  extremo2Fila += 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado2HaciaIzquierda(Ficha ficha) {
            if (extremo2Columna - 2 >= 0 && tablero[extremo2Fila][extremo2Columna - 1] == -1 && tablero[extremo2Fila][extremo2Columna - 2] == -1) {
                  System.out.println("Derecha: horizontal hacia la izquierda");
                  tablero[extremo2Fila][extremo2Columna - 1] = ficha.getLado2();
                  tablero[extremo2Fila][extremo2Columna - 2] = ficha.getLado1();
                  extremoDerecha = ficha.getLado1();
                  extremo2Columna -= 2;
                  return true;
            }
            return false;
      }

      public boolean colocarFichaExtremoDerechoLado2HaciaArriba(Ficha ficha) {
            if (extremo2Fila - 2 >= 0 && tablero[extremo2Fila - 1][extremo2Columna] == -1 && tablero[extremo2Fila - 2][extremo2Columna] == -1) {
                  System.out.println("Derecha: vertical hacia arriba");
                  tablero[extremo2Fila - 1][extremo2Columna] = ficha.getLado2();
                  tablero[extremo2Fila - 2][extremo2Columna] = ficha.getLado1();
                  extremoDerecha = ficha.getLado1();
                  extremo2Fila -= 2;
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
