package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatapultaQuitaVidaCorrespondienteTest {
	
	Catapulta catapulta = new Catapulta();
	Jinete jinete = new Jinete();
	
	@Test
	void test() {
		catapulta.setPosicion(1, 7);
		jinete.setPosicion(1, 1);
		
		catapulta.atacar(jinete);
		
		assertTrue(jinete.obtenerVida() == 80);
	}

}
