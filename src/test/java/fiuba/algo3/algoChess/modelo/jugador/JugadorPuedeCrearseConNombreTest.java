package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class JugadorPuedeCrearseConNombreTest {

	Jugador jugador;
	
	@Test
	public void deberiaCoincidirElNombreDeJugador() {
		
		jugador= new Jugador("Esteban");
		
		assertEquals("Esteban", jugador.obtenerNombre());
		
		
	}
	
}
