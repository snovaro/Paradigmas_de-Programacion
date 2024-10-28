package org.example.Casilla;

import org.example.Banco;
import org.example.Estado.EstadoJugador;
import org.example.Estado.Preso;
import org.example.Jugador;

public class CasillaIrPreso implements Casilla {

    private final String nombre = "irPreso";

    private Banco banco;
    public CasillaIrPreso(Banco banco){
        this.banco = banco;
    }
    @Override
    public void jugarCasilla(Jugador jugadorActual) {
        new Preso(banco).activarEstado(jugadorActual);
    }
    public String getNombre() {
        return nombre;
    }
}
