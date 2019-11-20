package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class SoldadoDeInfanteriaNoQuitaVidaSiNoEstaEnRangoTest {

	Unidad soldado = new SoldadoDeInfanteria("elvis");
	Unidad curandero = new Curandero("elvis");
	@Test
	void soldadoNoQuitaVida() {
		curandero.setPosicion(new Posicion(1, 4));
		soldado.setPosicion(new Posicion(1,1));
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 75);
		
	}

}