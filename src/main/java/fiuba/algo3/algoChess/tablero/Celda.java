package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class Celda{
	private Unidad unidad;
	private EstadoCelda estado;
	
	public Celda() {
		estado = new CeldaVacia();
	}

	public void setUnidad(Unidad contenido) {
		unidad = contenido;
	}
	
	public void setEstado(EstadoCelda nuevoestado) {
		estado = nuevoestado;
	}
	
	public boolean recibirUnidad(Unidad nuevaUnidad) {
		return estado.recibirUnidad(nuevaUnidad, this);
	}

	public boolean moverUnidad(Jugador jugadormovimiento, int filadestino, int columnadestino) {
		return estado.moverUnidad(this,jugadormovimiento, filadestino, columnadestino,unidad);
	}
}
