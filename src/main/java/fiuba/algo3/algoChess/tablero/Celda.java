package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Entidad;
import fiuba.algo3.algoChess.sample.Jugador;

public class Celda{
	private Jugador jugador;
	private Entidad entidad;
	private EstadoCelda estado;
	
	public Celda(Jugador duenio) {
		estado = new CeldaVacia();
		jugador = duenio;
	}

	public void setEntidad(Entidad contenido) {
		entidad = contenido;
	}
	
	public void setEstado(EstadoCelda nuevoestado) {
		estado = nuevoestado;
	}
	
	public boolean recibirEntidad(Entidad contenido) {
		return estado.recibirEntidad(contenido, this);
	}

	public boolean moverEntidad(Celda celda) {
		return estado.moverEntidad(entidad, celda, this);
	}
}
