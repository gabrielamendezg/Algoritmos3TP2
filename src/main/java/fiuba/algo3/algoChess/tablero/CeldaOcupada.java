package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class CeldaOcupada extends EstadoCelda {

	@Override
	public boolean recibirUnidad(Unidad contenido, Celda receptora) {
		return false;
	}

	@Override
	boolean moverUnidad(Celda celdaorigen, Jugador jugadormovimiento, int filadestino,
			int columnadestino, Unidad unidad) {
		if(unidad.moverUnidadA(jugadormovimiento, filadestino, columnadestino)) {
			celdaorigen.setUnidad(null);
			celdaorigen.setEstado(new CeldaVacia());
			return true;
		}
		return false;
	}
	
}
