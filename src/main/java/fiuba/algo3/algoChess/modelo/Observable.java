package fiuba.algo3.algoChess.modelo;

import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observador> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observador observador) {
        observers.add(observador);
    }

    public void notificarObservadores() {
        observers.stream().forEach(observer -> observer.change());
    }
}
