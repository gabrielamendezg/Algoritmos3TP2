package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public abstract class TipoUnidad {

	public TipoUnidad() {
		
	}
	
	public abstract void posicionarEnEstaPosicion(Unidad unidad, JugadorA jugador, Posicion aPosicion);
	public abstract void posicionarEnEstaPosicion(Unidad unidad, JugadorB jugador, Posicion aPosicion);

	protected abstract boolean moverA(Unidad unidad, JugadorA jugador, Posicion unaPosicion);
	protected abstract boolean moverA(Unidad unidad, JugadorB jugador, Posicion unaPosicion);



}
