package fiuba.algo3.algoChess.madelo.entidades;

import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JineteTest {
    @Test
    public void testJineteEsCorrectamenteCreado(){
        assertNotNull(new Jinete());
    }
}
