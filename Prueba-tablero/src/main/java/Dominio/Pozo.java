package Dominio;

import java.util.ArrayList;

public class Pozo {

    private static Pozo instancia; // Instancia única del singleton
    private final ArrayList<Ficha> fichas;

    private Pozo() {
        fichas = new ArrayList<>();
    }

    public static Pozo obtenerInstancia() {
        if (instancia == null) {
            instancia = new Pozo();
        }
        return instancia;
    }

    // Mantener solo el getter de fichas si es necesario, y cualquier otra lógica que no sea específica del juego
    public ArrayList<Ficha> obtenerFichas() {
        return fichas;
    }
}



