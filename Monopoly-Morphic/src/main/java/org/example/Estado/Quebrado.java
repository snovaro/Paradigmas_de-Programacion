package org.example.Estado;

import org.example.Jugador;
import org.example.Propiedades.Comprable;
import org.example.Tablero;

import java.util.List;

import static org.example.Constantes.JUGADOR_PERDIO;

public class Quebrado implements EstadoJugador {

    private Jugador jugador;

    @Override
    public String efectoEstado(Tablero tablero) {
        anularPropiedades();
        jugador.eliminarPropiedades();//es necesario si ya de por si no va a volver a jugar este jugador?
        return JUGADOR_PERDIO;
    }
    private void anularPropiedades(){
        List<Comprable> comprables = jugador.getPropiedades();
        for (Comprable propiedad : comprables) {//Como comprable es interdaz, no hay dependencia circular
            propiedad.anular();
        }
    }
    public void activarEstado(Jugador jugador){
        this.jugador = jugador;
        jugador.setEstado(this);
        anularPropiedades();
        jugador.eliminarPropiedades(); //es necesario si ya de por si no va a volver a jugar este jugador?
    }
}
