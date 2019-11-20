package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.posicionables.PosicionableADistaciaCercana;
import fiuba.algo3.algoChess.modelo.jugador.Jugador1;
import fiuba.algo3.algoChess.modelo.jugador.Jugador2;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

	@Test
	public void correctaCreacionDelTablero() {
	    assertNotNull(new Tablero());
    }

	@Test
	public void tableroMueveUnaUnidadCorrectamente(){

		Jugador jugador = new Jugador1("elvis");
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(1, 1));
		tablero.moverMovibleA(jugador,soldado, new Posicion(1, 2));

		assertEquals(soldado.getPosicion().getX(), 1 );
		assertEquals(soldado.getPosicion().getY(), 2);
	}

	@Test
	public void unidadRecienCreadaNoposicionadaEnElTableroTieneCoordenadasQueNoPertenecenAlTableroTest(){

		Jugador jugador = new Jugador1("elvis");
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		assertEquals(soldado.getPosicion().getX(), -1 );
		assertEquals(soldado.getPosicion().getY(), -1);
	}

	@Test
	public void tableroRetornaCorectamenteLosPosicionablesADistanciaCercanaDeUnPosicionable1Test(){

		Jugador juagador1 = new Jugador1("elvis");
		Jugador juagador2 = new Jugador2("pepe");

		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria(juagador1.nombre());

		tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
		tablero.posicionarEn(juagador1, soldado2, new Posicion(2, 1));
		tablero.posicionarEn(juagador1, soldado3, new Posicion(3, 1));
		tablero.posicionarEn(juagador1, soldado4, new Posicion(4, 1));
		/*
		los posicionables a distancia cercana de soldado1 son soldado2 y soldado3
		 */
		PosicionableADistaciaCercana posicionablesCercanos = new PosicionableADistaciaCercana();
		posicionablesCercanos.add(soldado2);
		posicionablesCercanos.add(soldado3);
		assertEquals(tablero.posicionablesADistanciaCercanaDe(soldado1), posicionablesCercanos);
	}

	@Test
	public void tableroRetornaCorectamenteLosPosicionablesADistanciaCercanaDeUnPosicionable2Test(){

		Jugador juagador1 = new Jugador1("elvis");
		Jugador juagador2 = new Jugador2("pepe");

		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(juagador1.nombre());
		SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria(juagador1.nombre());

		tablero.posicionarEn(juagador1, soldado1, new Posicion(1, 1));
		tablero.posicionarEn(juagador1, soldado2, new Posicion(2, 1));
		tablero.posicionarEn(juagador1, soldado4, new Posicion(4, 1));

		tablero.posicionarEn(juagador1, soldado3, new Posicion(3, 1));

		/*
		los posicionables a distancia cercana de soldado3 son soldado1,2,4
		 */
		PosicionableADistaciaCercana posicionablesCercanos = new PosicionableADistaciaCercana();
		posicionablesCercanos.add(soldado2);
		posicionablesCercanos.add(soldado4);
		posicionablesCercanos.add(soldado1);
		assertTrue(posicionablesCercanos.contains(soldado1));
		assertTrue(posicionablesCercanos.contains(soldado2));
		assertTrue(posicionablesCercanos.contains(soldado4));
	}
}