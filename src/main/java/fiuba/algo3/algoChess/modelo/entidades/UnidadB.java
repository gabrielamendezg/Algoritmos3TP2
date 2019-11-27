package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class UnidadB extends TipoUnidad {

	public UnidadB() {
		super();
	}

	@Override
	public void posicionarEnEstaPosicion(Posicionable unidad, JugadorA jugador, Posicion aPosicion) {
		throw new NoEsTuUnidadExcepcion();
		
	}

	@Override
	public void posicionarEnEstaPosicion(Posicionable unidad, JugadorB jugador, Posicion aPosicion) {
		unidad.setPosicion(aPosicion);
		return;		
	}

	@Override
	protected boolean moverA(Movible unidad, JugadorB jugador, Posicion unaPosicion) {
		unidad.setPosicion(unaPosicion);
		return true;
	}

	@Override
	protected boolean moverA(Movible unidad, JugadorA jugador, Posicion unaPosicion) {
		return false;
	}



}
