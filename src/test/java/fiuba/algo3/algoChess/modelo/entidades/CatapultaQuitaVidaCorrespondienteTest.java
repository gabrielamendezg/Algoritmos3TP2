package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class CatapultaQuitaVidaCorrespondienteTest {
	Jugador jugador = new Jugador();
	Catapulta catapulta = new Catapulta(jugador);
	Jinete jinete = new Jinete(jugador);
	
	@Test
	void test() {
		catapulta.setPosicion(1, 7);
		jinete.setPosicion(1, 1);
		
		catapulta.atacar(jinete);
		
		assertTrue(jinete.obtenerVida() == 80);
	}

}
