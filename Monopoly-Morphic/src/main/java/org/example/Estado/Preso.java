package org.example.Estado;

import org.example.Banco;
import org.example.Jugador;
import org.example.Tablero;

public class Preso implements EstadoJugador {

    private final Banco banco;
    private int turnosCondena;
    private Jugador jugador;
    public Preso(Banco banco) {
        this.banco = banco;
        this.turnosCondena = 4;//podria ser constante
    }
    private void liberarJugador() {
        if (this.turnosCondena == 0) {
            EnJuego nuevoEstado = new EnJuego(banco);
            nuevoEstado.activarEstado(jugador);
        }
    }

    private void pagarFianza() {
        banco.cobrarFianza(jugador);
        this.turnosCondena = 0;// no agrego el liberar jugador pq ya esta luego de llamar pagarMulta()
    }

    @Override
    public String efectoEstado(Tablero tablero) {
        this.jugador.setPosicion(tablero.getPosicionComisaria());
        pagarFianza(); // agregar comando opcional
        liberarJugador();
        this.turnosCondena -= 1;// si llega aca y el jugador sigue teniendo de estado Preso pierde el turno
        return null;
    }
    public void activarEstado(Jugador jugador){
        jugador.setEstado(this);
        this.jugador = jugador;
    };
}
