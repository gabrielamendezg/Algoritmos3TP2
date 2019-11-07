package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class Celda{
	private Jugador jugador;
	private Unidad unidad;
	private EstadoCelda estado;
	
	public Celda(Jugador duenio) {
		estado = new CeldaVacia();
		jugador = duenio;
	}

	public void setUnidad(Unidad contenido) {
		unidad = contenido;
	}
	
	public void setEstado(EstadoCelda nuevoestado) {
		estado = nuevoestado;
	}
	
	public boolean recibirUnidad(Unidad contenido) {
		return estado.recibirUnidad(contenido, this);
	}

	public boolean moverUnidad(Celda celda) {
		return estado.moverUnidad(unidad, celda, this);
	}
}
