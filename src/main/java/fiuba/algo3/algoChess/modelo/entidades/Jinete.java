package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class Jinete extends Unidad{
	
	public Jinete (Jugador jugador) {
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
		this.setDuenio(jugador);
		
	}
}
