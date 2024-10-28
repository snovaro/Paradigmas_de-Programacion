package org.example.Casilla;

import org.example.Banco;
import org.example.Jugador;
import org.example.Propiedades.Propiedad;

public class CasillaComprable implements Casilla {
    private final String nombre = "propiedad" ; // --> ESTO ES PARA PROBAR, ESTE NOMBRE SERA DEPENDIENDO DE LA PROPIEDAD
                                                // POR ENDE SERA UN propiedad.GetNombre();
    private Propiedad propiedad;
    private Banco banco;
    public CasillaComprable(Propiedad propiedad, Banco banco) {
        this.propiedad = propiedad;
        this.banco = banco;
    }
    @Override
    public void jugarCasilla(Jugador jugadorActual) {
        // podriamos agregar estados a las propiedades: Anulada, Comprada, NoComprada
        if (propiedad.getPropietario() != null && !propiedad.estaAnulada()) {
            propiedad.comprar(jugadorActual);// agregar comando opcional
        }
        else if(!this.propiedad.esPropietario(jugadorActual) && !propiedad.estaHipotecada()){
            banco.pagarAlquiler(jugadorActual, propiedad.getPropietario(), propiedad.getValorAlquiler()); // es otro comando pero obligatorio
        }
    }
    public String getNombre() {
        return nombre;
    }
}
