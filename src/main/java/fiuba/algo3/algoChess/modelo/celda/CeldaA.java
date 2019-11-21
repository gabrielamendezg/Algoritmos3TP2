package fiuba.algo3.algoChess.modelo.celda;

import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.*;

public class CeldaA extends Celda {

	public CeldaA() {
		super();
	}
	
	@Override
	public void recibirPosicionable(JugadorA jugador, Posicionable nuevaUnidad, Posicion posicion) {			
		if (this.celdaVacia()){
			nuevaUnidad.posicionateEnEstaPosicion(jugador, posicion);
			unidad  = nuevaUnidad;
		} else {
			throw new PosicionOcupadaExcepcion();
		}
	}
	
	@Override
	public void recibirPosicionable(JugadorB jugador, Posicionable nuevaUnidad, Posicion posicion) {			
		if (this.celdaVacia()){
			throw new FilaOColumnaNoPerteneceATuParteDelTableroExcepcion();
		} else {
			throw new PosicionOcupadaExcepcion();
		}
	}
	
}