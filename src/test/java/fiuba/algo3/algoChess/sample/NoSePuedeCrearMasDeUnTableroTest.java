package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.tablero.Tablero;

class TableroNoSePuedeCrearMasDeUnTableroTest {

	@SuppressWarnings("unused")
	@Test
	public void NoEsPosibleCrearMasDeUnaInstanciaDeTableroTest() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		try{
			Tablero tableroA = Tablero.obtenerInstancia(jugador1,jugador2);
			Tablero tableroB = Tablero.obtenerInstancia(jugador1,jugador2);
		}catch(InstanciaDeTableroYaExiste ex) {
			assert(true);
		}
	}
}