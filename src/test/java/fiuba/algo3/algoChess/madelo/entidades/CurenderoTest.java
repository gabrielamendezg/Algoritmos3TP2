package fiuba.algo3.algoChess.madelo.entidades;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurenderoTest {
    @Test
    public void testCuranderoEsCorrectamenteCreada(){
        assertNotNull(new Curandero());
    }
}
