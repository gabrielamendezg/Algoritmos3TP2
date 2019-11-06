package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Entidad;

public class CeldaVacia extends EstadoCelda{

	@Override
	public boolean recibirEntidad(Entidad contenido, Celda receptora) {
		receptora.setEntidad(contenido);
		receptora.setEstado(new CeldaOcupada());
		return true;
	}

	@Override
	public boolean moverEntidad(Entidad contenido, Celda receptora,Celda emisora) {
		return false;
	}
	
}
