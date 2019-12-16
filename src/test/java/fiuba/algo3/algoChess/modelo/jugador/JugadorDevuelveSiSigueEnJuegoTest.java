package fiuba.algo3.algoChess.modelo.jugador;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;

import static org.junit.Assert.*;

public class JugadorDevuelveSiSigueEnJuegoTest {
	
	@Test
	public void deberiaDevolverTrueConUnidadesYFalsoSiSeQuedoSinUnidades() {
		JugadorA jugador = new JugadorA();
		JugadorB jugadorB = new JugadorB();
		Tablero tablero = new Tablero();
		Catapulta unidad = jugadorB.elegirCatapulta();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();
		tablero.posicionarEn(jugador, soldado, new Posicion(1, 1));
		tablero.posicionarEn(jugadorB, unidad, new Posicion(11, 1));
		assertTrue (jugador.sigueEnJuego());
		tablero.atacanteAtacarAtacable(jugadorB, unidad, soldado);
		tablero.atacanteAtacarAtacable(jugadorB, unidad, soldado);
		tablero.atacanteAtacarAtacable(jugadorB, unidad, soldado);
		tablero.atacanteAtacarAtacable(jugadorB, unidad, soldado);
		tablero.atacanteAtacarAtacable(jugadorB, unidad, soldado);
		assertEquals(soldado.obtenerVida(), 0,0);
		assertFalse(jugador.sigueEnJuego());
		
	}
	
}
