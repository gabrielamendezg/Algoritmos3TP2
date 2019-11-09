package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class SoldadoDeInfanteriaRestaVidaCorrespondienteTest {
	
	Jugador jugador = new Jugador();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
	Curandero curandero = new Curandero(jugador);
	@Test
	void test() {
		curandero.setPosicion(1, 2);
		soldado.setPosicion(1,1);
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 65);
		
	}

}
