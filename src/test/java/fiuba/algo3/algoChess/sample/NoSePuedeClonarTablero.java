package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.tablero.Tablero;

class TableroNoSePuedeClonarTest {
	@SuppressWarnings("unused")
	@Test
	public void NoEsPosibleClonarInstanciaDeClaseTableroTest() {
		//Arrange
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		try{
			try{
			Tablero tableroA = Tablero.obtenerInstancia(jugador1,jugador2);
			//Act
			Tablero tableroB = tableroA.clone();
		}catch(CloneNotSupportedException e) {
			//Assert
			assert(true);
		}
		}catch(InstanciaDeTableroYaExiste ex) {	}

	}

}
