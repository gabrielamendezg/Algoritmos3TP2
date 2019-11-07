package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class CeldaVacia extends EstadoCelda{

	@Override
	public boolean recibirUnidad(Unidad contenido, Celda receptora) {
		receptora.setUnidad(contenido);
		receptora.setEstado(new CeldaOcupada());
		return true;
	}

	@Override
	public boolean moverUnidad(Unidad contenido, Celda receptora,Celda emisora) {
		return false;
	}
	
}
