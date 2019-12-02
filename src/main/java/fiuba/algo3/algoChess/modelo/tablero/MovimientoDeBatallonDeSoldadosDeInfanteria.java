package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import java.util.ArrayList;

public class MovimientoDeBatallonDeSoldadosDeInfanteria {
    private int cantBatallon = 3;
    public MovimientoDeBatallonDeSoldadosDeInfanteria(int cant){
        cantBatallon = cant;
    }

    public boolean moverBatallonDeMovibleA(Tablero tablero, Jugador jugador, Movible movible, Posicion aPosicion) {
        ArrayList<Movible> batallon;
        int fila = movible.getPosicion().getX();
        int col = movible.getPosicion().getY();
        if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila - 2, col) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila - 2, col);
        } else if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila - 1, col) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila - 1, col);
        } else if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila, col) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, fila, col);
        } else {
            return false;
        }
        batallon.stream().forEach(posicionable -> {
            Posicion posicion = this.determinarMovimientoDelIntegrantePosicionadoEnConMovimientoDeA(posicionable.getPosicion(), movible.getPosicion(), aPosicion);
            try {
                tablero.moverMovibleA(jugador, posicionable,posicion);
            } catch (PosicionOcupadaExcepcion e){}
        });
        return true;
    }

    private Posicion determinarMovimientoDelIntegrantePosicionadoEnConMovimientoDeA(Posicion posicionActual, Posicion dePosicion, Posicion aPosicion) {
        int x = -1, y = -1;
        if(dePosicion.getX() < aPosicion.getX()){
            x = posicionActual.getX() +1;
        }else if(dePosicion.getX() > aPosicion.getX()){
            x = posicionActual.getX() -1;
        }else if(dePosicion.getX() == aPosicion.getX()){
            x = posicionActual.getX();
        }

        if(dePosicion.getY() < aPosicion.getY()){
            y = posicionActual.getY() +1;
        }else if(dePosicion.getY() > aPosicion.getY()){
            y = posicionActual.getY() -1;
        }else if(dePosicion.getY() == aPosicion.getY()){
            y = posicionActual.getY();
        }
        return new Posicion(x, y);
    }

    private ArrayList<Movible> formarBatallonDeSoldadosDeInfanteria(Tablero tablero, Movible movible, int desFil, int deCol) {
        if(!(movible instanceof SoldadoDeInfanteria)) return null;
        ArrayList batallon = new ArrayList();

        for (int i = desFil; i < desFil + cantBatallon; i++){
            Posicionable posicionable = tablero.getPosicionableDeLaPosicion(new Posicion(i, deCol));
            if(!(posicionable instanceof SoldadoDeInfanteria)) return null;
            batallon.add(posicionable);
        }
        return batallon;//faltaria ver que pertenecen al mismo dueño
    }
}
