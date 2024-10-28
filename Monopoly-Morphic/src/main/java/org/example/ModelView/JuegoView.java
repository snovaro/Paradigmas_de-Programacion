package org.example.ModelView;

import org.example.Juego;

import static org.example.Constantes.*;

public class JuegoView {

    private Juego unJuego;
    private TableroView  tableroView;

    public JuegoView(Juego juego){
        this.unJuego = juego;
        this.tableroView = new TableroView(this.unJuego.getTablero());
    }

    public void mostrarMenuNormal() {

        System.out.println(ANSI_VERDE);
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      MENU DE OPCIONES        ║");
        System.out.println("║══════════════════════════════║");
        System.out.println("║                              ║");
        System.out.println("║ 1 => Terminar Turno          ║");
        System.out.println("║                              ║");
        System.out.println("║ 2 => Contruir Propiedades    ║ ");
        System.out.println("║                              ║");
        System.out.println("║ 3 => Vender Construcciones   ║");
        System.out.println("║                              ║ ");
        System.out.println("║ 4 => Hipotecar Propiedad     ║");
        System.out.println("║                              ║");
        System.out.println("║ 5 => Deshipotecar Propiedad  ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println(ANSI_RESET);

         // COMPRAR UNA PROPIEDAD SERA POR INPUT CUANDO DESEE COMPRAR SI DICE QUE NO LE MOSTRAREMOS ESTE MENU
         // PAGAR FIANZA SE LE PREGUNTARA CUANDO ESTE EN COMISARIA SI LE DICE QUE NO SE MOSTRARA ESTE MENU

        //System.out.println(ANSI_GRISCLARO);
        //System.out.println("TURNO: " + this.jugadorView.mostrarNombre());
        System.out.println("\nSELECCIONE UNA OPCION: ");
        System.out.println(ANSI_RESET);
    }
    public void mostrarMenuPreso() {

        System.out.println(ANSI_VERDE);
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║  MENU DE OPCIONES PARA PRESO ║");
        System.out.println("║══════════════════════════════║");
        System.out.println("║                              ║");
        System.out.println("║ 1 => Terminar Turno          ║");
        System.out.println("║                              ║");
        System.out.println("║ 2 => Pagar Fianza            ║ ");
        System.out.println("║                              ║");;
        System.out.println("╚══════════════════════════════╝");
        System.out.println(ANSI_RESET);

        // COMPRAR UNA PROPIEDAD SERA POR INPUT CUANDO DESEE COMPRAR SI DICE QUE NO LE MOSTRAREMOS ESTE MENU
        // PAGAR FIANZA SE LE PREGUNTARA CUANDO ESTE EN COMISARIA SI LE DICE QUE NO SE MOSTRARA ESTE MENU

        //System.out.println(ANSI_GRISCLARO);
        //System.out.println("TURNO: " + this.jugadorView.mostrarNombre());
        System.out.println("\nSELECCIONE UNA OPCION: ");
        System.out.println(ANSI_RESET);
    }

    public void mostrarTablero() {
        this.tableroView.mostrarTablero();
    }

    public void mostrarCasilla(){
        int pos = this.unJuego.posicionDeJugadorActual();
        this.tableroView.mostrarCasilla(pos);
    }

    public void mostrarMenu(String menu) {
        if(menu.equals(MENU_NORMAL)){
            this.mostrarMenuNormal();
        }else if(menu.equals(MENU_PRESO)){
            this.mostrarMenuPreso();
        }else{
            // MOSTRAR ESTE JUGADOR PERDIO EN SU TURNO
            //luego de mostrar esto se tendra que quitar de la lista de jugadores
        }
    }
}
