package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class Curandero extends Unidad implements Movible, Posicionable {

	private int poderCuracion = 15;

	public Curandero(String nombre) {
		super(nombre);
		vida = 75;
		ataque = new AtaqueDistanciaMedia(15);
		costo = 2;
	}

	public void sanar(Sanable unidad) {


		if ( ataque.estaEnRango(posicion.getX(), posicion.getY(),(Unidad) unidad)){
			unidad.curarce(poderCuracion);
		}
	}

	@Override
	public boolean movibleMoveteA(String duenio, Posicion unaPosicion) {
		return super.movibleMomoveteA(duenio, unaPosicion);
	}
}
