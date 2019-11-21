package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
//import fiuba.algo3.algoChess.modelo.tablero.Tablero;

public class Catapulta extends Unidad implements Posicionable {
	
	public Catapulta(String nombre) {
		super(nombre);
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
}
