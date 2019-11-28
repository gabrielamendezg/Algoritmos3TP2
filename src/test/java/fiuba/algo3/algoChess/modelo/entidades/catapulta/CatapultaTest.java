package fiuba.algo3.algoChess.modelo.entidades.catapulta;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class CatapultaTest {
    @Test
    public void testCatapultaEsCorrectamenteCreada(){
    	JugadorA jugador = new JugadorA();
        assertNotNull(new Catapulta(jugador));
    }

    @Test
    public void catapultaAtacaCorectamenteTest(){
        JugadorA jugador = new JugadorA();
        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));
        LinkedList atacables = new <Atacable>LinkedList();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria(new JugadorB());
        soldadoDeInfanteria.setPosicion(new Posicion(11, 11));
        atacables.add(soldadoDeInfanteria);
        catapulta.atacarAtacable(new JugadorA(), soldadoDeInfanteria, atacables);
        assertEquals(soldadoDeInfanteria.obtenerVida(), 80);
    }

    @Test
    public void catapultaAtacaAlAtacableYALosAtacablesContiguas1Test(){
       JugadorA jugador = new JugadorA();
        JugadorB jugadorB = new JugadorB();

        LinkedList atacables = new <Atacable>LinkedList();

        SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
        for (int i = 0; i < 20; i++){
            soldado[i] = jugadorB.elegirSoldado();
        }

        soldado[0].setPosicion(new Posicion(8, 9));soldado[5].setPosicion(new Posicion(12, 9));
        soldado[1].setPosicion(new Posicion(9, 10));soldado[6].setPosicion(new Posicion(11, 10));
        soldado[2].setPosicion(new Posicion(10, 11));soldado[7].setPosicion(new Posicion(9, 12));
        soldado[3].setPosicion(new Posicion(11, 12));soldado[8].setPosicion(new Posicion(8, 13));
        soldado[4].setPosicion(new Posicion(12, 13));

        soldado[9].setPosicion(new Posicion(10, 9));soldado[13].setPosicion(new Posicion(8, 11));
        soldado[10].setPosicion(new Posicion(10, 10));soldado[14].setPosicion(new Posicion(9, 11));
        soldado[11].setPosicion(new Posicion(10, 12));soldado[15].setPosicion(new Posicion(11, 11));
        soldado[12].setPosicion(new Posicion(10, 13));soldado[16].setPosicion(new Posicion(12, 11));

        soldado[17].setPosicion(new Posicion(8, 15));
        soldado[18].setPosicion(new Posicion(9, 15));
        soldado[19].setPosicion(new Posicion(10, 15));

        for (int i = 0; i < 20; i++){
            if( i != 2)
                atacables.add(soldado[i]);
        }

        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));


        catapulta.atacarAtacable(new JugadorA(), soldado[2], atacables);

        for (int i = 0; i < 17; i++){
            assertEquals(soldado[i].obtenerVida(), 80);
        }

    }

    @Test
    public void catapultaAtacaAlAtacableYALosAtacablesContiguas2Test(){
        JugadorA jugador = new JugadorA();
        JugadorB jugadorB = new JugadorB();

        LinkedList atacables = new <Atacable>LinkedList();

        SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
        for (int i = 0; i < 20; i++){
            soldado[i] = jugadorB.elegirSoldado();
        }

        soldado[0].setPosicion(new Posicion(8, 9));soldado[5].setPosicion(new Posicion(12, 9));
        soldado[1].setPosicion(new Posicion(9, 10));soldado[6].setPosicion(new Posicion(11, 10));
        soldado[2].setPosicion(new Posicion(10, 11));soldado[7].setPosicion(new Posicion(9, 12));
        soldado[3].setPosicion(new Posicion(11, 12));soldado[8].setPosicion(new Posicion(8, 13));
        soldado[4].setPosicion(new Posicion(12, 13));

        soldado[9].setPosicion(new Posicion(10, 9));soldado[13].setPosicion(new Posicion(8, 11));
        soldado[10].setPosicion(new Posicion(10, 10));soldado[14].setPosicion(new Posicion(9, 11));
        soldado[11].setPosicion(new Posicion(10, 12));soldado[15].setPosicion(new Posicion(11, 11));
        soldado[12].setPosicion(new Posicion(10, 13));soldado[16].setPosicion(new Posicion(12, 11));

        soldado[17].setPosicion(new Posicion(8, 15));
        soldado[18].setPosicion(new Posicion(9, 15));
        soldado[19].setPosicion(new Posicion(10, 15));

        for (int i = 0; i < 20; i++){
            if( i != 0)
                atacables.add(soldado[i]);
        }

        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));


        catapulta.atacarAtacable(new JugadorA(), soldado[0], atacables);

        for (int i = 0; i < 5; i++){
            assertEquals(soldado[i].obtenerVida(), 80);
        }

    }

    @Test
    public void catapultaAtacaAlAtacableYALosAtacablesContiguas3Test(){
        JugadorA jugador = new JugadorA();
        JugadorB jugadorB = new JugadorB();

        LinkedList atacables = new <Atacable>LinkedList();

        SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
        for (int i = 0; i < 20; i++){
            soldado[i] = jugadorB.elegirSoldado();
        }

        soldado[0].setPosicion(new Posicion(8, 9));soldado[5].setPosicion(new Posicion(12, 9));
        soldado[1].setPosicion(new Posicion(9, 10));soldado[6].setPosicion(new Posicion(11, 10));
        soldado[2].setPosicion(new Posicion(10, 11));soldado[7].setPosicion(new Posicion(9, 12));
        soldado[3].setPosicion(new Posicion(11, 12));soldado[8].setPosicion(new Posicion(8, 13));
        soldado[4].setPosicion(new Posicion(12, 13));

        soldado[9].setPosicion(new Posicion(10, 9));soldado[13].setPosicion(new Posicion(8, 11));
        soldado[10].setPosicion(new Posicion(10, 10));soldado[14].setPosicion(new Posicion(9, 11));
        soldado[11].setPosicion(new Posicion(10, 12));soldado[15].setPosicion(new Posicion(11, 11));
        soldado[12].setPosicion(new Posicion(10, 13));soldado[16].setPosicion(new Posicion(12, 11));

        soldado[17].setPosicion(new Posicion(8, 15));
        soldado[18].setPosicion(new Posicion(9, 15));
        soldado[19].setPosicion(new Posicion(10, 15));

        for (int i = 0; i < 20; i++){
            if( i != 17)
                atacables.add(soldado[i]);
        }

        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));


        catapulta.atacarAtacable(new JugadorA(), soldado[17], atacables);

        for (int i = 17; i < 20; i++){
            assertEquals(soldado[i].obtenerVida(), 80);
        }

    }

    @Test
    public void catapultaAtacaAlAtacableYALosAtacablesContiguasAunQueSeanAliados4Test(){
        JugadorA jugador = new JugadorA();
        JugadorB jugadorB = new JugadorB();

        LinkedList atacables = new <Atacable>LinkedList();

        SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
        for (int i = 0; i < 20; i++){
            if (i == 2)
                soldado[i] = jugadorB.elegirSoldado();
            soldado[i] = jugador.elegirSoldado();
        }

        soldado[0].setPosicion(new Posicion(8, 9));soldado[5].setPosicion(new Posicion(12, 9));
        soldado[1].setPosicion(new Posicion(9, 10));soldado[6].setPosicion(new Posicion(11, 10));
        soldado[2].setPosicion(new Posicion(10, 11));soldado[7].setPosicion(new Posicion(9, 12));
        soldado[3].setPosicion(new Posicion(11, 12));soldado[8].setPosicion(new Posicion(8, 13));
        soldado[4].setPosicion(new Posicion(12, 13));

        soldado[9].setPosicion(new Posicion(10, 9));soldado[13].setPosicion(new Posicion(8, 11));
        soldado[10].setPosicion(new Posicion(10, 10));soldado[14].setPosicion(new Posicion(9, 11));
        soldado[11].setPosicion(new Posicion(10, 12));soldado[15].setPosicion(new Posicion(11, 11));
        soldado[12].setPosicion(new Posicion(10, 13));soldado[16].setPosicion(new Posicion(12, 11));

        soldado[17].setPosicion(new Posicion(8, 15));
        soldado[18].setPosicion(new Posicion(9, 15));
        soldado[19].setPosicion(new Posicion(10, 15));

        for (int i = 0; i < 20; i++){
            if( i != 2)
                atacables.add(soldado[i]);
        }

        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));


        catapulta.atacarAtacable(new JugadorA(), soldado[2], atacables);

        for (int i = 0; i < 17; i++){
            assertEquals(soldado[i].obtenerVida(), 80);
        }

    }
}
