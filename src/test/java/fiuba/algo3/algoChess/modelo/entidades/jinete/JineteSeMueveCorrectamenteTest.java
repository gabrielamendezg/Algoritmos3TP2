package fiuba.algo3.algoChess.modelo.entidades.jinete;

import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.jugador.*;


import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JineteSeMueveCorrectamenteTest {
    Jugador jugador = new Jugador1("");
    Jinete jinete = new Jinete("");

    @Test
    void test() {
        Tablero tablero = new Tablero();
        tablero.posicionarEn(jugador, jinete, new Posicion(1, 1));

        jinete.movibleMomoveteA( "", new Posicion(1, 2));
        assertEquals(jinete.getPosicion().getX(), 1 );
        assertEquals(jinete.getPosicion().getY(), 2);

    }
}