package fiuba.algo3.algoChess.modelo.jugador;

public class Jugador1 extends Jugador {
    public Jugador1(String nombre) {
        super(nombre);
        filamin = 1;
        filamax = 10;
        columnamin = 1;
        columnamax = 20;
    }

    public int getFilaMin() {
        return filamin;
    }

    public int grtFilaMax() {
        return filamax;
    }
    public int getColumnaMin() {
        return columnamin;
    }
    public int getColumnaMax() {
        return columnamax;
    }
}
