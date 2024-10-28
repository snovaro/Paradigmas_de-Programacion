package org.example;

import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private int jugadorActual;
    private final boolean juegoFinalizado = false;
    public Juego(ConfiguracionDePartida configuracion){
        this.jugadores = configuracion.getJugadores();
        this.jugadorActual = -1;
        this.tablero = configuracion.getTablero();
    }
    public String jugarTurno(){
        this.calcularJugadorActual();
        Jugador jugador = this.jugadores.get(jugadorActual);
        return jugador.jugarSegunEstado(this.tablero);
    }
    private void calcularJugadorActual() {
        this.jugadorActual += 1;
        this.jugadorActual = this.jugadorActual % this.jugadores.size();
    }
    public boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }

    public int posicionDeJugadorActual() {
        Jugador jugador = this.jugadores.get(this.jugadorActual);
        return jugador.getPosicion();
    }

    public Tablero getTablero() {
        return this.tablero;
    }
}
