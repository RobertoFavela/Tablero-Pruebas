
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Dominio.Jugador;
import Dominio.Array;
import java.util.List;

public class ControlJuego {

    private List<Jugador> jugadores;
    private Array tablero;

    public ControlJuego(List<Jugador> jugadores, Array tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
    }
}
