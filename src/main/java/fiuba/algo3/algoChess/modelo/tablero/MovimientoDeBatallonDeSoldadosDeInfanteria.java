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
            try {
                this.moverAlIntegranteDelBatallon(jugador, posicionable, movible.getPosicion(), aPosicion);
            } catch (PosicionOcupadaExcepcion e){}
        });
        return true;
    }

    private void moverAlIntegranteDelBatallon(Jugador jugador, Movible unPosicionable, Posicion dePosicion, Posicion aPosicion) {

        if((dePosicion.getX() == aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba
            return;
        }else if((dePosicion.getX() == aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() == aPosicion.getY())){//izquierda
            return;
        }else if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() == aPosicion.getY())){//derecha
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo izquierda
            return;
        }else if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo derecha
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba izquierda
            return;
        }else  if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba derecha
            return;
        }
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
