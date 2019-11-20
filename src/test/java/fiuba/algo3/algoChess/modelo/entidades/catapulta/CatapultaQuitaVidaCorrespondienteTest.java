package fiuba.algo3.algoChess.modelo.entidades.catapulta;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class CatapultaQuitaVidaCorrespondienteTest {
	String jugador = "e";
	Catapulta catapulta = new Catapulta(jugador);
	Jinete jinete = new Jinete(jugador);
	
	@Test
	void test() {
		catapulta.setPosicion(new Posicion(1, 7));
		jinete.setPosicion(new Posicion(1, 1));
		
		catapulta.atacar(jinete);
		
		assertTrue(jinete.obtenerVida() == 80);
	}

}
