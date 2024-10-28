package org.example.Propiedades;

import org.example.Banco;
import org.example.Jugador;

public abstract class Propiedad implements Comprable {
    protected final int valorCompra;
    protected final int valorAlquiler;
    protected final int valorHipoteca;

    protected final String nombre;
    protected boolean estaHipotecado;
    protected Jugador propietario;
    protected boolean estaAnulada;

    protected Banco banco;

    public Propiedad(int valorCompra, int valorHipoteca, int valorAlquiler, String nombre, Banco banco) {
        this.valorCompra = valorCompra;
        this.valorAlquiler = valorAlquiler;
        this.valorHipoteca = valorHipoteca;
        this.nombre = nombre;
        this.propietario = null;
        this.estaHipotecado = false;
        this.estaAnulada = false;
        this.banco = banco;
    }
    private void setPropietario(Jugador jugador){
        this.propietario = jugador;
    }
    public boolean tienePropietario(){
        return this.propietario != null;
    }
    public Jugador getPropietario(){
        /*if(!tienePropietario()){
            return  null;
        }*/
        return this.propietario;//en teoria si no tiene, ya va a ser null
    }
    public boolean esPropietario(Jugador jugador){
        return this.propietario.getColor().equals(jugador.getColor());
    }
    public boolean estaHipotecada(){
        return this.estaHipotecado;
    }
    public void hipotecar(){
        estaHipotecado = true;
        banco.pagar(propietario, valorHipoteca);
    };
    public abstract int getValorAlquiler();
    public void anular(){
        this.estaAnulada = true;
    }
    public boolean estaAnulada() {
        return this.estaAnulada;
    }
    public void Comprar(Jugador jugador){
        this.propietario = jugador;
        this.banco.cobrar(jugador, valorCompra);
        jugador.agregarPropiedad(this);//esto se salva de la dependencia circular gracias a la interfaz comprable?
    }
}
