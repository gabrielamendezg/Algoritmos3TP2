package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class SoldadoDeInfanteria extends Unidad implements Sanable, Movible, Posicionable {


	public SoldadoDeInfanteria(String nombreDejugador) {
		super(nombreDejugador);
		ataque = new AtaqueCercano(10);
		vida = 100;
		costo = 1;
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
