package fiuba.algo3.algoChess.modelo.jugador;

import fiuba.algo3.algoChess.modelo.jugador.SelectorDeUnidades;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import fiuba.algo3.algoChess.modelo.entidades.*;

public class SelectorPermiteElegirUnidadesTest {

	SelectorDeUnidades selector;
	Jugador jugador;
	Unidad soldado;
	Unidad catapulta;
	Unidad jinete;
	Unidad curandero;
	
	@Test
	public void deberiaDevolverTrue() {
		
		jugador = new Jugador();
		selector = new SelectorDeUnidades();
		soldado = selector.elegirSoldado(jugador);
		catapulta = selector.elegirCatapulta(jugador);
		jinete = selector.elegirJinete(jugador);
		curandero = selector.elegirCurandero(jugador);
		
		assertTrue(soldado instanceof SoldadoDeInfanteria);
		assertTrue(catapulta instanceof Catapulta);
		assertTrue(jinete instanceof Jinete);
		assertTrue(curandero instanceof Curandero);
		
	}
	
	
}
