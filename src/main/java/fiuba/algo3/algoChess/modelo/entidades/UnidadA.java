/**
 * 
 */
package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;


/**
 * @author gmendez
 *
 */
public class UnidadA extends TipoUnidad {

	public UnidadA() {
		super();
	}
	
	@Override
	public void posicionarEnEstaPosicion(Unidad unidad, JugadorA jugador, Posicion aPosicion) {	
		unidad.setPosicion(aPosicion);
		return;
	}
	
	@Override
	public void posicionarEnEstaPosicion(Unidad unidad, JugadorB jugador, Posicion aPosicion) {
		throw new NoEsTuUnidadExcepcion();
	}

	@Override
	protected boolean moverA(Unidad unidad, JugadorA jugador, Posicion unaPosicion) {
		return unidad.movibleMoveteA(jugador, unaPosicion);
	}

	@Override
	protected boolean moverA(Unidad unidad, JugadorB jugador, Posicion unaPosicion) {
		return false;
	}
	

}
