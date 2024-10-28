package org.example.Propiedades;

public class GrupoPropiedad {
    private final int cantidad;
    private final String nombre;

    public GrupoPropiedad(String nombreGrupo, int cantGrupo) {
        this.nombre = nombreGrupo;
        this.cantidad = cantGrupo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void agregarPropiedad(Propiedad propiedad) {

    }
    public boolean verificarMismoDueño(){
        return false;
    }
}
