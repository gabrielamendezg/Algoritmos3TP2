package fiuba.algo3.algoChess.madelo.jugador;
import static org.junit.Assert.assertTrue;
import fiuba.algo3.algoChess.modelo.entidades.*;

import  org.junit.*;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;


public class JugadorPuedeRemoverUnidadEspecificaTest {
	
	Jugador jugador = new Jugador();
	Entidad unaUnidad;
	
	@Test
	public void deberiaDevolverCantidadDeUnidadesNula(){
		
		unaUnidad = jugador.elegirCatapulta();
		assertTrue(jugador.cantidadDeUnidades() == 1);
		jugador.eliminarUnidad(unaUnidad);
		assertTrue(jugador.cantidadDeUnidades() == 0);
		
		
	}
	
}
