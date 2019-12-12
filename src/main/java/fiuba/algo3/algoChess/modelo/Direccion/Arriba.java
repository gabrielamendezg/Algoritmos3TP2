package fiuba.algo3.algoChess.modelo.Direccion;

import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;

public class Arriba implements Direccion{
	
	public void moverUnidad(AlgoChess algoChess, Movible unidad) {
		algoChess.moverUnidadArriba(unidad);
	}

}
