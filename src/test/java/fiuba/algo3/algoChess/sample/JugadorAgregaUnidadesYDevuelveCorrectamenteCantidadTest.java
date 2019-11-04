package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class JugadorAgregaUnidadesYDevuelveCorrectamenteCantidadTest {

	Jugador jugador= new Jugador();
	
	@Test
	public void deberiaDevolverCantidadesCorrectasDeUnidades() {
		
		assertTrue(jugador.cantidadDeUnidades() == 0);
		jugador.elegirSoldado();
		assertTrue(jugador.cantidadDeUnidades() == 1);
		jugador.elegirCatapulta();
		assertTrue(jugador.cantidadDeUnidades() == 2);
		
		
		
		
		
	}
	
	
	
}
