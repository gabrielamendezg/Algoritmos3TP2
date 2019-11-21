package fiuba.algo3.algoChess.modelo.entidades.catapulta;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

import static org.junit.jupiter.api.Assertions.*;


public class CatapultaTest {
    @Test
    public void testCatapultaEsCorrectamenteCreada(){
    	JugadorA jugador = new JugadorA();
        assertNotNull(new Catapulta(jugador));
    }
}
