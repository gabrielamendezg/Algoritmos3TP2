package fiuba.algo3.algoChess.modelo.ataque;

import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;

public class AtaqueDistanciaLejana extends Ataque {
	
	public AtaqueDistanciaLejana (int daño) {
		
		rangoInicial = 6;
		rangoFinal = 10000;
		ataque = daño;
		
	}
	
	public void ataquePorReaccionEnCadena(Atacable unidadAtacada) {
		unidadAtacada.recibirAtaque(ataque);
		return;
	}

}
