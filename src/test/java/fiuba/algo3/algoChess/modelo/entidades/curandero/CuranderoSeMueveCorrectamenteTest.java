package fiuba.algo3.algoChess.modelo.entidades.curandero;
import static org.junit.Assert.assertEquals;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;

import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

public class CuranderoSeMueveCorrectamenteTest {

	JugadorA jugador = new JugadorA();
	Curandero curandero = new Curandero(jugador);

	@Test
	void test() {
		Tablero tablero = new Tablero();
		tablero.posicionarEn(jugador,curandero, new Posicion(1, 1));

		curandero.movibleMoveteA(jugador, new Posicion(1, 2));

		assertEquals(curandero.getPosicion().getX(), 1 );
		assertEquals(curandero.getPosicion().getY(), 2);
		
	}
}
