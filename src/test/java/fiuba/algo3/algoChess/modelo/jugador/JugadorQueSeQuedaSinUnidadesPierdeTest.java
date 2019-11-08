package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.Assert.assertFalse;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.sample.*;


public class JugadorQueSeQuedaSinUnidadesPierdeTest {
	
	Jugador jugador = new Jugador();
	Unidad unaUnidad;
	
	@Test
	public void deberiaLanzarExcepcionJugadorSinUnidadesPierde(){
		
		unaUnidad = jugador.elegirSoldado();
		jugador.eliminarUnidad(unaUnidad);
		assertFalse (jugador.sigueEnJuego());

		
	}
	
	
	
	
	

}
