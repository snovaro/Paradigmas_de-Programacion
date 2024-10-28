package org.example.ModelView;

import org.example.Casilla.Casilla;
import org.example.ModelView.CasillaView.CasillaFactory;
import org.example.Tablero;

import javax.swing.plaf.PanelUI;

public class TableroView {

    private CasillaFactory factoryCasillas;

    private Tablero unTablero;

    public TableroView(Tablero unTablero) {
        this.unTablero = unTablero;
        this.factoryCasillas = new CasillaFactory();
    }

    public void mostrarTablero(){
        /*int dimensiones = this.unTablero.getCasillas().size() / 4;
        int contador = 0;
        for (int i = 0; i <= 10; i++) {// Borde izquierdo
            System.out.print(i + "->");
            for (int j = 0; j <= 10; j++) {

                System.out.print(contador + " ");
                contador+= 1;  // Contenido interno vacío
            }
            System.out.println("|"); // Borde derecho
        }*/
    }
    public void mostrarCasilla(int pos){
        Casilla unaCasilla = this.unTablero.getCasilla(pos);
        this.factoryCasillas.mostrarCasilla(unaCasilla); // dependiendo de que casilla es se mostrara
    }
}
