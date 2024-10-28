package org.example;

import org.example.Estado.EstadoJugador;
import org.example.Estado.Quebrado;

import java.util.HashMap;
import java.util.List;

public class Banco {
    private final int fianza;

    private final int vueltaTablero;

    private HashMap<Jugador, Integer> billeteras;

    public Banco(int montoDeLibertad, int montoInicioJuego, int montoDeLlegadaFinal, List<Jugador> jugadores) {
        this.fianza = montoDeLibertad;
        this.vueltaTablero = montoDeLlegadaFinal;
        this.billeteras = new HashMap<>();
        for (Jugador jugador : jugadores){
            billeteras.put(jugador, montoInicioJuego);
        }
    }
    public void cobrar(Jugador jugador, int cobro) {
        billeteras.put(jugador, billeteras.get(jugador) - cobro);
        chequearQuiebraJugador(jugador);
    }
    public void pagar(Jugador jugador, int ganancia) {
        billeteras.put(jugador, billeteras.get(jugador) + ganancia);
        chequearQuiebraJugador(jugador);
    }
    public void pagarVueltaTablero(Jugador jugador) {
        pagar(jugador, vueltaTablero);
    }

    private void chequearQuiebraJugador(Jugador jugador){
        if (this.billeteras.get(jugador) < 0){
            new Quebrado().activarEstado(jugador);
        }
    }
    public void pagarAlquiler(Jugador inquilino, Jugador propietario, int valorAlquiler) {
        pagar(propietario, valorAlquiler);
        cobrar(inquilino, valorAlquiler);
    }
    public void cobrarFianza(Jugador jugador){
        cobrar(jugador, fianza);
    }
}

