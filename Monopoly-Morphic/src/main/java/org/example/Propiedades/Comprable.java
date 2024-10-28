package org.example.Propiedades;

import org.example.Jugador;

public interface Comprable {
    public void comprar(Jugador unJugador);
    public boolean tienePropietario();
    public void cobrar(Jugador unJugador);
    int getValorCompra();
    public void anular();
}
