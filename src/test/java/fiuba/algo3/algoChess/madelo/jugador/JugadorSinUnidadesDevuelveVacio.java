package fiuba.algo3.algoChess.madelo.jugador;

import static org.junit.Assert.assertEquals;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import org.junit.Test;


public class JugadorSinUnidadesDevuelveVacio {

	Jugador jugador= new Jugador();
	
	@Test
	public void deberiaDevolverNull(){
		
	assertEquals(null, jugador.obtenerUnidades());
		
		
	}
	
}
