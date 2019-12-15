package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
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
        batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero,jugador , movible, x, y - 2);
        if(batallon == null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero,jugador , movible, x, y -1);
        }
        if(batallon == null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, jugador, movible, x, y);
        }

        if (batallon != null){
            Posicion dePosicion = movible.getPosicion();
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(0), dePosicion, aPosicion);
            } catch (PosicionOcupadaExcepcion e){
                Posicionable posicionable = tablero.getPosicionableDeLaPosicion(aPosicion);
                if (batallon.contains(posicionable)) throw new PosicionOcupadaExcepcion();
            }
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(2), dePosicion, aPosicion);
            }catch (PosicionOcupadaExcepcion a){}
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(1), dePosicion, aPosicion);
            }catch (PosicionOcupadaExcepcion a){}
            return true;
        }
        return false;
    }
    public boolean moverBatallonDeMovibleA(Tablero tablero, JugadorB jugador, Movible movible, Posicion aPosicion) {
        ArrayList<SoldadoDeInfanteria> batallon;
        int x = movible.getPosicion().getX();
        int y = movible.getPosicion().getY();
        batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero,jugador , movible, x, y - 2);
        if(batallon == null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero,jugador , movible, x, y -1);
        }
        if(batallon == null){
            batallon = this.formarBatallonDeSoldadosDeInfanteria(tablero, jugador, movible, x, y);
        }

        if (batallon != null){
            Posicion dePosicion = movible.getPosicion();
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(0), dePosicion, aPosicion);
            } catch (PosicionOcupadaExcepcion e){
                Posicionable posicionable = tablero.getPosicionableDeLaPosicion(aPosicion);
                if (batallon.contains(posicionable)) throw new PosicionOcupadaExcepcion();
            }
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(1), dePosicion, aPosicion);
                }catch (PosicionOcupadaExcepcion a){}
            try {
                this.moverAlIntegranteDelBatallon(tablero, jugador, batallon.get(2), dePosicion, aPosicion);
            }catch (PosicionOcupadaExcepcion a){}
            return true;
        }
        return false;
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

    private ArrayList<SoldadoDeInfanteria> formarBatallonDeSoldadosDeInfanteria(Tablero tablero, Jugador jugador, Movible movible, int desX, int deY) {
        if(!(movible instanceof SoldadoDeInfanteria)) return null;
        ArrayList batallon = new<SoldadoDeInfanteria> ArrayList();

        batallon.add(movible);
        for (int i = deY; i < deY + cantBatallon; i++){
            Posicionable posicionable = tablero.getPosicionableDeLaPosicion(new Posicion(desX, i));
            if(!(posicionable instanceof SoldadoDeInfanteria)) return null;
            if (!jugador.obtenerUnidades().contains(posicionable)) return null;
            if (!batallon.contains(posicionable))
                batallon.add(posicionable);
        }
        return batallon;
    }
}
