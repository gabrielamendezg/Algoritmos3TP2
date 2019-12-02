package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.jugador.JugadorB;

import java.util.ArrayList;

public class MovimientoDeBatallonDeSoldadosDeInfanteria {
    private int cantBatallon = 3;
    public MovimientoDeBatallonDeSoldadosDeInfanteria(int cant){
        cantBatallon = cant;
    }

    public boolean moverBatallonDeMovibleA(Tablero tablero, JugadorA jugador, Movible movible, Posicion aPosicion) {
        ArrayList<SoldadoDeInfanteria> batallon;
        int x = movible.getPosicion().getX();
        int y = movible.getPosicion().getY();
        if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y - 2) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y -2);
        } else if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y - 1) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y -1);
        } else if(this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y) != null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, movible, x, y);
        } else {
            return false;
        }

        Posicion dePosicion = movible.getPosicion();
        batallon.stream().forEach(soldado -> {
            try {

                this.moverAlIntegranteDelBatallon(tablero, jugador, soldado, dePosicion, aPosicion);
            } catch (PosicionOcupadaExcepcion e){}
        });
        return true;
    }

    public boolean moverBatallonDeMovibleA(Tablero tablero, JugadorB jugador, Movible movible, Posicion aPosicion) {
        ArrayList<SoldadoDeInfanteria> batallon;
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
        batallon.stream().forEach(soldado -> {
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, soldado, movible.getPosicion(), aPosicion);
            } catch (PosicionOcupadaExcepcion e){}
        });
        return true;
    }

    private void moverAlIntegranteDelBatallon(Tablero tablero, JugadorA jugador, Movible unMovible, Posicion dePosicion, Posicion aPosicion) {

        if((dePosicion.getX() == aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba
            tablero.moverMovibleAArriba(jugador, unMovible);
            return;
        }else if((dePosicion.getX() == aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo
            tablero.moverMovibleAAbajo(jugador,unMovible);
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() == aPosicion.getY())){//izquierda
            tablero.moverMovibleAIzquierda(jugador, unMovible);
            return;
        }else if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() == aPosicion.getY())){//derecha
            tablero.moverMovibleADerecha(jugador, unMovible);
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo izquierda
            tablero.moverMovibleAAbajoIzquierda(jugador, unMovible);
            return;
        }else if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() > aPosicion.getY())){//abajo derecha
            tablero.moverMovibleAAbajoDerecha(jugador, unMovible);
            return;
        }else if((dePosicion.getX() > aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba izquierda
            tablero.moverMovibleAArribaIzquierda(jugador, unMovible);
            return;
        }else  if((dePosicion.getX() < aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba derecha
            tablero.moverMovibleAArribaDerecha(jugador, unMovible);
            return;
        }
    }
    private void moverAlIntegranteDelBatallon(Tablero tablero, JugadorB jugador, Movible unMovible, Posicion dePosicion, Posicion aPosicion) {

        if((dePosicion.getX() == aPosicion.getX()) && (dePosicion.getY() < aPosicion.getY())){//arriba
            tablero.moverMovibleAArriba(jugador, unMovible);
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

    private ArrayList<SoldadoDeInfanteria> formarBatallonDeSoldadosDeInfanteria(Tablero tablero, Movible movible, int desX, int deY) {
        if(!(movible instanceof SoldadoDeInfanteria)) return null;
        ArrayList batallon = new<SoldadoDeInfanteria> ArrayList();

        for (int i = deY; i < deY+ cantBatallon; i++){
            Posicionable posicionable = tablero.getPosicionableDeLaPosicion(new Posicion(desX, i));
            if(!(posicionable instanceof SoldadoDeInfanteria)) return null;
            batallon.add(posicionable);
        }
        return batallon;//faltaria ver que pertenecen al mismo dueño
    }
}
