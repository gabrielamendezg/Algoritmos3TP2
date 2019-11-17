package fiuba.algo3.algoChess.modelo;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.*;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class AlgoChessJugadorPuedeElegirUnidadesTest {

	AlgoChess algochess;
	Jugador jugador;
	
	@Test //Elige soldado
	public void test() throws IOException{
		
		algochess= algochess.getInstance();
		jugador = new Jugador();
		
		assertTrue(algochess.elegirUnidades(jugador));
	
		
	}
}
