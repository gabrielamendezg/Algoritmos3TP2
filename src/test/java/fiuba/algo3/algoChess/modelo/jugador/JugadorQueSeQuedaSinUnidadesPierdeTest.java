package fiuba.algo3.algoChess.modelo.jugador;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.sample.*;


public class JugadorQueSeQuedaSinUnidadesPierdeTest {
	
	Jugador jugador = new Jugador();
	Entidad unaEntidad;
	
	@Test(expected = JugadorSinUnidadesPierdeException.class)
	public void deberiaLanzarExcepcionJugadorSinUnidadesPierde() throws JugadorSinUnidadesPierdeException {
		
		unaEntidad = jugador.elegirSoldado();
		jugador.eliminarUnidad(unaEntidad);

		
	}
	
	
	
	
	

}
