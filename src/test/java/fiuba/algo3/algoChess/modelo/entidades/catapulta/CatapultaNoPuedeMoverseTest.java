package fiuba.algo3.algoChess.modelo.entidades.catapulta;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class CatapultaNoPuedeMoverseTest {
	
	Jugador jugador = new Jugador();
	Catapulta catapulta = new Catapulta(jugador);
	
	@Test
	void test() {

		catapulta.setPosicion(1,1);
		
		catapulta.moverUnidadA(jugador,1,2);
		
		assertTrue(catapulta.obtenerPosicionX() ==1 );
		assertTrue(catapulta.obtenerPosicionY() ==1);
		
	}

}
