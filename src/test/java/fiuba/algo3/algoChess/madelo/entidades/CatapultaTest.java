package fiuba.algo3.algoChess.madelo.entidades;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CatapultaTest {
    @Test
    public void testCatapultaEsCorrectamenteCreada(){
        assertNotNull(new Catapulta());
    }
}
