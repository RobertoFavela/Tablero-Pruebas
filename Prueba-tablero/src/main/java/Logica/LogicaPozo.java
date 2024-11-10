package Logica;

import Dominio.Ficha;
import Dominio.Pozo;
import java.util.List;

public class LogicaPozo {

    private final Pozo pozo;

    public LogicaPozo() {
        this.pozo = Pozo.obtenerInstancia(7); // Se obtiene la instancia única del Pozo
    }

    public Ficha sacarFicha() {
        return pozo.sacarFicha();
    }

    public List<Ficha> repartirFichas(int numeroFichas) {
        return pozo.repartirFichas(numeroFichas);
    }

    public void recibirFichas(List<Ficha> fichasJugador) {
        pozo.recibirFichas(fichasJugador);
    }
    
    public boolean pozoVacio() {
        return pozo.pozoVacío();
    }
}


