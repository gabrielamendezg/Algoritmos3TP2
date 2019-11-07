package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;
import fiuba.algo3.algoChess.modelo.jugador.*;

import org.junit.jupiter.api.Test;

public class CuranderoSeMueveCorrectamenteTest {


	Curandero curandero = new Curandero();
	Jugador jugador = new Jugador();
	@Test
	void test() {

		curandero.setPosicion(1,1);
		curandero.setDuenio(jugador);
		
		curandero.moverUnidadA(jugador,1,2);
		
		assertTrue(curandero.obtenerPosicionX() ==1 );
		assertTrue(curandero.obtenerPosicionY() ==2);
		
	}
}
