package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class JineteSeMueveCorrectamenteTest {
	Jinete jinete = new Jinete();

	@Test
	void test() {

		jinete.setPosicion(1,1);
		
		jinete.moverUnidadA(1,	2);
		
		assertTrue(jinete.obtenerPosicionX() ==1 );
		assertTrue(jinete.obtenerPosicionY() ==2);
		
	}
}
