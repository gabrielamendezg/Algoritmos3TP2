package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.Tablero.Tablero;

class TableroNoSePuedeCrearMasDeUnTableroTest {

	@SuppressWarnings("unused")
	@Test
	public void NoEsPosibleCrearMasDeUnaInstanciaDeTableroTest() {
		try{
			Tablero tableroA = Tablero.ObtenerInstancia();
			Tablero tableroB = Tablero.ObtenerInstancia();
		}catch(InstanciaDeTableroYaExiste ex) {
			assert(true);
		}
	}
}