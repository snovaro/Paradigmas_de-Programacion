package org.example.ModelView.CasillaView.CreatorCasilla;

import org.example.Casilla.Casilla;
import org.example.ModelView.CasillaView.CasillaLoteriaView;
import org.example.ModelView.CasillaView.CasillaView;

public class CreatorCasillaLoteria implements CasillaCreator {
    @Override
    public CasillaView creator(Casilla unaCasilla) {
        return new CasillaLoteriaView(unaCasilla);
    }
}
