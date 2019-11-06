package fiuba.algo3.algoChess.Tablero;

import fiuba.algo3.algoChess.modelo.entidades.Entidad;

public class CeldaOcupada extends EstadoCelda {

	@Override
	boolean recibirEntidad(Entidad contenido, Celda receptora) {
		return false;
	}

	@Override
	boolean moverEntidad(Entidad contenido,Celda receptora,Celda emisora) {
		receptora.setEntidad(contenido);
		emisora.setEntidad(null);
		emisora.setEstado(new CeldaVacia());
		return true;
	}
	
}
