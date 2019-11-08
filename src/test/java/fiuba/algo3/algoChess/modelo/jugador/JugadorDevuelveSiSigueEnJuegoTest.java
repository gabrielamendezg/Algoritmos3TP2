package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;

public class JugadorDevuelveSiSigueEnJuegoTest {
	
	Jugador jugador = new Jugador();
	Unidad unidad;
	
	@Test
	public void deberiaDevolverTrueConUnidadesYFalsoSiSeQuedoSinUnidades() {
		
		unidad = jugador.elegirCatapulta();
		assertTrue (jugador.sigueEnJuego());
		jugador.eliminarUnidad(unidad);
		assertFalse(jugador.sigueEnJuego());
		
	}
	
}
