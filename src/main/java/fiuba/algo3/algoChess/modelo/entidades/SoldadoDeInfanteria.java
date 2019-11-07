package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;

public class SoldadoDeInfanteria extends Unidad{
	
	public SoldadoDeInfanteria() {
		ataque = new AtaqueCercano(10);
		vida = 100;
		costo = 1;
	}
	
}
