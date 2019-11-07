package fiuba.algo3.algoChess.modelo.entidades;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class JineteTest {
    @Test
    public void testJineteEsCorrectamenteCreado(){
    	Jugador jugador = new Jugador();
        assertNotNull(new Jinete(jugador));
    }
}
