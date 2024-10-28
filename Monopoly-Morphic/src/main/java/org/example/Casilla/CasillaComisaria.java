package org.example.Casilla;

import org.example.Jugador;

public class CasillaComisaria implements Casilla {

    private int montoDeFianza;
    private final String nombre = "comisaria";

    public CasillaComisaria(int montoDeFianza) {
        this.montoDeFianza = montoDeFianza;
    }

    @Override
    public void jugarCasilla(Jugador unJugador) {

    }
    public String getNombre() {
        return nombre;
    }
}
