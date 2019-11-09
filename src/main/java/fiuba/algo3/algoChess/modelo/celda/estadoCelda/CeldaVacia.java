package fiuba.algo3.algoChess.modelo.celda.estadoCelda;

import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.celda.estadoCelda.CeldaOcupada;
import fiuba.algo3.algoChess.modelo.celda.estadoCelda.EstadoCelda;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class CeldaVacia extends EstadoCelda {

	@Override
	public boolean recibirUnidad(Unidad contenido, Celda receptora) {
		receptora.setUnidad(contenido);
		receptora.setEstado(new CeldaOcupada());
		return true;
	}

	@Override
	public boolean moverUnidad(Celda celdaorigen, Jugador jugadormovimiento, int filadestino,
							   int columnadestino, Unidad unidad) {
		return false;
	}
	
}
