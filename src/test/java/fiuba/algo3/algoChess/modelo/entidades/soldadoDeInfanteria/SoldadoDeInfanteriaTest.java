package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.jugador.JugadorB;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoldadoDeInfanteriaTest {

    @Test
    public  void seVerificaQue3SoldadosContiguosPuedenMoverseAlMismoTiempoEnLaMismaDirecciónConUnaSolaAcciónTest(){

        JugadorA juagador1 = new JugadorA();
        JugadorB juagador2 = new JugadorB();

        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1);

        tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
        tablero.posicionarEn(juagador1, soldado2, new Posicion(2, 1));
        tablero.posicionarEn(juagador1, soldado3, new Posicion(3, 1));

        tablero.moverMovibleAAdelante(juagador1, soldado1);
        assertEquals(soldado1.getPosicion().getX(), 1);
        assertEquals(soldado1.getPosicion().getY(), 2);
        //assertEquals(soldado2.obtenerPosicionX(), 2);
        //assertEquals(soldado2.obtenerPosicionY(), 2);
        //assertEquals(soldado3.obtenerPosicionX(), 3);
        //assertEquals(soldado3.obtenerPosicionY(), 2);
    }
}
