package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.NoMePuedesMoverNoEresMiDuenioExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.SolotePudesMoverUnaPosicionExcepcion;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;

public abstract class Unidad implements Posicionable {
	
	
	Ataque ataque;
	protected int vida;
	protected int costo;

	// posicion
	protected Posicion posicion;
	protected String nombreDelDuenio;

	public Unidad(String nombre) {
		nombreDelDuenio = nombre;
		posicion = new Posicion(-1, -1);
	}

	public void recibirAtaque(int daño) {
		vida = vida- daño;
		
	}

	public void atacar (Unidad unidad) {
		ataque.atacar(posicion.getX(), posicion.getY(), unidad);
	}

	public int obtenerVida(){
		return vida;
	}
		
	private boolean movimientoValido(Posicion unaPosicion) {

		int distanciaX = Math.abs(unaPosicion.getX() - posicion.getX());
		int distanciaY = Math.abs(unaPosicion.getY() - posicion.getY());

		if (((0 == distanciaX) || (distanciaX == 1))
				&&

				((0 == distanciaY) || (distanciaY == 1))) {


			return true;
		} else {
			throw new SolotePudesMoverUnaPosicionExcepcion();
		}
	}


	public boolean movibleMomoveteA(String duenio, Posicion unaPosicion) {

		if (this.movimientoValido(unaPosicion) && this.verificaSiEsTuDuenio(duenio) ){
			posicion = unaPosicion;
			return true;
		}
		return false;
	}

	protected boolean verificaSiEsTuDuenio(String duenio) {
		if(nombreDelDuenio == duenio){
			return true;
		}else {
			throw new NoMePuedesMoverNoEresMiDuenioExcepcion();
		}
	}


	public String getNombreDelDuenio() {
		return nombreDelDuenio;
	}

	@Override
	public Posicion getPosicion() {
		return posicion;
	}

	@Override
	public void setPosicion(Posicion newPosicion) {
		posicion = newPosicion;
	}

	@Override
	public void posicionateEnEstaPosicion(String duenio, Posicion aPosicion) {
		if(duenio == nombreDelDuenio) {
			posicion = aPosicion;
			return;
		}
		throw new NoEsTuUnidadExcepcion();
	}
}
