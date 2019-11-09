package fiuba.algo3.algoChess.modelo.entidades.curandero;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.jugador.*;

import org.junit.jupiter.api.Test;

public class CuranderoSeMueveCorrectamenteTest {

	Jugador jugador = new Jugador();
	Curandero curandero = new Curandero(jugador);

	@Test
	void test() {

		curandero.setPosicion(1,1);
		curandero.setDuenio(jugador);
		
		curandero.moverUnidadA(jugador,1,2);
		
		assertTrue(curandero.obtenerPosicionX() ==1 );
		assertTrue(curandero.obtenerPosicionY() ==2);
		
	}
}
