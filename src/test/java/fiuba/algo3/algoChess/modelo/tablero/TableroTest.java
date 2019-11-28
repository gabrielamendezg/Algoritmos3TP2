package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
//import fiuba.algo3.algoChess.modelo.entidades.posicionables.PosicionablesADistaciaCercana;
import fiuba.algo3.algoChess.modelo.jugador.*;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

	@Test
	public void correctaCreacionDelTablero() {
	    assertNotNull(new Tablero());
    }

	@Test
	public void tableroJugadorAMueveUnaUnidadALaDerechaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleADerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 6);
		assertEquals(soldado.getPosicion().getY(), 5);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadALaIzquierdaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 4 );
		assertEquals(soldado.getPosicion().getY(), 5);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadALaAdelanteCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAdelante(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 5 );
		assertEquals(soldado.getPosicion().getY(), 6);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadALaAtrasCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAtras(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 5 );
		assertEquals(soldado.getPosicion().getY(), 4);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadALaDerechaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleADerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 13);
		assertEquals(soldado.getPosicion().getY(), 14);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadALaIzquierdaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 15 );
		assertEquals(soldado.getPosicion().getY(), 14);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadALaAdelanteCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAdelante(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 14 );
		assertEquals(soldado.getPosicion().getY(), 13);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadALaAtrasCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		lado del jugadorA                                       lado del jugadorB
		--------------------------------------------------------------------------
		|                                                                        |
		----------------                                     --------------------
		|         Izquierdo                                     Derecho          |
		----------------                                     --------------------
		|  Atras <--  --> Adelante                   Adelante <--  --> Atras     |
		-----------------                                     -------------------
		|          Derecho                                      Izquierdo        |
		---------------                                     ---------------------
		|                                                                        |
		--------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAtras(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 14 );
		assertEquals(soldado.getPosicion().getY(), 15);
	}

	@Test
	public void unidadRecienCreadaNoposicionadaEnElTableroTieneCoordenadasQueNoPertenecenAlTableroTest(){

		Jugador jugador = new JugadorA();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		assertEquals(soldado.getPosicion().getX(), -1 );
		assertEquals(soldado.getPosicion().getY(), -1);
	}


}
