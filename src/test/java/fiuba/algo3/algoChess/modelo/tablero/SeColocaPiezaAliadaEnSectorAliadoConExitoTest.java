package fiuba.algo3.algoChess.modelo.tablero;

import static org.junit.Assert.*;

import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.JugadorInvalido;
import fiuba.algo3.algoChess.tablero.PosicionInvalidaException;
import fiuba.algo3.algoChess.tablero.Tablero;

public class SeColocaPiezaAliadaEnSectorAliadoConExitoTest {

	@Test
	public void test() {
		//Arrange
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Unidad unidad1 = jugador1.elegirSoldado();
		boolean movimientoexitoso = false;
		
		try {
			Tablero tablero = Tablero.obtenerInstancia(jugador1,jugador2);
			movimientoexitoso = tablero.colocarUnidad(jugador1, unidad1,1,1);
		
		} catch (InstanciaDeTableroYaExiste e) {
			fail("No se pudo crear tablero porque ya existe uno.");
		} catch (JugadorInvalido e) {
			fail("JugadorInvalido exception");
		} catch (PosicionInvalidaException e) {
			fail("PosicionInvalida exception");
		} catch (Exception e) {
			fail(e.toString());
		}
		assert(movimientoexitoso);
	}

}
