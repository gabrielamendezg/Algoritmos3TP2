package fiuba.algo3.algoChess.modelo.celda.estadoCelda;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public abstract class EstadoCelda {
	public abstract boolean recibirUnidad(Unidad contenido, Celda receptora);
	public abstract boolean moverUnidad(Celda celdaorigen, Jugador jugadormovimiento, int filadestino, int columnadestino, Unidad unidad);
}
