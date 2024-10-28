package org.example.Propiedades;

import org.example.Banco;
import org.example.Jugador;

public class Transporte extends Propiedad {
    private int cantEstaciones;
    private int multiplicadorPorEstacion;

    public Transporte(String nombre, int valorCompra, int valorHipoteca, int valorAlquilerBasico, String nombreDeEstacion, Banco banco, int numeroDeEstaciones, int aumentoPorEstacion) {//valorAlquilerBasico seria el alquiler solo teniendo una estacion
        super(valorCompra, valorHipoteca, valorAlquilerBasico, nombreDeEstacion, banco);
        this.cantEstaciones = numeroDeEstaciones;
        this.multiplicadorPorEstacion = aumentoPorEstacion;
    }

    @Override
    public void comprar(Jugador unJugador) {
        this.propietario = unJugador;
        banco.cobrar(unJugador, valorCompra);
        unJugador.agregarPropiedad(this);
    }

    @Override
    public void cobrar(Jugador unJugador) {
        banco.pagarAlquiler(unJugador, this.propietario, getValorAlquiler());
    }
    @Override
    public int getValorCompra() {
        return valorCompra;
    }
    @Override
    public int getValorAlquiler(){//podria ser privado
        return this.valorAlquiler*multiplicadorPorEstacion;
    }//nose si seria multiplicar la verdad
}
