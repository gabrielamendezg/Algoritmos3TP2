package fiuba.algo3.algoChess.modelo.entidades.curandero;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class CurenderoTest {
    @Test
    public void testCuranderoEsCorrectamenteCreada(){
        Jugador jugador = new Jugador();
    	assertNotNull(new Curandero(jugador));
    }
}
