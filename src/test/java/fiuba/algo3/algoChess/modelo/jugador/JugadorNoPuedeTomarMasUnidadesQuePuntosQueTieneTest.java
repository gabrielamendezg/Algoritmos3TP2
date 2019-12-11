package fiuba.algo3.algoChess.modelo.jugador;


import fiuba.algo3.algoChess.modelo.Excepciones.PuntosInsuficientesExcepcion;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorNoPuedeTomarMasUnidadesQuePuntosQueTieneTest{
	
	JugadorA jugador = new JugadorA();
	Tablero tablero = new Tablero();
	@Test
	public void deberiaNoAgregarMasUnidadesLanzaPuntosDeVidaInsuficienteExcepcionTest() {
		tablero.posicionarEn(jugador, jugador.elegirCatapulta(), new Posicion(1, 4));
		tablero.posicionarEn(jugador, jugador.elegirCatapulta(), new Posicion(1, 5));
		tablero.posicionarEn(jugador, jugador.elegirCatapulta(), new Posicion(1, 6));
		tablero.posicionarEn(jugador, jugador.elegirCatapulta(), new Posicion(2, 5));
		assertThrows(PuntosInsuficientesExcepcion.class,
				() -> {
					tablero.posicionarEn(jugador, jugador.elegirCatapulta(), new Posicion(4,4));;

				});
		
	}
	
}

