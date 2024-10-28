package org.example.Casilla;

import org.example.Banco;
import org.example.Jugador;

public class CasillaDeLoteria implements Casilla {
    private final String nombre = "loteria" ;
    private int premio;
    private Banco banco;
    public CasillaDeLoteria(int monto, Banco banco){
        this.premio = monto;
        this.banco = banco;
    }
    @Override
    public void jugarCasilla(Jugador jugadorActual) {
        banco.pagar(jugadorActual, premio); // no es un comando, lo ejecuta sin preguntar
    }

    public String getNombre() {
        return nombre;
    }
}
