
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;

public class ControlJuego {

    private List<Jugador> jugadores;
    private Array tablero;

    public ControlJuego(List<Jugador> jugadores, Array tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
    }

//    public void colocarMulaMasAlta() {
//        Ficha mulaMasAlta = null;
//        Jugador jugadorConMula = null;
//
//        for (Jugador jugador : jugadores) {
//            for (Ficha ficha : jugador.getFichas()) {
//                if (ficha.esMula()) {
//                    if (mulaMasAlta == null || ficha.getLado1() > mulaMasAlta.getLado1()) {
//                        mulaMasAlta = ficha;
//                        jugadorConMula = jugador;
//                    }
//                }
//            }
//        }
//
//        if (mulaMasAlta != null && jugadorConMula != null) {
//            int filaCentro = tablero.obtenerTablero().length / 2;
//            int columnaCentro = tablero.obtenerTablero()[0].length / 2;
//
//            if (filaCentro < tablero.obtenerTablero().length && columnaCentro < tablero.obtenerTablero()[0].length) {
//                tablero.colocarFichaHorizontal(mulaMasAlta);
//                tablero.setExtremo1(mulaMasAlta.getLado1());
//                tablero.setExtremo2(mulaMasAlta.getLado2());
//                
//                Ficha fichaAEliminar = null;
//                for (Ficha ficha : jugadorConMula.getFichas()) {
//                    if (ficha.getLado1() == mulaMasAlta.getLado1() && ficha.getLado2() == mulaMasAlta.getLado2()) {
//                        fichaAEliminar = ficha;
//                        break;
//                    }
//                }
//
//                // Remover la ficha si la encontramos
//                if (fichaAEliminar != null) {
//                    jugadorConMula.getFichas().remove(fichaAEliminar);
//
//                }
//
//                System.out.println("mula más alta de: "
//                        + jugadorConMula.getNombre() + " ficha: "
//                        + mulaMasAlta.getLado1() + "-" + mulaMasAlta.getLado2());
//            } else {
//                System.out.println("no jalo.");
//            }
//        }
//
//    }

//    public boolean validarJuntarFichas(Ficha ficha,int x, int y){
//        return false;
//    }
}
