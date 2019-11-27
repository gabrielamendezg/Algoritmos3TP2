package fiuba.algo3.algoChess.modelo.entidades.interfaces;

import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public interface Atacable {
    public void recibirAtaque(int daño);
    public Posicion getPosicion();
}
