package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
//import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Catapulta extends Unidad implements Posicionable, Atacador, Atacable {

	private AtaqueDistanciaLejana ataque;

	public Catapulta(JugadorA jugador) {
		super(jugador);
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
	
	public Catapulta(JugadorB jugador) {
		super(jugador);
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}

	@Override
	public void atacarAtacable(Jugador atacante, Atacable unAtacable, LinkedList atacables) {
		ArrayList aliados = atacante.obtenerUnidades();
		if(aliados.contains(unAtacable)) return;
		ataque.atacar(posicion.getX(), posicion.getY(), unAtacable);
		//falta
	}
}
