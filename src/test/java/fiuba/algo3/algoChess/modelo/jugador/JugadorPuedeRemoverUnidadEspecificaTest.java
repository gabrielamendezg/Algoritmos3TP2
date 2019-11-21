package fiuba.algo3.algoChess.modelo.jugador;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.Excepciones.JugadorSinUnidadesPierdeException;
import fiuba.algo3.algoChess.modelo.entidades.*;

import  org.junit.*;


public class JugadorPuedeRemoverUnidadEspecificaTest {
	
	Jugador jugador = new Jugador("e");
	Unidad unaUnidad;
	
	@Test
	public void deberiaDevolverCantidadDeUnidadesNula(){
		
		unaUnidad = jugador.elegirCatapulta();
		assertTrue(jugador.cantidadDeUnidades() == 1);
		jugador.eliminarUnidad(unaUnidad);
		assertTrue(jugador.cantidadDeUnidades() == 0);
		
		
	}
	
}
