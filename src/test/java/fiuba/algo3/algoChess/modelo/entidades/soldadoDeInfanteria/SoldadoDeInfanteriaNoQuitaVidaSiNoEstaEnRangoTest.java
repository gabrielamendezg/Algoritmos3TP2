package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
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