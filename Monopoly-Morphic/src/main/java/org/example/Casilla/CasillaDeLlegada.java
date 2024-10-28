package org.example.Casilla;

import org.example.Jugador;

public class CasillaDeLlegada implements Casilla {
    private int montoADar;
    private final String nombre = "llegada";
    public CasillaDeLlegada(int montoDeLlegadaFinal) {
        this.montoADar = montoDeLlegadaFinal;
    }


    @Override
    public void jugarCasilla(Jugador unJugador) {
        //Dar dinero inicial al jugador
    }

    public String getNombre() {
        return this.nombre;
    }
}
