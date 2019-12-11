package fiuba.algo3.algoChess.modelo.jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.*;

public class JugadorAgregaUnidadesAlTableroYDevuelveCorrectamenteCantidadTest {
	
	@Test
	public void JugadorAdeberiaDevolverCantidadesCorrectasDeUnidades() {
		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();

		SoldadoDeInfanteria soldadoDeInfanteria = jugador.elegirSoldado();
		assertEquals(jugador.cantidadDeUnidades(), 0);
		tablero.posicionarEn(jugador, soldadoDeInfanteria, new Posicion(1, 1));
		assertEquals(jugador.cantidadDeUnidades(), 1);
		Catapulta catapulta = jugador.elegirCatapulta();
		tablero.posicionarEn(jugador, catapulta, new Posicion(2, 1));
		assertEquals(jugador.cantidadDeUnidades(), 2);
	}

	@Test
	public void JugadorBdeberiaDevolverCantidadesCorrectasDeUnidades() {
		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();

		SoldadoDeInfanteria soldadoDeInfanteria = jugador.elegirSoldado();
		assertEquals(jugador.cantidadDeUnidades(), 0);
		tablero.posicionarEn(jugador, soldadoDeInfanteria, new Posicion(11, 1));
		assertEquals(jugador.cantidadDeUnidades(), 1);
		Catapulta catapulta = jugador.elegirCatapulta();
		tablero.posicionarEn(jugador, catapulta, new Posicion(12, 1));
		assertEquals(jugador.cantidadDeUnidades(), 2);
	}
	
	
	
}
