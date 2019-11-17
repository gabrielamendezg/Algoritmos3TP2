package fiuba.algo3.algoChess.modelo;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.*;

public class AlgoChessTest {
	
	AlgoChess algochess;
	
	@Test
	public void deberiaDevolverTrue() throws IOException{
		
		algochess= algochess.getInstance();
		
		
		
		assertTrue (algochess.jugar());
	}
}
