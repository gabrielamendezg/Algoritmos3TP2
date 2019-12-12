package fiuba.algo3.algoChess.modelo.algoChess;

import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;

public class ArribaDerecha implements Direccion{

	@Override
	public void moverUnidad(AlgoChess algoChess, Movible unidad) {
		algoChess.moverUnidadArribaDerecha(unidad);
		
	}

}