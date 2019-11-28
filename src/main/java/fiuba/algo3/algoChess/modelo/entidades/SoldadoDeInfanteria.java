package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import java.util.ArrayList;

public class SoldadoDeInfanteria extends Unidad implements Sanable, Movible, Posicionable, Atacable, Atacador {


	private AtaqueCercano ataque;

	public SoldadoDeInfanteria(JugadorA jugador) {
		super(jugador);
		ataque = new AtaqueCercano(10);
		vida = 100;
		costo = 1;
	}
	
	public SoldadoDeInfanteria(JugadorB jugador) {
		super(jugador);
		ataque = new AtaqueCercano(10);
		vida = 100;
		costo = 1;
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
	public void atacarAtacable(Jugador atacante, Atacable unAtacable, ArrayList<Atacable> atacables) {
		ArrayList<Unidad> aliados = atacante.obtenerUnidades();
		if(aliados.contains(unAtacable)) return;
		ataque.atacar(posicion.getX(), posicion.getY(), unAtacable);
	}
}
