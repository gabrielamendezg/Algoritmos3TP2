package fiuba.algo3.algoChess.madelo.jugador;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import org.junit.Test;


public class JugadorSinUnidadesDevuelveVacioTest {

	Jugador jugador= new Jugador();
	
	@Test
	public void deberiaDevolverVacio(){
		
	assertTrue((jugador.obtenerUnidades()).isEmpty());
		
		
	}
	
}
