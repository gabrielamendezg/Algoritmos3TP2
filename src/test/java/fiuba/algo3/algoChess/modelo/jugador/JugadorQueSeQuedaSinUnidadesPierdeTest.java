package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.Assert.assertFalse;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;


public class JugadorQueSeQuedaSinUnidadesPierdeTest {
	
	JugadorA jugador = new JugadorA();
	Unidad unaUnidad;
	
	@Test
	public void deberiaLanzarExcepcionJugadorSinUnidadesPierde(){
		
		unaUnidad = jugador.elegirSoldado();
		assertFalse (jugador.sigueEnJuego());

		
	}
	
	
	
	
	

}
