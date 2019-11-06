package fiuba.algo3.algoChess.madelo.jugador;


import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import org.junit.*;

public class JugadorNoPuedeTomarMasUnidadesQuePuntosQueTieneTest{
	
	Jugador jugador = new Jugador();
	
	@Test
	public void deberiaNoAgregarMasUnidadesEImprimirQueNoTienePuntos() {
		
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirSoldado();
	
	assertTrue(jugador.cantidadDeUnidades()==4);
	
		
		
	}
	
}

