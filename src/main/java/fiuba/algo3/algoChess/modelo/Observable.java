package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

import java.util.ArrayList;

public abstract class Observable {
    protected ArrayList<Observador> observersMovi;
    protected ArrayList<Observador> observersAtaque;

    public Observable() {
        observersMovi = new ArrayList<>();
        observersAtaque = new ArrayList<>();
    }

    public void addObserver(Observador observador) {
        if (observador instanceof AlgoChessControler)
            observersMovi.add(observador);
        else observersAtaque.add(observador);
    }

    public void notificarObservadoresMovimiento() {
        observersMovi.stream().forEach(observer -> observer.change());
    }
    public void notificarObservadoresAtaques() {
        observersAtaque.stream().forEach(observer -> observer.change());
    }
    public abstract void eliminarObservadores();

    public abstract Posicion getPosicion();
}
