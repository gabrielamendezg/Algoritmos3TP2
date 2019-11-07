package fiuba.algo3.algoChess.modelo.entidades;
import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.ataque.*;

public class Catapulta extends Unidad{
	
	public Catapulta() {
		
	
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
	@Override
	public boolean moverUnidadA(int posicionX, int posicionY, Jugador jugador) {
		return false;
	}
	
	
}
