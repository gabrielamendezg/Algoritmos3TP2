package fiuba.algo3.algoChess.modelo.jugador;


import static org.junit.Assert.assertTrue;

import org.junit.*;

import fiuba.algo3.algoChess.modelo.Excepciones.JugadorSinPuntosSuficientesException;

public class JugadorNoPuedeTomarMasUnidadesQuePuntosQueTieneTest{
	
	Jugador jugador = new Jugador();
	
	@Test
	public void deberiaLanzarExcepcionJugadorSinPuntosSuficientes() {
		
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	try {
	jugador.elegirSoldado();
	}catch (JugadorSinPuntosSuficientesException e){
		
		}
	assertTrue(jugador.cantidadDeUnidades()== 4);
}
}

