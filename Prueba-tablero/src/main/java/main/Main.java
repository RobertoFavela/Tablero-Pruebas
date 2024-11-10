/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Dominio.Pozo;
import Dominio.Jugador;
import Dominio.Arreglo;
import Logica.LogicaArreglo;
import Logica.LogicaPozo;
import MVC.TableroView;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        
         LogicaPozo  pozo = new LogicaPozo();
        
        
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Favela");
        jugador.agregarFichas(pozo.repartirFichas(7));

        jugadores.add(jugador);
        LogicaArreglo array = new LogicaArreglo();
        
        
        TableroView view = new TableroView(array, pozo, jugador);
        view.setVisible(true);
    }
}

