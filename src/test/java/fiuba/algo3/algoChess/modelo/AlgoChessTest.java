package fiuba.algo3.algoChess.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class AlgoChessTest {
	
	AlgoChess algochess = new AlgoChess();
	
	@Test
	public void deberiaDevolverTrue() {
		
		assertTrue (algochess.jugar());
	}
}
