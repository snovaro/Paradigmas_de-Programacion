package org.example.ModelView.CasillaView;

import org.example.Casilla.Casilla;

import static org.example.Constantes.*;

public class CasillaLoteriaView implements CasillaView{

    private Casilla unaCasilla;

    public CasillaLoteriaView(Casilla unaCasilla) {
        this.unaCasilla = unaCasilla;
    }

    @Override
    public void mostrarContenidoDeCasilla() {

        System.out.println(ANSI_AMARILLO);
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║    $$$ CASILLA LOTERIA $$$    ║");
        System.out.println("║═══════════════════════════════║");
        System.out.println("║                               ║");
        System.out.println("║ Descripcion: El banco te dara ║");
        System.out.println("║              200 de dinero    ║");
        System.out.println("║                               ║ ");
        System.out.println("║                               ║");
        System.out.println("║     ¡¡¡ QUE SUERTE !!!        ║");
        System.out.println("║                               ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println(ANSI_RESET);
    }
}
