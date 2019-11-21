package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class UnidadB extends TipoUnidad {

	public UnidadB() {
		super();
	}

	@Override
	public void posicionarEnEstaPosicion(Unidad unidad, JugadorA jugador, Posicion aPosicion) {
		throw new NoEsTuUnidadExcepcion();
		
	}

	@Override
	public void posicionarEnEstaPosicion(Unidad unidad, JugadorB jugador, Posicion aPosicion) {
		unidad.setPosicion(aPosicion);
		return;		
	}
	
	@Override
	protected boolean moverA(Unidad unidad, JugadorB jugador, Posicion unaPosicion) {
		return unidad.movibleMoveteA(jugador, unaPosicion);
	}

	@Override
	protected boolean moverA(Unidad unidad, JugadorA jugador, Posicion unaPosicion) {
		return false;
	}



}
