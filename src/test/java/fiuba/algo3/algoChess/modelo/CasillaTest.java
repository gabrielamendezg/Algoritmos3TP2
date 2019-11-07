package fiuba.algo3.algoChess.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasillaTest {
    @Test
    public void testCasillaEsCorrectamenteCreada(){
        assertNotNull(new Casilla());
    }

    /*@Test
    public void testCasillaRecienCreadaNoEstaOcupado(){
        Casilla casilla = new Casilla();
        assertFalse(casilla.ocupado());
    }*/
}
