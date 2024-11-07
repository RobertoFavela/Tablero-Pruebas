/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Dominio.Arreglo;
import Dominio.Jugador;
import Dominio.Pozo; // Asegúrate de importar la clase Array
import Logica.LogicaArreglo;
import java.util.ArrayList;
import java.util.List;
import MVC.TableroView;

public class Main {
     public static Pozo pozo;
    public static void main(String[] args) {
           pozo = new Pozo(7); 

        List<Jugador> Jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Favela");
        
        jugador.agregarFichas(pozo.repartirFichas());

        Jugadores.add(jugador);
        Arreglo arreglo = new Arreglo();
        LogicaArreglo array = new LogicaArreglo(arreglo); 
        TableroView view = new TableroView(array, jugador); 
        view.setVisible(true); 
    }
}
