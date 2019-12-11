package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanador;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class Curandero extends Unidad implements Movible, Posicionable, Atacable, Sanador {

	private int poderCuracion = 15;
	private int rangoInicial = 3;
	private int rangoFinal = 5;

	public Curandero(JugadorA jugador) {
		super(jugador);
		vida = 75;
		costo = 2;
	}
	
	public Curandero(JugadorB jugador) {
		super(jugador);
		vida = 75;
		costo = 2;
	}

	@Override
	public void sanar(Sanable unidad) {


		if ( this.estaEnRango(posicion.getX(), posicion.getY(),(Unidad) unidad)){
			unidad.curarce(poderCuracion);
		}
	}

	private boolean estaEnRango(int fila, int columna, Unidad unidad) {

		boolean estaEnRango = false;
		int distanciaX = Math.abs((unidad.getPosicion().getX()) - posicion.getX());
		int distanciaY = Math.abs((unidad.getPosicion().getY()) - posicion.getY());

		if ( ( ( (rangoInicial <= distanciaX) && (distanciaX <= rangoFinal) ) || distanciaX == 0)
				&&
				( ( (rangoInicial <= distanciaY) && (distanciaY <= rangoFinal)) || distanciaY == 0) ){

			estaEnRango = true;
		}

		return estaEnRango;
	}

	@Override
	public boolean movibleMoveteA(JugadorA jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}
	@Override
	public boolean movibleMoveteA(JugadorB jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}

	@Override
	public int costo() {
		return costo;
	}
}
