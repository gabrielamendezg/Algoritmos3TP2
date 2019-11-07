package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.sample.JugadorSinUnidadesPierdeException;


/*REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir*/


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

			nuevaUnidad = new SoldadoDeInfanteria();
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 1;

		} else {

			System.out.println("Puntos insuficientes, devuelve null");
		}

		return nuevaUnidad;
	}

	public Unidad elegirCatapulta() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 5) {

			nuevaUnidad = new Catapulta(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 5;

		} else {

			System.out.println("Puntos insuficientes, devuelve null");
		}

		return nuevaUnidad;
	}

	public Unidad elegirJinete() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 3) {

			nuevaUnidad = new Jinete();
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 3;


		} else {

			System.out.println("Puntos insuficientes, devuelve null");
		}

		return nuevaUnidad;
	}

	public Unidad elegirCurandero() {

		Unidad nuevaUnidad = null;

		if (this.puntos >= 2) {

			nuevaUnidad = new Curandero();
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 2;

		} else {

			System.out.println("Puntos insuficientes, devuelve null");
		}

		return nuevaUnidad;
	}


	public int cantidadDeUnidades() {

		return (this.unidades.size());
	}

	public ArrayList<Unidad> obtenerUnidades() {


		return this.unidades;

	}


	private boolean sigueEnJuego() {

		return (unidades.size() != 0);
	}

	public void eliminarUnidad(Unidad unaUnidad) throws JugadorSinUnidadesPierdeException {

		this.unidades.remove(unaUnidad);

		if (!this.sigueEnJuego()) {
			throw new JugadorSinUnidadesPierdeException();

		}
	}

	public boolean ordenarAtaque(ArrayList<Unidad> unidadesEnemigas) {

		boolean pudoOrdenarAtaque = true;


		Iterator<Unidad> iterador = unidades.iterator();

		while (iterador.hasNext()) {


			iterador.next().atacar(unidadesEnemigas);
		}


		if (this.cantidadDeUnidades() == 0) {
			pudoOrdenarAtaque = false;
		}

		return pudoOrdenarAtaque;


	}
}
