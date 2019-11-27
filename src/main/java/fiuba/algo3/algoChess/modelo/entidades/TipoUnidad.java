package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public abstract class TipoUnidad {

	public TipoUnidad() {
		
	}
	
	public abstract void posicionarEnEstaPosicion(Posicionable unidad, JugadorA jugador, Posicion aPosicion);
	public abstract void posicionarEnEstaPosicion(Posicionable unidad, JugadorB jugador, Posicion aPosicion);

	protected abstract boolean moverA(Movible unidad, JugadorA jugador, Posicion unaPosicion);
	protected abstract boolean moverA(Movible unidad, JugadorB jugador, Posicion unaPosicion);



}
