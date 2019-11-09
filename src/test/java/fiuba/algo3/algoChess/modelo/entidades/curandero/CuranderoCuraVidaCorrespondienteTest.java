package fiuba.algo3.algoChess.modelo.entidades.curandero;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class CuranderoCuraVidaCorrespondienteTest {
	
	Jugador jugador = new Jugador();
	Curandero curandero = new Curandero(jugador);
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria (jugador);
	Jinete jinete = new Jinete(jugador);
	

	@Test
	void test() {
		
		soldado.setPosicion(1,1);
		jinete.setPosicion(1, 2);
		
		curandero.setPosicion(1, 5);
		
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		
		curandero.atacar(jinete);
		assertTrue(jinete.obtenerVida() == 95);
	}

}
