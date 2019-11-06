package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SoldadoDeInfanteriaTest {
    @Test
    public void testSoldadoDeInfanteriaEsCorrectamenteCreada(){
        assertNotNull(new SoldadoDeInfanteria());
    }
    /*public void soldadoDeInfanteriaPuedeMoverceAUnaCasillaVaciaTest(){

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();

        assertTrue(soldado.moverseACasilla(new Casilla()));
    }*/
}
