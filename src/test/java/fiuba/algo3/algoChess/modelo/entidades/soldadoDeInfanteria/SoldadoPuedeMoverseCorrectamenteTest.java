package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;


import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoldadoPuedeMoverseCorrectamenteTest {
    Jugador jugador = new JugadorA("");
    SoldadoDeInfanteria soldado = new SoldadoDeInfanteria("");

    @Test
    void test() {
        Tablero tablero = new Tablero();
        tablero.posicionarEn(jugador,soldado, new Posicion(1, 1));
        soldado.movibleMomoveteA("", new Posicion(1, 2));

        assertEquals(soldado.getPosicion().getX(), 1 );
        assertEquals(soldado.getPosicion().getY(), 2);

    }

}
