package org.example.Propiedades;

import org.example.Banco;
import org.example.Jugador;

public class Hospedaje extends Propiedad {
    private GrupoPropiedad grupo;
    private int valorCompra;
    private int valorAlquiler;
    private boolean tienePropietario;
    private boolean estaHipotecado;
    private Jugador propietario;
    private int cantidadCasas;
    private int cantidadHotel;
    private final int MAXIMOHOTELES = 1;

    public Hospedaje(int valorCompra,int valorHipoteca, int valorAlquiler, String nombre, GrupoPropiedad grupo, Banco banco) {
        super(valorCompra, valorHipoteca, valorAlquiler, nombre, banco);
        this.grupo = grupo;
        this.cantidadCasas = 0;
        this.cantidadHotel = 0;
    }
    @Override
    public void comprar(Jugador jugador) {

    }

    @Override
    public void cobrar(Jugador unJugador) {

    }

    @Override
    public int getValorCompra() {
        return this.valorCompra;
    }

    public void comprarCasa(){
        if(validarConstruccionCasa()){
            cantidadCasas += 1;
        }
    }
    public void comprarHotel(){
        if(validarConstruccionHotel()){
            cantidadHotel += 1;
        }
    }
    private boolean validarConstruccionCasa() {
        return cantidadCasas<4 && cantidadHotel < MAXIMOHOTELES && grupo.verificarMismoDueño();
        //habria que ver como hacer que grupo pueda ver todos los dueños pero que a la vez las propiedades puedan saber su grupo
    }
    private boolean validarConstruccionHotel() {
        return false;
    }

    @Override
    public int getValorAlquiler() {
        return valorAlquiler;
    }//+ valorPorCasa*cantidadCasas+ valorHoteles*cantidadHoteles

}
