package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.ataque.*;

public class SoldadoDeInfanteria extends Unidad{
	
	public SoldadoDeInfanteria(Jugador jugador) {
		ataque = new AtaqueCercano(10);
		vida = 100;
		costo = 1;
		this.setDuenio(jugador);
	}
	
}
