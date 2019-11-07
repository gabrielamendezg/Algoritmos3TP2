package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

abstract class EstadoCelda {
	abstract boolean recibirUnidad(Unidad contenido,Celda receptora);
	abstract boolean moverUnidad(Celda celdaorigen, Jugador jugadormovimiento, int filadestino, int columnadestino, Unidad unidad);
}
