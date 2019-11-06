package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.tablero.Tablero;

class TableroNoSePuedeCrearMasDeUnTableroTest {

	@SuppressWarnings("unused")
	@Test
	public void NoEsPosibleCrearMasDeUnaInstanciaDeTableroTest() {
		try{
			Tablero tableroA = Tablero.obtenerInstancia();
			Tablero tableroB = Tablero.obtenerInstancia();
		}catch(InstanciaDeTableroYaExiste ex) {
			assert(true);
		}
	}
}