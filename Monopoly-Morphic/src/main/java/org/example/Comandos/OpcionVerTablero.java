package org.example.Comandos;

import org.example.Juego;
import org.example.Jugador;
import org.example.ModelView.JuegoView;

public class OpcionVerTablero implements Comando{
    @Override
    public void aplicarJugabilidadDeComando(JuegoView juegoView) {

        juegoView.mostrarTablero();
    }
}
