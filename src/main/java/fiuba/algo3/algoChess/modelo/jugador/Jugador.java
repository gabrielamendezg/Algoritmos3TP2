package fiuba.algo3.algoChess.modelo.jugador;

import java.util.*;
import fiuba.algo3.algoChess.modelo.Excepciones.PuntosInsuficientesExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.*;


/*	-REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir
 * 	
 * -Ver responsabilidad de saber espacio del tablero (Jugador o tablero)
 * -Ver Encapsular puntaje e implementar selector de unidades
 * -- Ver refactoreo a Multiton para 2 (implementar con Dictionary)
 * 
 * */


public class Jugador {

	protected int columnamin;
	protected int columnamax;
	protected int filamin;
	protected int filamax;
	private String meLLamo = null;
	private int puntos;
	private ArrayList<Unidad> unidades;

	public Jugador(String nombre) {
		meLLamo = nombre;
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
	}


    public SoldadoDeInfanteria elegirSoldado() {

		SoldadoDeInfanteria nuevaUnidad = null;

		if (this.puntos >= 1) {

			nuevaUnidad = new SoldadoDeInfanteria(meLLamo);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 1;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	public Catapulta elegirCatapulta() {

		Catapulta nuevaUnidad = null;

		if (this.puntos >= 5) {

			nuevaUnidad = new Catapulta(meLLamo);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 5;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	public Jinete elegirJinete() {

		Jinete nuevaUnidad = null;

		if (this.puntos >= 3) {

			nuevaUnidad = new Jinete(meLLamo);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 3;


		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	public Curandero elegirCurandero() {

		Curandero nuevaUnidad = null;

		if (this.puntos >= 2) {

			nuevaUnidad = new Curandero(meLLamo);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 2;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}


	public int cantidadDeUnidades() {

		return (this.unidades.size());
	}

	public ArrayList<Unidad> obtenerUnidades() {


		return this.unidades;

	}


	public boolean sigueEnJuego() {

		return (unidades.size() != 0);
	}

	public void eliminarUnidad(Unidad unaUnidad){

		this.unidades.remove(unaUnidad);
		
	}

	public String nombre() {
		return meLLamo;
	}

	public void colocarenposicion(Unidad unidad, int fila, int columna, Unidad[][] matriz) {

	}

	public int getFilaMin() {
		return 0;
	}

	public int grtFilaMax() {
		return 0;
	}

	public int getColumnaMin() {
		return 0;
	}

	public int getColumnaMax() {
		return 0;
	}
}
