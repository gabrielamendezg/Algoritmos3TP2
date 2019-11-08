package fiuba.algo3.algoChess.modelo.jugador;
import static org.junit.Assert.assertTrue;
import fiuba.algo3.algoChess.modelo.entidades.*;

import  org.junit.*;

import fiuba.algo3.algoChess.sample.JugadorSinUnidadesPierdeException;


public class JugadorPuedeRemoverUnidadEspecificaTest {
	
	Jugador jugador = new Jugador();
	Unidad unaUnidad;
	
	@Test
	public void deberiaDevolverCantidadDeUnidadesNula(){
		
		unaUnidad = jugador.elegirCatapulta();
		assertTrue(jugador.cantidadDeUnidades() == 1);
		jugador.eliminarUnidad(unaUnidad);
		assertTrue(jugador.cantidadDeUnidades() == 0);
		
		
	}
	
}
