package fiuba.algo3.algoChess.modelo.tablero;


import static org.junit.jupiter.api.Assertions.assertThrows;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import org.junit.Test;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class NoSePuedeColocarPiezaEnCeldaAliadaOcupadaTest {

	@Test
	public void TableroNoPuedeColocarPiezaEnCeldaAliadaOcupadaTest() {
		//Arange
		Jugador jugador1 = new Jugador1("elvis");
		Unidad unidad1 = jugador1.elegirSoldado();
		Unidad unidad2 = jugador1.elegirSoldado();
        Tablero tablero = new Tablero();
		tablero.posicionarEn(jugador1, unidad1, new Posicion(1, 1));
		assertThrows(PosicionOcupadaExcepcion.class,
				() -> {
					tablero.posicionarEn(jugador1, unidad2, new Posicion(1, 1));

						});

	}
}
