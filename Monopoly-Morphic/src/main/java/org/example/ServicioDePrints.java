package org.example;


import java.util.HashMap;

import static org.example.Constantes.*;

public class ServicioDePrints {

    private static final HashMap<String,String> coloresDeNombres = new HashMap<>();
    static {
        coloresDeNombres.put("rojo",ANSI_ROJO);
        coloresDeNombres.put("amarillo",ANSI_AMARILLO);
        coloresDeNombres.put("verde",ANSI_VERDE);
        coloresDeNombres.put("azul",ANSI_AZUL);
    }


    public static void saltosDeLinea(int numeroDeSaltos){
        for (int i = 0; i < numeroDeSaltos ; i++) {
            System.out.println("\n");
        }
    }

    private static void rellenarSegunElNombre(String unNombre,boolean superior){
        for (int i = 0; i < unNombre.length(); i++) {
            System.out.print("═");
        }
        if(superior){
            System.out.println("╗");
        }else{
            System.out.println("╝" + ANSI_RESET);
        }
    }
    public static void mensajeDeBienvenida(String unColor,String nombre){
        System.out.print(ANSI_VIOLETA + "╔═════════════════════════");
        rellenarSegunElNombre(nombre,true);//10 espacios borrados
        System.out.println("║ " + ANSI_BLANCO + "BIENVENIDO/A  AL JUEGO " + coloresDeNombres.get(unColor) + nombre + ANSI_VIOLETA +" ║");
        System.out.print("╚═════════════════════════");
        rellenarSegunElNombre(nombre,false);
    }

    public static void mensajeNumeroDeParticipantes() {
        saltosDeLinea(1);
        System.out.println(ANSI_VIOLETA + "╔════════════════════════════════╗");
        System.out.println("║ Elección de Numero de Jugadores║ ");
        System.out.println("╚════════════════════════════════╝" + ANSI_RESET);
        saltosDeLinea(1);
    }

    public static void mostrarColoresDisponibles(){
        saltosDeLinea(2);
        System.out.println(ANSI_VIOLETA + "╔═══════════════════════════════════╗");
        System.out.println("║ Ingresa tu nombre y elige un color║ ");
        System.out.println("╚═══════════════════════════════════╝" + ANSI_RESET);

        System.out.print(ANSI_VIOLETA + "╔══════════════════════════╗\n");
        System.out.print("║ " + ANSI_ROJO + "ROJO " + ANSI_AZUL + "AZUL " + ANSI_VERDE + "VERDE " + ANSI_AMARILLO + "AMARILLO" + ANSI_VIOLETA);
        System.out.println(ANSI_VIOLETA + " ║");
        System.out.println("╚══════════════════════════╝" + ANSI_RESET);
        saltosDeLinea(1);
    }

    public static void mostrarMensajeBienvenida() {
        System.out.println(ANSI_VIOLETA  + "╔═══════════════════════╗");
        System.out.println("║ BIENVENIDO A MONOPOLY ║");
        System.out.println("╚═══════════════════════╝\n" + ANSI_RESET   );
    }
}
