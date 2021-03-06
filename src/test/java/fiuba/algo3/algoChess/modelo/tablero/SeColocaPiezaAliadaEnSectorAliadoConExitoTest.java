package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import org.junit.Test;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeColocaPiezaAliadaEnSectorAliadoConExitoTest {

	@Test
	public void test() {
		//Arrange
		JugadorA jugador = new JugadorA();
		Unidad unidad = jugador.elegirSoldado();
		Tablero tablero =  new Tablero();
		tablero.posicionarEn(jugador, unidad, new Posicion(1, 1));
		assertEquals(unidad.getPosicion().getX(), 1);
        assertEquals(unidad.getPosicion().getY(), 1);
	}

}
