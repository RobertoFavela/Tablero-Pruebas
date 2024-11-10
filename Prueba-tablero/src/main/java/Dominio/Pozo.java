package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pozo {

    private static Pozo instancia; // Instancia única del singleton
    private final ArrayList<Ficha> fichas;
    private int numeroFichasIniciales;

    /**
     * Constructor privado para inicializar el singleton
     *
     * @param numeroFichasIniciales Número inicial de fichas a repartir
     */
    private Pozo(int numeroFichasIniciales) {
        fichas = new ArrayList<>();
        this.numeroFichasIniciales = numeroFichasIniciales;
        crearFichasPozo();
    }

    /**
     * Método para obtener la instancia única del Pozo
     * 
     * @param numeroFichasIniciales Número inicial de fichas
     * @return Instancia única de Pozo
     */
    public static Pozo obtenerInstancia(int numeroFichasIniciales) {
        if (instancia == null) {
            instancia = new Pozo(numeroFichasIniciales);
        }
        return instancia;
    }

    // Métodos de la clase, como crearFichasPozo(), repartirFichas(), sacarFicha()...
    private void crearFichasPozo() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha ficha = new Ficha(i, j);
                fichas.add(ficha);
            }
        }
    }

    public Ficha sacarFicha() {
        Random random = new Random();
        if (!pozoVacío()) {
            int posicion = random.nextInt(fichas.size());
            Ficha ficha = fichas.get(posicion);
            fichas.remove(posicion);
            return ficha;
        }
        return null;
    }

    public List<Ficha> repartirFichas(int numeroFichas) {
        List<Ficha> fichasARepartir = new ArrayList<>();
        for (int i = 0; i < numeroFichas; i++) {
            Ficha ficha = sacarFicha();
            if (ficha != null) {
                fichasARepartir.add(ficha);
            }
        }
        return fichasARepartir;
    }

    public boolean pozoVacío() {
        return fichas.isEmpty();
    }
    
    public void recibirFichas(List<Ficha> fichasJugador) {
        fichas.addAll(fichasJugador);
    }
}


