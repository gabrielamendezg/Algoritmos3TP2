package fiuba.algo3.algoChess.modelo.entidades.interfaces;

import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public interface Movible {
    public boolean movibleMoveteA(String duenio, Posicion unaPosicion);
    public Posicion getPosicion();
}
