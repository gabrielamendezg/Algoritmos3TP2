package fiuba.algo3.algoChess.modelo.jugador;

import java.util.ArrayList;

import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class JugadorA implements Jugador {
	
	protected int columnamin;
	protected int columnamax;
	protected int filamin;
	protected int filamax;
	protected int puntos;
	protected  ArrayList<Unidad> unidades;
	protected String nombre;
	
    public JugadorA() {
    	this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
        filamin = 1;
        filamax = 10;
        columnamin = 1;
        columnamax = 20;
    }
    
    public JugadorA(String nombreDelJugador) {
        super();
        filamin = 11;
        filamax = 20;
        columnamin = 1;
        columnamax = 20;
        this.nombre = nombreDelJugador;
    }

    public int getFilaMin() {
        return filamin;
    }

    public int getFilaMax() {
        return filamax;
    }
    public int getColumnaMin() {
        return columnamin;
    }
    public int getColumnaMax() {
        return columnamax;
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

	@Override
	public void actualizarUnidades(ArrayList<Unidad> unidadesEnemigas, int cantidadEnemigas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

}
