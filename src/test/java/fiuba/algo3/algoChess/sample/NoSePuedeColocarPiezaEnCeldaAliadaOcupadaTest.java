package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.tablero.*;

public class NoSePuedeColocarPiezaEnCeldaAliadaOcupadaTest {

	@SuppressWarnings("unused")
	@Test
	public void TableroNoPuedeColocarPiezaEnCeldaAliadaOcupadaTest() {
		//Arrange
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Unidad unidad1 = jugador1.elegirSoldado();
		Unidad unidad2 = jugador1.elegirSoldado();
		boolean movimientoexitoso = true;
		
		try {
			Tablero tablero = Tablero.obtenerInstancia(jugador1,jugador2);
			if(!tablero.colocarUnidad(jugador1, unidad1,1,1)){
				//Act
				movimientoexitoso = tablero.colocarUnidad(jugador1, unidad2, 1, 1);
			}
		} catch (InstanciaDeTableroYaExiste e) {
			fail("No se pudo crear tablero porque ya existe uno.");
		} catch (PosicionInvalidaException e) {
			fail("PosicionInvalida exception");
		} catch (JugadorInvalido e) {
			fail("JugadorInvalido exception");
		} catch (Exception e) {
			fail("Exception inesperada");
		}
		
		//Assert
		assert(!movimientoexitoso);
	
	}
	

}
