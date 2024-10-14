/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Logica.Array;
import Logica.Jugador;
import Logica.Pozo; // Asegúrate de importar la clase Array
import java.util.ArrayList;
import java.util.List;
import view.TableroView;

public class Main {
    public static void main(String[] args) {
        Pozo pozo = new Pozo(7); 

        List<Jugador> Jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Favela");
        
        jugador.agregarFichas(pozo.repartirFichas());

        Jugadores.add(jugador);
        Array array = new Array(); 

        TableroView view = new TableroView(array, Jugadores); 
        view.setVisible(true); 
    }
}
