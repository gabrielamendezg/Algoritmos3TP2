package fiuba.algo3.algoChess.modelo.jugador;

public class Jugador2 extends Jugador {
    public Jugador2(String nombre) {
        super(nombre);
        filamin = 11;
        filamax = 20;
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
