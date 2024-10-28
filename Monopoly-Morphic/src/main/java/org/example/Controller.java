package org.example;

import org.example.Comandos.Comando;
import org.example.ModelView.JuegoView;

import java.util.HashMap;

import static org.example.Constantes.*;

public class Controller {
    private Juego juego;
    private JuegoView juegoView;
    private HashMap<String, Comando> opcionesDisponibles;
    private HashMap<String, Comando> opcionesDisponiblesPreso;

    public Controller() {
        ServicioDePrints.mostrarMensajeBienvenida();
        ServicioDeUserInput.inicializarScanner();
        this.juego = this.pedirLosDatosAlCliente();
        this.juegoView = new JuegoView(this.juego);
    }

    public int pedirNumeroDeJugadores(){
        boolean numeroDeParticipantesValido = false;
        Integer numeroDeParticipantes = null;
        while(!numeroDeParticipantesValido){
            ServicioDePrints.mensajeNumeroDeParticipantes();
            System.out.print(ANSI_VERDEOSCURO + "Ingrese el numero de participantes de 2 a 4: " + ANSI_RESET);
            String unInput = ServicioDeUserInput.input();
            if(unInput.matches(ES_NUMERO)){
                numeroDeParticipantes =Integer.parseInt(unInput);
                if(numeroDeParticipantes >= MINIMO_PARTICIPANTES && numeroDeParticipantes <= MAXIMO_PARTICIPANTES){
                    numeroDeParticipantesValido = true;
                }else{
                    //ServicioDePrints.mensajeNumeroDeParticipantes();
                    System.out.println("\n");
                    System.out.println(ANSI_ROJO + "ERROR: EL NUMERO ES INVALIDO: " + ANSI_RESET);
                    System.out.println("\n");
                }

            }else{
                System.out.println("\n");
                System.out.println(ANSI_ROJO + "ERROR: LA ENTRADA NO ES UN NUMERO: " + ANSI_RESET);
                System.out.println("\n");
            }
        }
        return numeroDeParticipantes;
    }
    private HashMap<String, String> pedirNombresDeJugadoresYColor(int numerosDeParticipantes) {
        HashMap<String, String> coloresYsuNombre = new HashMap<String, String>() {{
            put("rojo", null);
            put("verde", null);
            put("amarillo", null);
            put("azul", null);
        }};
        for (int i = 0; i < numerosDeParticipantes ; i++) {
            ServicioDePrints.mostrarColoresDisponibles();
            System.out.print(ANSI_VERDEOSCURO + "Ingrese solo su nombre: " + ANSI_RESET);
            String unNombreDeJugador =ServicioDeUserInput.input();
            boolean colorValido = false;
            while(!colorValido){
                System.out.print(ANSI_VERDEOSCURO + "Ingrese un color no usado: " + ANSI_RESET);
                String unColor =ServicioDeUserInput.input().toLowerCase();
                if(coloresYsuNombre.containsKey(unColor) && (coloresYsuNombre.get(unColor) == null)){
                    colorValido = true;
                    coloresYsuNombre.put(unColor,unNombreDeJugador);
                    ServicioDePrints.saltosDeLinea(2);
                    ServicioDePrints.mensajeDeBienvenida(unColor,unNombreDeJugador.toUpperCase());
                }else{
                    System.out.println(ANSI_ROJO + "ERROR: EL COLOR ES INVALIDO O ESTA EN USO: " + ANSI_RESET);
                }
            }
        }
        return coloresYsuNombre;
    }

    private Juego pedirLosDatosAlCliente(){
        int numeroDeParticipantes = this.pedirNumeroDeJugadores();
        HashMap<String,String> coloresYsuNombre = this.pedirNombresDeJugadoresYColor(numeroDeParticipantes);
        ConfiguracionDePartida unaConfiguracion = new ConfiguracionDePartida(coloresYsuNombre);
        return new Juego(unaConfiguracion);
    }
    public void desarrollarJuego(){
        this.juegoView.mostrarTablero();
        while(!this.juego.isJuegoFinalizado()){
            String menu = this.juego.jugarTurno(); // SE MOVERA EL JUGADOR AUTOMATICAMENTE y se le aplicara el efecto de la casilla
                                     // esto dependiendo segun  su estado;
            this.juegoView.mostrarCasilla();//mostramos la casilla , para indicar que callo en esta
            this.juegoView.mostrarMenu(menu); // mostrara que tipo de menu tiene cada jugador
            this.pedirOpcion(menu); // pedira la opcion segun el menu elegido e invocara el comando
            //

        }
    }

    private void pedirOpcion(String menu) {
        if(!menu.equals(JUGADOR_PERDIO)){
            boolean decisionValida = false;
            HashMap<String, Comando> opciones = menu.equals(MENU_NORMAL) ? this.opcionesDisponibles : this.opcionesDisponiblesPreso;
            while(!decisionValida){
                System.out.print(ANSI_VERDEOSCURO + "Elija una de las opciones: " + ANSI_RESET);
                String opcion =ServicioDeUserInput.input();
                if (this.validarOpcion(opciones, opcion)) {
                    Comando unComando = opciones.get(opcion);
                    unComando.aplicarJugabilidadDeComando(this.juegoView); // le paso view para tener la info de como graficar
                                                                           // digamos que quiero comprar una casa, tengo que graficar que propiedad es
                    decisionValida = true;
                }else{
                    System.out.println(ANSI_ROJO + "ERROR: La opcion elegida no se encuentra, vuelva a elegir!!! " + ANSI_RESET);
                }
            }
        }
    }
    private boolean validarOpcion(HashMap<String,Comando> opciones, String unaOpcion){
        return  opciones.containsKey(unaOpcion);
    }

}
