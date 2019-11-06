package fiuba.algo3.algoChess.sample;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.tablero.Tablero;

class TableroNoSePuedeClonarTest {
	@SuppressWarnings("unused")
	@Test
	public void NoEsPosibleClonarInstanciaDeClaseTableroTest() {
		//Arrange and Act
		try{
			try{
			Tablero tableroA = Tablero.obtenerInstancia();
			Tablero tableroB = tableroA.clone();
		}catch(CloneNotSupportedException e) {
			//Assert
			assert(true);
		}
		}catch(InstanciaDeTableroYaExiste ex) {	}

	}

}
