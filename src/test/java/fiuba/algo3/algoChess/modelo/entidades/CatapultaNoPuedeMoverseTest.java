package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CatapultaNoPuedeMoverseTest {
	
	Catapulta catapulta = new Catapulta();
	
	@Test
	void test() {

		catapulta.setPosicion(1,1);
		
		catapulta.moverUnidadA(1,	2);
		
		assertTrue(catapulta.obtenerPosicionX() ==1 );
		assertTrue(catapulta.obtenerPosicionY() ==1);
		
	}

}
