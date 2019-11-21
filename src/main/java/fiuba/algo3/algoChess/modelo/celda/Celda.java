package fiuba.algo3.algoChess.modelo.celda;

import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;


public abstract class Celda{
	protected Posicionable unidad;
	
	public Celda() {
		unidad = null;
	}

	public abstract void recibirPosicionable(JugadorA jugador, Posicionable nuevaUnidad, Posicion posicion);
	public abstract void recibirPosicionable(JugadorB jugador, Posicionable nuevaUnidad, Posicion posicion);
	

	public Posicionable vaciarCelda() {
		Posicionable unaUnidad = unidad;
		unidad = null;
		return unaUnidad;
	}

	public boolean celdaOcupadaPorPosicionable( Posicionable unPosicionable){
		return unidad == unPosicionable;
	}

	public boolean celdaVacia() {
		return unidad == null;
	}

	public Posicionable getPosicionable() {
		return unidad;
	}
	
	public void recibirMovible(Posicionable nuevaUnidad) {
		if (this.celdaVacia()) {
			unidad  = nuevaUnidad;
		}else {
			throw new PosicionOcupadaExcepcion();
		}
	}

}
