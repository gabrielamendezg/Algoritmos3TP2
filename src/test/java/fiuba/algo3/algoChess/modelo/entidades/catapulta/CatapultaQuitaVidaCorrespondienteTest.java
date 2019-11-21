package fiuba.algo3.algoChess.modelo.entidades.catapulta;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

class CatapultaQuitaVidaCorrespondienteTest {
	
	JugadorA jugadora = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	Catapulta catapulta = new Catapulta(jugadora);
	Jinete jinete = new Jinete(jugadorb);
	
	@Test
	void test() {
		catapulta.setPosicion(new Posicion(1, 7));
		jinete.setPosicion(new Posicion(1, 1));
		
		catapulta.atacar(jugadora,jinete,0);
		
		assertTrue(jinete.obtenerVida() == 80);
	}

}
