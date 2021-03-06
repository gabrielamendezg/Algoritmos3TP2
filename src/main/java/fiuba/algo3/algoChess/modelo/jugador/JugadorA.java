package fiuba.algo3.algoChess.modelo.jugador;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
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
		this.eliminarUnidadesMuertas();
		return (this.unidades.size());
	}
    
    public ArrayList<Unidad> obtenerUnidades() {

		this.eliminarUnidadesMuertas();
    	return this.unidades;
	}

	@Override
	public int getPuntos() {
		return puntos;
	}

	public void eliminarUnidadesMuertas() {
		ArrayList<Unidad> unidadConVidaCero = new ArrayList<>();
		unidades.stream().forEach(unidadPosicionado -> {
			if(unidadPosicionado.obtenerVida() <= 0)
				unidadConVidaCero.add(unidadPosicionado);
		});
		unidadConVidaCero.stream().forEach(unidadMuerta -> {

			this.eliminarUnidad(unidadMuerta);
		});
	}

	public boolean sigueEnJuego() {
		this.eliminarUnidadesMuertas();
		return (unidades.size() != 0);
	}
    
    public void eliminarUnidad(Unidad unaUnidad){
		this.unidades.remove(unaUnidad);
	}
    
    @Override
	public SoldadoDeInfanteria elegirSoldado() {
		return new SoldadoDeInfanteria(this);
	}
	@Override
	public Catapulta elegirCatapulta() {
		return new Catapulta(this);
	}
	@Override
	public Jinete elegirJinete() {
		return new Jinete(this);
	}
	@Override
	public Curandero elegirCurandero() {
		return new Curandero(this);
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public void agregarEntidadPosiciondoEnTablero(Posicionable nuevaUnidad) {
		if (this.puntos >= nuevaUnidad.costo()) {
			this.unidades.add((Unidad) nuevaUnidad);
			this.puntos = this.puntos - nuevaUnidad.costo();

		} else {

			throw new PuntosInsuficientesExcepcion();
		}
	}

}
