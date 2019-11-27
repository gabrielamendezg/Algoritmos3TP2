package fiuba.algo3.algoChess.modelo.jugador;

import java.util.ArrayList;

import fiuba.algo3.algoChess.modelo.Excepciones.PuntosInsuficientesExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class JugadorB implements Jugador {

	/*protected int columnamin;
	protected int columnamax;
	protected int filamin;
	protected int filamax;*/
	protected int puntos;
	protected  ArrayList<Unidad> unidades;
	protected String nombre;
	
	public JugadorB() {
        /*super();
        filamin = 11;
        filamax = 20;
        columnamin = 1;
        columnamax = 20;*/
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
    }
	
	public JugadorB(String nombreDelJugador) {
        /*super();
        filamin = 11;
        filamax = 20;
        columnamin = 1;
        columnamax = 20;*/
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
        this.nombre = nombreDelJugador;
    }


/*
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
    }*/
    
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

/*	@Override
	public void actualizarUnidades(ArrayList<Unidad> unidadesEnemigas, int cantidadEnemigas) {
		for (int i = 0; i < this.cantidadDeUnidades(); i++) {
			for(int j = 0; j < this.cantidadDeUnidades(); j++) {
				unidades.get(i).recibirAliadoCercano(unidades.get(j));
				unidades.get(i).recibirAliadoMedio(unidades.get(j));
				unidades.get(i).recibirAliadoLejano(unidades.get(j));
			}
			for(int j = 0; i < cantidadEnemigas; j++) {
				unidades.get(i).recibirEnemigoCercano(unidadesEnemigas.get(j));
				unidades.get(i).recibirEnemigoMedio(unidadesEnemigas.get(j));
				unidades.get(i).recibirEnemigoLejano(unidadesEnemigas.get(j));
			}
		}

	}
*/
	public String getNombre() {
		// TODO Auto-generated method stub
		
		return this.nombre;
	}
}
