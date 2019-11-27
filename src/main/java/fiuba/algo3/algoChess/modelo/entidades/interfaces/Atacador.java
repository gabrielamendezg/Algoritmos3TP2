package fiuba.algo3.algoChess.modelo.entidades.interfaces;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import java.util.LinkedList;

public interface Atacador {
    public void atacarAtacable(Jugador atacante, Atacable unAtacable, LinkedList atacables);
}
