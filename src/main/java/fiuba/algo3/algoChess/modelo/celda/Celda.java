package fiuba.algo3.algoChess.modelo.celda;

import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;


public class Celda{
	private Posicionable unidad;
	
	public Celda() {
		unidad = null;
	}

	public void recibirPosicionable(Posicionable nuevaUnidad) {
		if (unidad == null){
			unidad  = nuevaUnidad;
		} else {
			throw new PosicionOcupadaExcepcion();
		}
	}

	public Posicionable vaciarCelda() {
		Posicionable unaUnidad = unidad;
		unidad = null;
		return unaUnidad;
	}

	public boolean celdaOcupadaPorUnidad( Posicionable unaUnidad){
		return unidad == unaUnidad;
	}

	public boolean celdaVacia() {
		return unidad == null;
	}
}
