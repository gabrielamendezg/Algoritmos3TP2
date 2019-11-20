package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class JugadorSinUnidadesDevuelveVacioTest {

	Jugador jugador= new Jugador("E");
	
	@Test
	public void deberiaDevolverVacio(){
		
	assertTrue((jugador.obtenerUnidades()).isEmpty());
		
		
	}
	
}
