package org.example;

import org.example.Estado.EnJuego;
import org.example.Estado.EstadoJugador;
import org.example.Estado.Quebrado;
import org.example.Propiedades.Comprable;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private final String nombre;
    private final String color;
    private int posicionActual;
    private EstadoJugador estado;
    private List<Comprable> propiedades;
    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.posicionActual = 0;
        this.propiedades = new ArrayList<>();
    }
    public int getPosicion() {
        return this.posicionActual;
    }
    public void setPosicion(int posicionNueva) {
        this.posicionActual = posicionNueva;
    }
    public void agregarPropiedad(Comprable propiedad){
        this.propiedades.add(propiedad);
    }

    public String getColor(){
        return this.color;
    }

    public List<Comprable> getPropiedades() {
        return this.propiedades;
    }
    public void setEstado(EstadoJugador estadoNuevo) {
        this.estado = estadoNuevo;
    }
    public void eliminarPropiedades() {
        this.propiedades = null;
    }
    public String jugarSegunEstado(Tablero tablero) {
        return this.estado.efectoEstado(tablero);
    }
}
