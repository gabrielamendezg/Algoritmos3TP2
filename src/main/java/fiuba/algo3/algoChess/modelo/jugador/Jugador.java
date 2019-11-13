package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;


//import fiuba.algo3.algoChess.sample.JugadorSinUnidadesPierdeException; -___ELIMINAR


/*REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir*/

//RESPONSABILIDAD DE ELEGIR PIEZAS, DE ELEGIR DONDE PONERLAS, DE ELEGIR PIEZA Y DONDE MOVER Y ATACAR

public class Jugador {

	private int puntos;
	private ArrayList<Unidad> unidades;

	public Jugador() {

		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();

	}


	public Unidad elegirSoldado() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 1) {

			nuevaUnidad = new SoldadoDeInfanteria(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 1;

		/*} else {

			System.out.println("Puntos insuficientes, devuelve null");
	*/	}

		return nuevaUnidad;
	}

	public Unidad elegirCatapulta() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 5) {

			nuevaUnidad = new Catapulta(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 5;

	/*	} else {

			System.out.println("Puntos insuficientes, devuelve null");
	*/	}

		return nuevaUnidad;
	}

	public Unidad elegirJinete() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 3) {

			nuevaUnidad = new Jinete(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 3;


	/*	} else {

			System.out.println("Puntos insuficientes, devuelve null");
	*/	}

		return nuevaUnidad;
	}

	public Unidad elegirCurandero() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 2) {

			nuevaUnidad = new Curandero(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 2;

	/*	} else {

			System.out.println("Puntos insuficientes, devuelve null");
	*/	}

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

	// Ordena atacar a todas las unidades
	public void ordenarAtaque(ArrayList<Unidad> unidadesEnemigas) {


		Iterator<Unidad> iterador = unidades.iterator();

		while (iterador.hasNext()) {


			iterador.next().atacar(unidadesEnemigas);
		}


	}
	

	/*public void seleccionarUnidades(){
		
		 * 
		 * VER ESTO SI TIENE SENTIDO EL METODO Y COMO CODEAR
		 * 
		char eleccion;
		while (this.puntos>0) {
			eleccion = (char) System.in.read();
			switch (eleccion){
			
			case '1':
				this.elegirSoldado();
			case '2':
				this.elegirJinete();
			case '3':
				this.elegirCatapulta();
			case 4:
				this.elegirCurandero();
			
			
			}	*/
		
	
	}

