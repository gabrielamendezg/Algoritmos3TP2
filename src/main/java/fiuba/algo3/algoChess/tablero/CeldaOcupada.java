package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Entidad;

public class CeldaOcupada extends EstadoCelda {

	@Override
	public boolean recibirEntidad(Entidad contenido, Celda receptora) {
		return false;
	}

	@Override
	public boolean moverEntidad(Entidad contenido,Celda receptora,Celda emisora) {
		receptora.setEntidad(contenido);
		emisora.setEntidad(null);
		emisora.setEstado(new CeldaVacia());
		return true;
	}
	
}
