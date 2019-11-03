package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class JugadorSinUnidadesDevuelveNull {

	Jugador jugador= new Jugador();
	
	@Test
	public void deberiaDevolverNull(){
		
	assertEquals(null, jugador.obtenerUnidades());
		
		
	}
	
}
