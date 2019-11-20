package fiuba.algo3.algoChess.modelo.celda;

import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public interface Posicionable {
   public Posicion getPosicion();
   public void setPosicion(Posicion posicion);
   public void  posicionateEnEstaPosicion(String duenio, Posicion aPosicion);
}
