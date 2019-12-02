package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
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

        tablero.posicionarEn(juagador1, soldado1, new Posicion(1,1));
        tablero.posicionarEn(juagador1, soldado2, new Posicion(1,2));
        tablero.posicionarEn(juagador1, soldado3, new Posicion(1,3));

        tablero.moverMovibleAArribaDerecha(juagador1, soldado3);

        assertEquals(soldado3.getPosicion().getX(), 2);
        assertEquals(soldado3.getPosicion().getY(), 4);
        assertEquals(soldado1.getPosicion().getX(), 2);
        assertEquals(soldado1.getPosicion().getY(), 2);
        assertEquals(soldado2.getPosicion().getX(), 2);
        assertEquals(soldado2.getPosicion().getY(), 3);

    }

    @Test
    public  void habiendo4SoldadosContiguosSeVerificaQueAlMoverUnBatallonSeMuevenUnicamente3Test(){

        JugadorA juagador1 = new JugadorA();
        JugadorB juagador2 = new JugadorB();

        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria(juagador1);

        tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
        tablero.posicionarEn(juagador1, soldado2, new Posicion(1, 2));
        tablero.posicionarEn(juagador1, soldado3, new Posicion(1, 3));
        tablero.posicionarEn(juagador1, soldado4, new Posicion(1, 4));

        tablero.moverMovibleADerecha(juagador1, soldado3);

        assertEquals(soldado3.getPosicion().getX(), 2);
        assertEquals(soldado3.getPosicion().getY(), 3);
        assertEquals(soldado1.getPosicion().getX(), 2);
        assertEquals(soldado1.getPosicion().getY(), 1);
        assertEquals(soldado2.getPosicion().getX(), 2);
        assertEquals(soldado2.getPosicion().getY(), 2);
        assertEquals(soldado4.getPosicion().getX(), 1);
        assertEquals(soldado4.getPosicion().getY(), 4);

    }

    @Test
    public  void seVerificaQueSolo2SoldadosSeMuevenDeUnBatallonDe3SoldadosContiguosPorEncontrarceUnoConUnObstaculoTest(){

        JugadorA juagador1 = new JugadorA();
        JugadorB juagador2 = new JugadorB();

        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1);
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1);
        Catapulta catapulta = new Catapulta(juagador1);

        tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
        tablero.posicionarEn(juagador1, soldado2, new Posicion(1, 2));
        tablero.posicionarEn(juagador1, soldado3, new Posicion(1, 3));
        tablero.posicionarEn(juagador1, catapulta, new Posicion(2, 2));

        tablero.moverMovibleADerecha(juagador1, soldado3);

        assertEquals(soldado3.getPosicion().getX(), 2);
        assertEquals(soldado3.getPosicion().getY(), 3);
        assertEquals(soldado1.getPosicion().getX(), 2);
        assertEquals(soldado1.getPosicion().getY(), 1);
        assertEquals(soldado2.getPosicion().getX(), 1);
        assertEquals(soldado2.getPosicion().getY(), 2);

    }
}
