package fiuba.algo3.algoChess.modelo.celda;

import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public interface Posicionable {
   public Posicion getPosicion();
   public void setPosicion(Posicion posicion);
   public void  posicionateEnEstaPosicion(JugadorA jugador, Posicion aPosicion);
   public void  posicionateEnEstaPosicion(JugadorB jugador, Posicion aPosicion);

    int costo();

    void addObserver(Observador observador);

    int obtenerVida();
}
