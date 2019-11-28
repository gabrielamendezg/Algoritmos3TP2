package fiuba.algo3.algoChess.modelo.entidades;


import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.jugador.*;

public abstract class Unidad implements Posicionable {
	
	//Atributos.
	protected int vida;
	protected int costo;
	protected TipoUnidad tipo;

	protected Posicion posicion;


	public Unidad(JugadorA jugador) {
		posicion = new Posicion(-1, -1);
		tipo = new UnidadA();
	}
	
	public Unidad(JugadorB jugador) {
		posicion = new Posicion(-1,-1);
		tipo = new UnidadB();
	}

	public void recibirAtaque(int daño) {
		vida = vida- daño;

	}

	public int obtenerVida(){
		return vida;
	}


	@Override
	public Posicion getPosicion() {
		return posicion;
	}

	@Override
	public void setPosicion(Posicion newPosicion) {
		posicion = newPosicion;
	}
	
	@Override
	public void posicionateEnEstaPosicion(JugadorA jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}
	@Override
	public void posicionateEnEstaPosicion(JugadorB jugador, Posicion aPosicion) {
		tipo.posicionarEnEstaPosicion(this,jugador,aPosicion);
	}

}
