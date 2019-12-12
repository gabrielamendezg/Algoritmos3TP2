package fiuba.algo3.algoChess.modelo.entidades.catapulta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;
import java.util.LinkedList;

class CatapultaQuitaVidaCorrespondienteTest {
	
	JugadorA jugadora = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	Catapulta catapulta = new Catapulta(jugadora);
	Jinete jinete = new Jinete(jugadorb);
	
	@Test
	void test() {
		catapulta.setPosicion(new Posicion(1, 17));
		jinete.setPosicion(new Posicion(1, 1));
		ArrayList<Atacable> atacables = new ArrayList<Atacable>();
		atacables.add(jinete);
		catapulta.atacarAtacable(jugadora, jinete, atacables);
		
		assertEquals(jinete.obtenerVida() , 80);
	}

}
