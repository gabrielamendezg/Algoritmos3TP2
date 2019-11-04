package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroCorrectaCreacionEInicializacionTest {

	@Test
	public void test() {
		//Act
		Tablero tablero = new Tablero();
		
		//Assert
		assertNotNull(tablero);
	}

}
