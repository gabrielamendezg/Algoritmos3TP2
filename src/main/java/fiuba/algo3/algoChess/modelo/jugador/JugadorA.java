package fiuba.algo3.algoChess.modelo.jugador;

import java.util.ArrayList;

import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class JugadorA implements Jugador {

	protected int puntos;
	protected  ArrayList<Unidad> unidades;
	protected String nombre;
	
    public JugadorA() {
    	this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
    }
    
    public JugadorA(String nombreDelJugador) {
        super();
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
        this.nombre = nombreDelJugador;
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
    
    @Override
	public SoldadoDeInfanteria elegirSoldado() {
		SoldadoDeInfanteria nuevaUnidad = null;

		if (this.puntos >= 1) {

			nuevaUnidad = new SoldadoDeInfanteria(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 1;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	@Override
	public Catapulta elegirCatapulta() {
		Catapulta nuevaUnidad = null;

		if (this.puntos >= 5) {

			nuevaUnidad = new Catapulta(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 5;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	@Override
	public Jinete elegirJinete() {
		Jinete nuevaUnidad = null;

		if (this.puntos >= 3) {

			nuevaUnidad = new Jinete(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 3;


		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	@Override
	public Curandero elegirCurandero() {
		Curandero nuevaUnidad = null;

		if (this.puntos >= 2) {

			nuevaUnidad = new Curandero(this);
			this.unidades.add(nuevaUnidad);
			this.puntos = this.puntos - 2;

		} else {

			throw new PuntosInsuficientesExcepcion();
		}

		return nuevaUnidad;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

}
