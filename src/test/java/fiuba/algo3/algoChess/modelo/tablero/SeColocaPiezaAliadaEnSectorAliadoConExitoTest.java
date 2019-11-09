package fiuba.algo3.algoChess.modelo.tablero;

import org.junit.Test;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;

public class SeColocaPiezaAliadaEnSectorAliadoConExitoTest {

	@Test
	public void test() {
		//Arrange
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Unidad unidad1 = jugador1.elegirSoldado();
		Tablero tablero = Tablero.obtenerInstancia(jugador1, jugador2);
		tablero.colocarUnidad(jugador1, unidad1, 1, 1);
	}
}
