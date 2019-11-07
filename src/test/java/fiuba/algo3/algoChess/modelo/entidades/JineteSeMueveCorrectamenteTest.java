package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.jugador.*;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

public class JineteSeMueveCorrectamenteTest {
	Jinete jinete = new Jinete();
	
	Jinete jinete2 = new Jinete();
	Jugador jugador = new Jugador();

	@Test
	void test() {

		jinete.setPosicion(1,1);
		
		jinete.setDuenio(jugador);
		jinete2.setDuenio(jugador);
		
		jinete.moverUnidadA(1,	2, jugador);
		
		jinete2.setPosicion(1, 5);
		
		jinete2.moverUnidadA(1, -1, jugador);
		
		assertTrue(jinete.obtenerPosicionX() ==1 );
		assertTrue(jinete.obtenerPosicionY() ==2);
		assertTrue(jinete2.obtenerPosicionX() == 1);
		assertTrue(jinete2.obtenerPosicionY() == 5);

		
	}
}
