package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;

import fiuba.algo3.algoChess.modelo.Excepciones.JugadorSinPuntosSuficientesException;
import fiuba.algo3.algoChess.modelo.entidades.*;


//import fiuba.algo3.algoChess.sample.JugadorSinUnidadesPierdeException; -___ELIMINAR
//AGREGAR EXCEPTION DE PUNTOS INSUFICIENTES

/*REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir*/

//RESPONSABILIDAD DE ELEGIR PIEZAS, DE ELEGIR DONDE PONERLAS, DE ELEGIR PIEZA Y DONDE MOVER Y ATACAR

public class Jugador {

	private int puntos;
	private ArrayList<Unidad> unidades;
	private String nombre;
	private SelectorDeUnidades selector;

	public Jugador() {

		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
		this.nombre = "";
		this.selector = new SelectorDeUnidades();
	
	}
	
	
	public Jugador(String nombreDeJugador) {

		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
		this.nombre = nombreDeJugador;
		this.selector = new SelectorDeUnidades();
	}


	public Unidad elegirSoldado() {
		
		Unidad unidadElegida = null;
		try {
		unidadElegida = this.selector.elegirSoldado(this);
		this.unidades.add(unidadElegida);
		}catch (JugadorSinPuntosSuficientesException e) {
			
		}
		
		return unidadElegida;
	}

	public Unidad elegirCatapulta() {

		Unidad unidadElegida = null;
		try {
		unidadElegida = this.selector.elegirCatapulta(this);
		this.unidades.add(unidadElegida);			
		}catch (JugadorSinPuntosSuficientesException e) {
			
		}
		
		return unidadElegida;
	}

	public Unidad elegirJinete() {

		Unidad unidadElegida = null;
		try {
		unidadElegida = this.selector.elegirJinete(this);
		this.unidades.add(unidadElegida);			
		}catch (JugadorSinPuntosSuficientesException e) {
			
		}
		
		return unidadElegida;
	}

	public Unidad elegirCurandero() {

		Unidad unidadElegida = null;
		try {
		unidadElegida = this.selector.elegirCurandero(this);
		this.unidades.add(unidadElegida);			
		}catch (JugadorSinPuntosSuficientesException e) {
			
		}
		
		return unidadElegida;
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

	// Ordena atacar a todas las unidades
	public void ordenarAtaque(ArrayList<Unidad> unidadesEnemigas) {


		Iterator<Unidad> iterador = unidades.iterator();

		while (iterador.hasNext()) {


			iterador.next().atacar(unidadesEnemigas);
		}


	}
	
	//VER RESPONSABILIDAD CON GRUPO ME PARECE QUe removER
	public void colocarUnidadesAlComienzoDeLaPartda(int[][] posiciones) {
		
		Iterator<Unidad> iteradorUnidades = unidades.iterator();
		int i=0;
		
		while (iteradorUnidades.hasNext()) {
			
		
			iteradorUnidades.next().setPosicion(posiciones[i][0], posiciones[i][1]);
			i++;
		
		}
		
		
	}
	
	
	public String obtenerNombre () {
		
		return this.nombre;
	}
	
	public boolean tienePuntosRestantes() {
		
		return (this.puntos>0);
	}

	public int getPuntos() {
		
		return this.puntos;
	}
	
	public void restarPuntos(int puntosARestar) {
		
		this.puntos = puntos - puntosARestar;
	}
	
	
		
}

