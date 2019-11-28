package fiuba.algo3.algoChess.modelo.entidades.interfaces;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;


import java.util.ArrayList;


public interface Atacador {
    public void atacarAtacable(Jugador atacante, Atacable unAtacable, ArrayList<Atacable> atacables);
    public Posicion getPosicion();
}
