package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

class SoldadoDeInfanteriaNoQuitaVidaSiNoEstaEnRangoTest {
	
	JugadorA jugador = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	Unidad soldado = new SoldadoDeInfanteria(jugador);
	Unidad curandero = new Curandero(jugadorb);
	@Test
	void soldadoNoQuitaVida() {
		curandero.setPosicion(new Posicion(1, 4));
		soldado.setPosicion(new Posicion(1,1));
		
		soldado.atacar(jugador,curandero,0);
		
		assertTrue(curandero.obtenerVida() == 75);
		
	}

}