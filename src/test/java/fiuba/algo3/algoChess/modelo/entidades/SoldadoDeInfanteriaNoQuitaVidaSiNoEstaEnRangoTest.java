package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class SoldadoDeInfanteriaNoQuitaVidaSiNoEstaEnRangoTest {
	Jugador jugador = new Jugador();
	Unidad soldado = new SoldadoDeInfanteria(jugador);
	Unidad curandero = new Curandero(jugador);
	@Test
	void soldadoNoQuitaVida() {
		curandero.setPosicion(1, 4);
		soldado.setPosicion(1,1);
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 75);
		
	}

}