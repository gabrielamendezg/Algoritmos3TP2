package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.jugador.*;

import org.junit.jupiter.api.Test;

public class CatapultaNoPuedeMoverseTest {
	
	Catapulta catapulta = new Catapulta();

	Jugador jugador = new Jugador();

	
	@Test
	void test() {

		catapulta.setPosicion(1,1);

		catapulta.moverUnidadA(1,2, jugador);
		assertTrue(catapulta.obtenerPosicionX() ==1 );
		assertTrue(catapulta.obtenerPosicionY() ==1);
		
	}

}
