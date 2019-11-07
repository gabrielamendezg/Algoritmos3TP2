package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.ataque.*;
public class Jinete extends Unidad{
	
	public Jinete (Jugador jugador) {
		this.setDuenio(jugador);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
		
	}
}
