package fiuba.algo3.algoChess.modelo.algoChess;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.modelo.Observable;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacante;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanador;
import fiuba.algo3.algoChess.modelo.tablero.*;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;

public class AlgoChess {

	private static AlgoChess algoChess = new AlgoChess();
	private Tablero tablero = new Tablero();
	private JugadorA jugadorA = new JugadorA();
	private JugadorB jugadorB = new JugadorB();

	private Jugador jugadorActivo = jugadorA;
	private Jugador jugadorOponente = jugadorB;

	

	private AlgoChess() {
		tablero = new Tablero();
	}

	public static AlgoChess getAlgoChess(){
		return algoChess;
	}
	public static void reiniciarAlgoChess(){
		algoChess = new AlgoChess();
	}

	public void posicionarPosicionable(Posicionable posicionable, int x, int y) {

		if(jugadorActivo instanceof JugadorA) {
			tablero.posicionarEn((JugadorA) jugadorActivo, posicionable, new Posicion(x, y));
			this.actualizarObservadores((Observable) posicionable);
		}if(jugadorActivo instanceof JugadorB) {
			tablero.posicionarEn((JugadorB) jugadorActivo, posicionable, new Posicion(x, y));
			this.actualizarObservadores((Observable) posicionable);
		}
	}

	public void actualizarObservadores(Observable posicionable) {
		posicionable.eliminarObservadores();
		posicionable.addObserver(tablero.getCeldaDeLaPosicion(posicionable.getPosicion().getX(),posicionable.getPosicion().getY()));
		posicionable.addObserver(AlgoChessControler.getAlgoChessControler());
	}

	public Jugador getJugadorActivo() {
		return jugadorActivo;
	}

	public void pasarTurno() {
		Jugador tem = jugadorActivo;
		jugadorActivo = jugadorOponente;
		jugadorOponente = tem;
	}

	public void jugadorActivoAzul() {
		jugadorActivo = jugadorA;
		jugadorOponente = jugadorB;
	}
	public void jugadorActivoRojo() {
		jugadorActivo = jugadorB;
		jugadorOponente = jugadorA;
	}

	public Posicionable unidadDeLaPosicion(int x, int y) {
		return tablero.getPosicionableDeLaPosicion(new Posicion(x, y));
	}

	public void primeraUnidadSeleccionadaAtacaSegundaUnida(Atacante unidad1, Atacable unidad2) {
		if(jugadorActivo instanceof JugadorA)
			tablero.atacanteAtacarAtacable((JugadorA) jugadorActivo, unidad1, unidad2);
		if(jugadorActivo instanceof JugadorB)
			tablero.atacanteAtacarAtacable((JugadorB) jugadorActivo, unidad1, unidad2);
	}
	
	
	public void moverUnidadDerecha(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleADerecha((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleADerecha((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadIzquierda(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAIzquierda((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAIzquierda((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadArriba(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAArriba((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAArriba((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadAbajo(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAAbajo((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAAbajo((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadArribaDerecha(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAArribaDerecha((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAArribaDerecha((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadAbajoDerecha(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAAbajoDerecha((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAAbajoDerecha((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadAbajoIzquierda(Movible unidad) {
		if(jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAAbajoIzquierda((JugadorA) jugadorActivo, unidad);
		if(jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAAbajoIzquierda((JugadorB) jugadorActivo, unidad);
	}
	
	public void moverUnidadArribaIzquierda(Movible unidad) {
		if (jugadorActivo instanceof JugadorA)
			tablero.moverMovibleAArribaIzquierda((JugadorA) jugadorActivo, unidad);
		if (jugadorActivo instanceof JugadorB)
			tablero.moverMovibleAArribaIzquierda((JugadorB) jugadorActivo, unidad);
	}

	public boolean hayGanador() {
		if(!jugadorA.sigueEnJuego() || !jugadorB.sigueEnJuego()) return true;
		return false;
	}

	public Jugador obtenerGanador() {
		if(!jugadorA.sigueEnJuego()) return jugadorB;
		else if(!jugadorB.sigueEnJuego()) return jugadorA;
		return null;
	}

	public void primeraUnidadSeleccionadaCuraSegundaUnidad(Sanador unidad1, Sanable unidad2) {
		unidad1.sanar(unidad2);
	}

	public void eliminarUnidadesMuertasDelTabler() {
		tablero.eliminarUnidadesMuertasDelTabler();
	}

	public void eliminarUnidadesMuertasDeLosJugadores() {
		ArrayList<Unidad> unidadConVidaCeroA = new ArrayList<>();
		jugadorA.obtenerUnidades().stream().forEach(unidadPosicionado -> {
			if(unidadPosicionado.obtenerVida() <= 0)
				unidadConVidaCeroA.add(unidadPosicionado);
		});
		unidadConVidaCeroA.stream().forEach(unidadMuerta -> {

			jugadorA.eliminarUnidad(unidadMuerta);
		});

		ArrayList<Unidad> unidadConVidaCeroB = new ArrayList<>();
		jugadorB.obtenerUnidades().stream().forEach(unidadPosicionado -> {
			if(unidadPosicionado.obtenerVida() <= 0)
				unidadConVidaCeroB.add(unidadPosicionado);
		});
		unidadConVidaCeroB.stream().forEach(unidadMuerta -> {

			jugadorB.eliminarUnidad(unidadMuerta);
		});
	}
}
