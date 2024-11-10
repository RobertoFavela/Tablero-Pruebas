package Logica;

import Dominio.Ficha;
import Dominio.Pozo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicaPozo {

    private final Pozo pozo;

    public LogicaPozo() {
        this.pozo = Pozo.obtenerInstancia();
        crearFichasPozo();
    }

    private void crearFichasPozo() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha ficha = new Ficha(i, j);
                pozo.obtenerFichas().add(ficha);
            }
        }
    }

    public Ficha sacarFicha() {
        Random random = new Random();
        if (!pozoVacio()) {
            int posicion = random.nextInt(pozo.obtenerFichas().size());
            Ficha ficha = pozo.obtenerFichas().get(posicion);
            pozo.obtenerFichas().remove(posicion);
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

    public void recibirFichas(List<Ficha> fichasJugador) {
        pozo.obtenerFichas().addAll(fichasJugador);
    }

    public boolean pozoVacio() {
        return pozo.obtenerFichas().isEmpty();
    }
}



