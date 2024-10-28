package org.example;

import org.example.Casilla.Casilla;
import org.example.Propiedades.GrupoPropiedad;

import java.util.HashMap;
import java.util.List;

public class Tablero {
    private final int cantCasillas;
    private final List<GrupoPropiedad> propiedades;
    private final int posicionComisaria;
    private HashMap<Integer, Casilla> casillas;
    public Tablero(HashMap<Integer, Casilla> casillas, List<GrupoPropiedad> propiedades, int pos_comisaria) {
        this.casillas = casillas;
        this.cantCasillas = casillas.size();
        this.propiedades = propiedades;
        this.posicionComisaria = pos_comisaria;
    }
    public Casilla getCasilla(Integer posicion){
        return this.casillas.get(posicion);
    }
    public int getCantCasillas() {
        return this.cantCasillas;
    }
    public int getPosicionComisaria() {
        return this.posicionComisaria;
    }
}
