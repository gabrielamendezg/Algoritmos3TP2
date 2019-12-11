package fiuba.algo3.algoChess.modelo.jugador;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import fiuba.algo3.algoChess.modelo.Excepciones.PuntosInsuficientesExcepcion;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;

public class JugadorB implements Jugador, Observador {

	protected int puntos;
	protected  ArrayList<Unidad> unidades;
	protected String nombre;
	
	public JugadorB() {
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
    }
	
	public JugadorB(String nombreDelJugador) {
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

	@Override
	public int getPuntos() {
		return puntos;
	}

	public boolean sigueEnJuego() {
		return (unidades.size() != 0);
	}
    
    private void eliminarUnidad(Unidad unaUnidad){
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

	@Override
	public void change() {
		AtomicReference<Unidad> unidadConVidaCero = new AtomicReference<>();
		unidades.stream().forEach(unidadPosicionado -> {
			if(unidadPosicionado.obtenerVida() == 0)
				unidadConVidaCero.set(unidadPosicionado);
		});
		this.eliminarUnidad(unidadConVidaCero.get());
	}
}
