package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class SoldadoDeInfanteriaRestaVidaCorrespondienteTest {

	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria("");
	Curandero curandero = new Curandero("");
	@Test
	void test() {
		curandero.setPosicion(new Posicion(1, 2));
		soldado.setPosicion(new Posicion(1,1));
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 65);
		
	}

}
