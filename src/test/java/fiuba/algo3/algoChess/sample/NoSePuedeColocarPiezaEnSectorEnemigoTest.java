package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.JugadorInvalido;
import fiuba.algo3.algoChess.tablero.PosicionInvalidaException;
import fiuba.algo3.algoChess.tablero.Tablero;

public class NoSePuedeColocarPiezaEnSectorEnemigoTest {

	@Test
	public void TableroNoPuedeColocarPiezaEnSectorEnemigoTest() {
		//Arrange
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Unidad unidad1 = jugador1.elegirSoldado();
		
		try {
			Tablero tablero = Tablero.obtenerInstancia(jugador1,jugador2);
			tablero.colocarUnidad(jugador1, unidad1,15,1);
		} catch (InstanciaDeTableroYaExiste e) {
			fail("No se pudo crear tablero porque ya existe uno.");
		} catch (JugadorInvalido e) {
			fail("JugadorInvalido exception");
		} catch (PosicionInvalidaException e) {
			assert(true);
		} catch (Exception e) {
			fail("Exception inesperada");
		}
	}

}
