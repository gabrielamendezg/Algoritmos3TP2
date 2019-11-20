package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class Jinete extends Unidad implements Sanable, Movible, Posicionable {
	
	public Jinete (String nombre) {
		super(nombre);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
		
	}

	@Override
	public void curarce(int conVida) {
		vida = vida + conVida;
	}

	@Override
	public boolean movibleMoveteA(String duenio, Posicion unaPosicion) {
		return super.movibleMomoveteA(duenio, unaPosicion);
	}
}
