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
    public void catapultaAtacaAlAtacableYALosAtacablesContiguasTest(){
     /*   JugadorA jugador = new JugadorA();
        Catapulta catapulta = new Catapulta(jugador);
        catapulta.setPosicion(new Posicion(1,1));
        LinkedList atacables = new <Atacable>LinkedList();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria(new JugadorB());
        soldadoDeInfanteria.setPosicion(new Posicion(11, 11));
        atacables.add(soldadoDeInfanteria);
        catapulta.atacarAtacable(new JugadorA(), soldadoDeInfanteria, atacables);
        assertEquals(soldadoDeInfanteria.obtenerVida(), 80);*/
    }
}
