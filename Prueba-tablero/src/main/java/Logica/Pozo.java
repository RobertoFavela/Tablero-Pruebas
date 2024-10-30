/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author favel
 */
public class Pozo {

      private final ArrayList<Ficha> fichas;
      private int numeroFichasIniciales;

      /**
       * Constructor que inicializa la lista de fichas
       *
       * @param numeroFichasIniciales
       */
      public Pozo(int numeroFichasIniciales) {
            fichas = new ArrayList<>();
            this.numeroFichasIniciales = numeroFichasIniciales;
            crearFichasPozo();
      }

      /**
       * Método que agrega al pozo la lista de 28 fichas
       */
      private void crearFichasPozo() {
            for (int i = 0; i <= 6; i++) {
                  for (int j = i; j <= 6; j++) {
                        String rutaImagen = String.format("/imgPartidaFichas/ficha%d_%d.png", i, j);
                        URL ruta = getClass().getResource(rutaImagen);
                        if (ruta != null) {
                              Ficha ficha = new Ficha(i, j, ruta.toString());
                              fichas.add(ficha);
                        } else {
                              System.out.println("Imagen no encontrada para: " + rutaImagen);
                        }
                  }
            }
      }

      /**
       * MMetodo que retorna una ficha al azar y elimina la ficha del pozo
       *
       * @return Ficha al azar del pozo
       */
      public Ficha sacarFicha() {
            Random random = new Random();

            int posicion;

            Ficha ficha = null;

            if (!pozoVacío()) {
                  posicion = random.nextInt(0, fichas.size());
                  System.out.println(posicion);
                  ficha = fichas.get(posicion);
                  System.out.println(ficha);
                  fichas.remove(posicion);
            }

            return ficha;
      }

      public Ficha sacarFichaMula() {

            int posicion;

            Ficha ficha = null;

            if (!pozoVacío()) {
                  posicion = 27;
                  System.out.println(posicion);
                  ficha = fichas.get(posicion);
                  System.out.println(ficha);
                  fichas.remove(posicion);
            }

            return ficha;
      }

      /**
       * Metodo que regresa una lista de fichas al azar del pozo
       *
       * @return Lista con las fichas al azar del pozo
       */
      public List<Ficha> repartirFichas() {
            List<Ficha> fichasARepartir = new ArrayList<>();
            fichasARepartir.add(sacarFichaMula());
            for (int i = 0; i < numeroFichasIniciales; i++) {
                  fichasARepartir.add(sacarFicha());
            }

            return fichasARepartir;
      }

      /**
       * Metodo que nos dice si el pozo esta vacío
       *
       * @return true si el pozo esta vacío, false si contiene fichas
       */
      public boolean pozoVacío() {
            return fichas.isEmpty();
      }

      public void mostrarFichasRestantes() {
            if (pozoVacío()) {
                  System.out.println("El pozo está vacío.");
            } else {
                  System.out.println("Fichas restantes en el pozo:");
                  for (Ficha ficha : fichas) {
                        System.out.println(ficha);
                  }
            }
      }

      /**
       * Metodo para recibir fichas y agregarlas al pozo
       *
       * @param fichasJugador lista de fichas de una jugador que se desconecte
       * de la partida
       */
      public void recibirFichas(List<Ficha> fichasJugador) {

            for (Ficha ficha : fichasJugador) {
                  fichas.add(ficha);
            }
      }
}
