package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

import java.util.LinkedList;

public class Jinete extends Unidad implements Sanable, Movible, Posicionable, Atacador, Atacable {

	private AtaqueCercano ataque;

	public Jinete (JugadorA jugador) {
		super(jugador);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
	}
	
	public Jinete (JugadorB jugador) {
		super(jugador);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
	}

	@Override
	public void curarce(int conVida) {
		vida = vida + conVida;
	}

	@Override
	public boolean movibleMoveteA(JugadorA jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}
	@Override
	public boolean movibleMoveteA(JugadorB jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}

	@Override
	public void atacarAtacable(Jugador atacante, Atacable unAtacable, LinkedList atacables) {

	}
}
