package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.Jugador1;
import fiuba.algo3.algoChess.modelo.jugador.Jugador2;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoldadoDeInfanteriaTest {

    @Test
    public  void seVerificaQue3SoldadosContiguosPuedenMoverseAlMismoTiempoEnLaMismaDirecciónConUnaSolaAcciónTest(){

        Jugador juagador1 = new Jugador1("elvis");
        Jugador juagador2 = new Jugador2("pepe");

        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1.nombre());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1.nombre());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1.nombre());

        tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
        tablero.posicionarEn(juagador1, soldado2, new Posicion(2, 1));
        tablero.posicionarEn(juagador1, soldado3, new Posicion(3, 1));

        tablero.moverMovibleA(juagador1, soldado1,new Posicion(2, 2));
        assertEquals(soldado1.getPosicion().getX(), 2);
        assertEquals(soldado1.getPosicion().getY(), 2);
        //assertEquals(soldado2.obtenerPosicionX(), 2);
        //assertEquals(soldado2.obtenerPosicionY(), 2);
        //assertEquals(soldado3.obtenerPosicionX(), 3);
        //assertEquals(soldado3.obtenerPosicionY(), 2);
    }
}
