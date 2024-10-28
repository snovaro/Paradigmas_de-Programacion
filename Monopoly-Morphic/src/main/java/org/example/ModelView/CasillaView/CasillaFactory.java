package org.example.ModelView.CasillaView;

import org.example.Casilla.Casilla;
import org.example.ModelView.CasillaView.CreatorCasilla.*;

import java.util.HashMap;

public class CasillaFactory {
    private static HashMap<String, CasillaCreator> creatorCasilla;
    static {
        creatorCasilla = new HashMap<>();
        // Aquí puedes llenar el hash con los valores que desees
        //creatorCasilla.put("clave2", "valor2");
        //creatorCasilla.put("clave3", "valor3");
        creatorCasilla.put("loteria", new CreatorCasillaLoteria() {
        });
    }

    public void mostrarCasilla(Casilla unCasilla){
        CasillaCreator unCreator = creatorCasilla.get(unCasilla.getNombre());
        CasillaView unaCasillaView = unCreator.creator(unCasilla); // EJMP CreatorCasillaLoteria return  -> new CasillaLoteriaView(unaCasilla)
        unaCasillaView.mostrarContenidoDeCasilla();
    }
}
