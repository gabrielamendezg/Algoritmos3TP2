package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;

public class Derecha implements Direccion{

	@Override
	public void moverUnidad(AlgoChess algoChess, Movible unidad) {
		algoChess.moverUnidadDerecha(unidad);
		
	}

}