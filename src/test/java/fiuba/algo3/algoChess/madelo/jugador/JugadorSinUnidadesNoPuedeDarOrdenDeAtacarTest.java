package fiuba.algo3.algoChess.madelo.jugador;

import fiuba.algo3.algoChess.modelo.jugador.*;

import static org.junit.Assert.assertFalse;

import org.junit.*;

public class JugadorSinUnidadesNoPuedeDarOrdenDeAtacarTest {
	
	Jugador jugador = new Jugador();

	@Test
	public void deberiaDevolverFalseYaQueJugadorNoTieneUnidades() {
		
		assertFalse (jugador.ordenarAtaque());
	}
	
	
}
