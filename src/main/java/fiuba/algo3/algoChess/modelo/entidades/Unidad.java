package fiuba.algo3.algoChess.modelo.entidades;


import fiuba.algo3.algoChess.modelo.Observable;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;

public abstract class Unidad extends Observable implements Posicionable {
	
	//Atributos.
	protected double vida;
	protected int costo;
	protected TipoUnidad tipo;
	protected DanioPorTerritoroEnemigo danioPorTerritoroEnemigo;
	protected Posicion posicion;


	public Unidad(JugadorA jugador) {
		super();
		posicion = new Posicion(-1, -1);
		tipo = new UnidadA();
		danioPorTerritoroEnemigo = new DanioPorTerritoroEnemigo(tipo);
	}
	
	public Unidad(JugadorB jugador) {
		super();
		posicion = new Posicion(-1,-1);
		tipo = new UnidadB();
		danioPorTerritoroEnemigo = new DanioPorTerritoroEnemigo(tipo);
	}

	public void recibirAtaque(int daño) {
		vida = vida - daño;
		vida = vida - danioPorTerritoroEnemigo.penalizacionPorTerritorioEnemigo(daño);
		this.notificarObservadoresAtaques();

	}

	public double obtenerVida(){
		return vida;
	}


	@Override
	public Posicion getPosicion() {
		return posicion;
	}

	@Override
	public void setPosicion(Posicion newPosicion) {
		if ((posicion.getX() == -1) && (posicion.getY() == -1) ){
			posicion = newPosicion;
			return;
		}
		posicion = newPosicion;
		danioPorTerritoroEnemigo.actualizaDanioPorTerritoroEnemigo(posicion);
		this.notificarObservadoresMovimiento();
	}
	
	@Override
	public void posicionateEnEstaPosicion(JugadorA jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}
	@Override
	public void posicionateEnEstaPosicion(JugadorB jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}

	public void eliminarObservadores() {
		this.observersMovi = new ArrayList<>();
		this.observersAtaque = new ArrayList<>();
	}
}
