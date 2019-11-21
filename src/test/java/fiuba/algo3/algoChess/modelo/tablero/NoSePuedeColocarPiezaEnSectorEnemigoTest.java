package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.Excepciones.FilaOColumnaNoPerteneceATuParteDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoSePuedeColocarPiezaEnSectorEnemigoTest {

	@Test
	public void TableroNoPuedeColocarPiezaEnSectorEnemigoTest() {
		//Arrange
		JugadorA jugador = new JugadorA();
		Unidad unidad1 = jugador.elegirSoldado();
		Tablero tablero = new Tablero();
		assertThrows(FilaOColumnaNoPerteneceATuParteDelTableroExcepcion.class,
				()->{
					tablero.posicionarEn(jugador, unidad1, new Posicion(15, 1));
				});

	}
}
