package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.ataque.*;

public class Catapulta extends Unidad{
	
	public Catapulta(Jugador jugador) {
		duenio = jugador;
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
	@Override
	public boolean moverUnidadA(Jugador jugador, int posicionX, int posicionY) {
		return false;
	}
	
	
}
