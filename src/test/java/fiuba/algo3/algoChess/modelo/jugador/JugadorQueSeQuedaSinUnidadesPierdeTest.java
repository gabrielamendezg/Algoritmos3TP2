package fiuba.algo3.algoChess.modelo.jugador;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.sample.*;


public class JugadorQueSeQuedaSinUnidadesPierdeTest {
	
	Jugador jugador = new Jugador();
	Unidad unaUnidad;
	
	@Test(expected = JugadorSinUnidadesPierdeException.class)
	public void deberiaLanzarExcepcionJugadorSinUnidadesPierde() throws JugadorSinUnidadesPierdeException {
		
		unaUnidad = jugador.elegirSoldado();
		jugador.eliminarUnidad(unaUnidad);

		
	}
	
	
	
	
	

}
