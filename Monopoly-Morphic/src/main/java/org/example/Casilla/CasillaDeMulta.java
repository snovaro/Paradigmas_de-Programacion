package org.example.Casilla;

import org.example.Banco;
import org.example.Jugador;

public class CasillaDeMulta implements Casilla {

    private final String nombre = "multa" ;
    private int multa;
    private Banco banco;
    public CasillaDeMulta(int monto, Banco banco){
        this.multa = monto;
        this.banco = banco;
    }
    @Override
    public void jugarCasilla(Jugador jugadorActual) {
        banco.cobrar(jugadorActual, multa); // ingresarlo como comando, pero es obligatorio que lo haga
    }
    public String getNombre() {
        return nombre;
    }
}
