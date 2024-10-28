package org.example.Estado;

import org.example.Banco;
import org.example.Casilla.Casilla;
import org.example.Jugador;
import org.example.Tablero;

import java.util.Random;

public class EnJuego implements EstadoJugador {
    private final Banco banco;
    private Tablero tablero;
    private Jugador jugador;
    public EnJuego(Banco banco){
        this.banco = banco;
    }
    private int lanzarDado(){
        return new Random().nextInt(6)+1;
    }
    private void avanzar(int pasos){
        this.jugador.setPosicion(pasos);
    }
    private void verificarPosicion() {
        int pos = this.jugador.getPosicion();
        int cantCasillas = this.tablero.getCantCasillas();
        if(pos >= cantCasillas){
            this.jugador.setPosicion(pos - cantCasillas);
            this.banco.pagarVueltaTablero(this.jugador);
        }
    }
    private void caeEnCasilla() {
        int posicionActual = this.jugador.getPosicion();
        Casilla casilla = this.tablero.getCasilla(posicionActual);
        if(casilla != null){
            casilla.jugarCasilla(jugador);
        }
    }
    @Override
    public String efectoEstado(Tablero tablero) {
        this.tablero = tablero;
        int resultadoDados = this.lanzarDado();
        this.avanzar(resultadoDados);
        this.verificarPosicion();
        this.caeEnCasilla();
        return "opciones";
    }
    public void activarEstado(Jugador jugador){
        jugador.setEstado(this);
        this.jugador = jugador;
    };
}
