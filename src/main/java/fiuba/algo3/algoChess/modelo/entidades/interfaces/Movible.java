package fiuba.algo3.algoChess.modelo.entidades.interfaces;

import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;


public interface Movible {
    public Posicion getPosicion();
    public void setPosicion(Posicion posicion);
	public boolean movibleMoveteA(JugadorA jugador, Posicion unaPosicion);
    public boolean movibleMoveteA(JugadorB jugador, Posicion unaPosicion);
}
