package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class CeldaOcupada extends EstadoCelda {

	@Override
	public boolean recibirUnidad(Unidad contenido, Celda receptora) {
		return false;
	}

	@Override
	public boolean moverUnidad(Unidad contenido,Celda receptora,Celda emisora) {
		receptora.setUnidad(contenido);
		emisora.setUnidad(null);
		emisora.setEstado(new CeldaVacia());
		return true;
	}
	
}
