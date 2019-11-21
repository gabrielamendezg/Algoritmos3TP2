package fiuba.algo3.algoChess.modelo.jugador;


import fiuba.algo3.algoChess.modelo.Excepciones.PuntosInsuficientesExcepcion;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorNoPuedeTomarMasUnidadesQuePuntosQueTieneTest{
	
	JugadorA jugador = new JugadorA();
	
	@Test
	public void deberiaNoAgregarMasUnidadesLanzaPuntosDeVidaInsuficienteExcepcionTest() {
		
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
	jugador.elegirCatapulta();
		assertThrows(PuntosInsuficientesExcepcion.class,
				() -> {
					jugador.elegirSoldado();

				});
		
	}
	
}

