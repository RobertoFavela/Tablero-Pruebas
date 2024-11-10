/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Dominio.Pozo;
import Dominio.Jugador;
import Dominio.Arreglo;
import Logica.LogicaArreglo;
import MVC.TableroView;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pozo pozo = Pozo.obtenerInstancia(7); // Obtener la instancia única de Pozo

        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Favela");
        jugador.agregarFichas(pozo.repartirFichas(7));

        jugadores.add(jugador);
        Arreglo arreglo = new Arreglo();
        LogicaArreglo array = new LogicaArreglo(arreglo);
        TableroView view = new TableroView(array, jugador);
        view.setVisible(true);
    }
}

