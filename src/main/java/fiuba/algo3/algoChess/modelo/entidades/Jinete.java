package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
public class Jinete extends Unidad{
	
	public Jinete () {
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
		
	}
}
