package fiuba.algo3.algoChess.modelo.entidades.curandero;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

public class CuranderoSeMueveCorrectamenteTest {

	Jugador jugador = new JugadorA("");
	Curandero curandero = new Curandero("");

	@Test
	void test() {
		Tablero tablero = new Tablero();
		tablero.posicionarEn(jugador,curandero, new Posicion(1, 1));

		curandero.movibleMomoveteA("", new Posicion(1, 2));

		assertEquals(curandero.getPosicion().getX(), 1 );
		assertEquals(curandero.getPosicion().getY(), 2);
		
	}
}
