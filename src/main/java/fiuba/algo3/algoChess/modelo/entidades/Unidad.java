package fiuba.algo3.algoChess.modelo.entidades;

import java.util.List;

import fiuba.algo3.algoChess.modelo.Excepciones.*;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.jugador.*;
//import fiuba.algo3.algoChess.modelo.tablero.Tablero;

public abstract class Unidad implements Posicionable {
	
	//Atributos.
	Ataque ataque;
	protected int vida;
	protected int costo;
	protected TipoUnidad tipo;
	protected List <Unidad> aliadoscercanos;
	protected List <Unidad> aliadosmedios;
	protected List <Unidad> aliadoslejanos;
	protected List <Unidad> enemigoscercanos;
	protected List <Unidad> enemigosmedios;
	protected List <Unidad> enemigoslejanos;
	protected Posicion posicion;
	//protected String nombreDelDuenio;

	public Unidad(JugadorA jugador) {
		//nombreDelDuenio = nombre;
		posicion = new Posicion(-1, -1);
		tipo = new UnidadA();
	}
	
	public Unidad(JugadorB jugador) {
		posicion = new Posicion(-1,-1);
		tipo = new UnidadB();
	}

	public void recibirAtaque(int daño) {
		vida = vida- daño;
		
	}

	public int obtenerVida(){
		return vida;
	}
	
	
	public void atacar (Jugador jugador, Unidad unidad, int pctextra) {
		ataque.atacar(posicion.getX(), posicion.getY(), unidad);
	}
		
	boolean movimientoValido(Posicion unaPosicion) {

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

	/*protected boolean verificaSiEsTuDuenio(String duenio) {
		if(nombreDelDuenio == duenio){
			return true;
		}else {
			throw new NoMePuedesMoverNoEresMiDuenioExcepcion();
		}
	}*/


	/*public String getNombreDelDuenio() {
		return nombreDelDuenio;
	}*/

	@Override
	public Posicion getPosicion() {
		return posicion;
	}

	@Override
	public void setPosicion(Posicion newPosicion) {
		posicion = newPosicion;
	}
	
	@Override
	public void posicionateEnEstaPosicion(JugadorA jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}
	@Override
	public void posicionateEnEstaPosicion(JugadorB jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}
	
	public boolean movibleMoveteA(Jugador jugador, Posicion unaPosicion) {
		if (this.movimientoValido(unaPosicion)){
			posicion = unaPosicion;
			return true;
		}
		return false;
	}

	protected boolean posicioncercana(Posicion posicion1, Posicion posicion2) {
		
		return true;
	}
	
	public void recibirAliadoCercano(Unidad unidad) {
		unidad.getPosicion();
	}

	public void recibirAliadoMedio(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}

	public void recibirEnemigoCercano(Unidad unidad) {
		
	}

	public void recibirAliadoLejano(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}

	public void recibirEnemigoMedio(Unidad unidad) {
		
	}

	public void recibirEnemigoLejano(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}
}
