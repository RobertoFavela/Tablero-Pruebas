/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Dominio.Arreglo;
import Dominio.Ficha;
import java.util.List;

public class LogicaArreglo {

     private Arreglo arreglo;

     public LogicaArreglo(Arreglo arreglo) {
          this.arreglo = arreglo;
     }

     public int[][] obtenerTablero() {
          return arreglo.getTablero();
     }

     public boolean estaVacio(int fila, int columna) {
          return obtenerTablero()[fila][columna] == -1;
     }

     public boolean verificarPosiblesMovimientos(List<Ficha> fichasJugador) {
          int extremoIzquierdo = arreglo.getExtremo1();
          int extremoDerecho = arreglo.getExtremo2();
          for (Ficha ficha : fichasJugador) {
               if (ficha.getLado1() == extremoIzquierdo || ficha.getLado2() == extremoIzquierdo
                       || ficha.getLado1() == extremoDerecho || ficha.getLado2() == extremoDerecho) {
                    System.out.println("Extremo 1: " + arreglo.getExtremo1());
                    System.out.println("Extremo 2: " + arreglo.getExtremo2());
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

     private boolean colocarFichaIzquierda(Ficha ficha, boolean extremo) {
          int fila = extremo ? arreglo.getExtremo1Fila() : arreglo.getExtremo2Fila();
          int columna = extremo ? arreglo.getExtremo1Columna() : arreglo.getExtremo2Columna();
          int lado = extremo ? arreglo.getExtremo1() : arreglo.getExtremo2();

          if (ficha.esMula() && ficha.getLado1() == lado && columna - 1 >= 0 && estaVacio(fila, columna - 1)) {
               obtenerTablero()[fila][columna - 1] = ficha.getLado1();
               actualizarExtremos(extremo, ficha.getLado1(), columna - 1, fila);
               return true;
          }

          if (columna - 2 >= 0 && estaVacio(fila, columna - 1) && estaVacio(fila, columna - 2)) {
               if (ficha.getLado1() == lado) {
                    obtenerTablero()[fila][columna - 1] = ficha.getLado1();
                    obtenerTablero()[fila][columna - 2] = ficha.getLado2();
                    actualizarExtremos(extremo, ficha.getLado2(), columna - 2, fila);
                    return true;
               }
               if (ficha.getLado2() == lado) {
                    obtenerTablero()[fila][columna - 1] = ficha.getLado2();
                    obtenerTablero()[fila][columna - 2] = ficha.getLado1();
                    actualizarExtremos(extremo, ficha.getLado1(), columna - 2, fila);
                    return true;
               }
          }
          return false;
     }

     private boolean colocarFichaDerecha(Ficha ficha, boolean extremo) {
          int fila = extremo ? arreglo.getExtremo1Fila() : arreglo.getExtremo2Fila();
          int columna = extremo ? arreglo.getExtremo1Columna() : arreglo.getExtremo2Columna();
          int lado = extremo ? arreglo.getExtremo1() : arreglo.getExtremo2();

          if (ficha.esMula() && ficha.getLado1() == lado && columna + 1 < obtenerTablero()[0].length && estaVacio(fila, columna + 1)) {
               obtenerTablero()[fila][columna + 1] = ficha.getLado1();
               actualizarExtremos(extremo, ficha.getLado1(), columna + 1, fila);
               return true;
          }

          if (columna + 2 < obtenerTablero()[0].length && estaVacio(fila, columna + 1) && estaVacio(fila, columna + 2)) {
               if (ficha.getLado1() == lado) {
                    obtenerTablero()[fila][columna + 1] = ficha.getLado1();
                    obtenerTablero()[fila][columna + 2] = ficha.getLado2();
                    actualizarExtremos(extremo, ficha.getLado2(), columna + 2, fila);
                    return true;
               }
               if (ficha.getLado2() == lado) {
                    obtenerTablero()[fila][columna + 1] = ficha.getLado2();
                    obtenerTablero()[fila][columna + 2] = ficha.getLado1();
                    actualizarExtremos(extremo, ficha.getLado1(), columna + 2, fila);
                    return true;
               }
          }
          return false;
     }

     private boolean colocarFichaArriba(Ficha ficha, boolean extremo) {
          int fila = extremo ? arreglo.getExtremo1Fila() : arreglo.getExtremo2Fila();
          int columna = extremo ? arreglo.getExtremo1Columna() : arreglo.getExtremo2Columna();
          int lado = extremo ? arreglo.getExtremo1() : arreglo.getExtremo2();

          if (ficha.esMula() && ficha.getLado1() == lado && fila - 1 >= 0 && estaVacio(fila - 1, columna)) {
               obtenerTablero()[fila - 1][columna] = ficha.getLado1();
               actualizarExtremos(extremo, ficha.getLado1(), columna, fila - 1);
               return true;
          }

          if (fila - 2 >= 0 && estaVacio(fila - 1, columna) && estaVacio(fila - 2, columna)) {
               if (ficha.getLado1() == lado) {
                    obtenerTablero()[fila - 1][columna] = ficha.getLado1();
                    obtenerTablero()[fila - 2][columna] = ficha.getLado2();
                    actualizarExtremos(extremo, ficha.getLado2(), columna, fila - 2);
                    return true;
               }
               if (ficha.getLado2() == lado) {
                    obtenerTablero()[fila - 1][columna] = ficha.getLado2();
                    obtenerTablero()[fila - 2][columna] = ficha.getLado1();
                    actualizarExtremos(extremo, ficha.getLado1(), columna, fila - 2);
                    return true;
               }
          }
          return false;
     }

     private boolean colocarFichaAbajo(Ficha ficha, boolean extremo) {
          int fila = extremo ? arreglo.getExtremo1Fila() : arreglo.getExtremo2Fila();
          int columna = extremo ? arreglo.getExtremo1Columna() : arreglo.getExtremo2Columna();
          int lado = extremo ? arreglo.getExtremo1() : arreglo.getExtremo2();

          if (ficha.esMula() && ficha.getLado1() == lado && fila + 1 < obtenerTablero().length && estaVacio(fila + 1, columna)) {
               obtenerTablero()[fila + 1][columna] = ficha.getLado1();
               actualizarExtremos(extremo, ficha.getLado1(), columna, fila + 1);
               return true;
          }

          if (fila + 2 < obtenerTablero().length && estaVacio(fila + 1, columna) && estaVacio(fila + 2, columna)) {
               if (ficha.getLado1() == lado) {
                    obtenerTablero()[fila + 1][columna] = ficha.getLado1();
                    obtenerTablero()[fila + 2][columna] = ficha.getLado2();
                    actualizarExtremos(extremo, ficha.getLado2(), columna, fila + 2);
                    return true;
               }
               if (ficha.getLado2() == lado) {
                    obtenerTablero()[fila + 1][columna] = ficha.getLado2();
                    obtenerTablero()[fila + 2][columna] = ficha.getLado1();
                    actualizarExtremos(extremo, ficha.getLado1(), columna, fila + 2);
                    return true;
               }
          }
          return false;
     }

     private void actualizarExtremos(boolean extremo, int numExtremo, int columna, int fila) {
          if (extremo) {
               actualizarExtremoIzquierdo(numExtremo, columna, fila);
          } else {
               actualizarExtremoDerecho(numExtremo, columna, fila);
          }
     }

     private void actualizarExtremoIzquierdo(int numExtremo, int columna, int fila) {
          arreglo.setExtremo1(numExtremo);
          arreglo.setExtremo1Columna(columna);
          arreglo.setExtremo1Fila(fila);
     }

     private void actualizarExtremoDerecho(int numExtremo, int columna, int fila) {
          arreglo.setExtremo2(numExtremo);
          arreglo.setExtremo2Columna(columna);
          arreglo.setExtremo2Fila(fila);
     }
}
