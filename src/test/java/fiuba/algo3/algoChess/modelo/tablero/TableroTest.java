package fiuba.algo3.algoChess.modelo.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
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
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
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
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 4 );
		assertEquals(soldado.getPosicion().getY(), 5);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAArribaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAArriba(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 5 );
		assertEquals(soldado.getPosicion().getY(), 6);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAAbajoCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajo(jugador,soldado);

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
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleADerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 15);
		assertEquals(soldado.getPosicion().getY(), 14);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadALaIzquierdaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 13 );
		assertEquals(soldado.getPosicion().getY(), 14);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAArribaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));


		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/

		tablero.moverMovibleAArriba(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 14 );
		assertEquals(soldado.getPosicion().getY(), 15);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAAbajoCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajo(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 14 );
		assertEquals(soldado.getPosicion().getY(), 13);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAArribaIzquierdaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAArribaIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 4);
		assertEquals(soldado.getPosicion().getY(), 6);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAAbajoIzquierdaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajoIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 4 );
		assertEquals(soldado.getPosicion().getY(), 4);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAArribaDerechaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAArribaDerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 6 );
		assertEquals(soldado.getPosicion().getY(), 6);
	}

	@Test
	public void tableroJugadorAMueveUnaUnidadAAbajoDerechaCorrectamenteTest(){

		JugadorA jugador = new JugadorA();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(5, 5));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajoDerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 6 );
		assertEquals(soldado.getPosicion().getY(), 4);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAArribaIzquierdaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAArribaIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 13);
		assertEquals(soldado.getPosicion().getY(), 15);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAAbajoIzquierdaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajoIzquierda(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 13 );
		assertEquals(soldado.getPosicion().getY(), 13);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAArribaDerechaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));


		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/

		tablero.moverMovibleAArribaDerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 15 );
		assertEquals(soldado.getPosicion().getY(), 15);
	}

	@Test
	public void tableroJugadorBMueveUnaUnidadAAbajoDerrechaCorrectamenteTest(){

		JugadorB jugador = new JugadorB();
		Tablero tablero = new Tablero();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		tablero.posicionarEn(jugador,soldado, new Posicion(14, 14));

		/*
		            lado del jugadorA                                               lado del jugadorB
		----------------------------------------------------------------------------------------------------
		|                                                                                                  |
		-----------------------------------------            -----------------------------------------------
		|    ArribaIzquierda  Arriba  ArribaDerecha                 ArribaIzquierda  Arriba  ArribaDerecha |
		-------------------------------------------          -----------------------------------------------
		|           Izquierda <--  --> Derrecaha                          Izquierdo <--  -->  Derecho      |
		--------------------------------------------          ----------------------------------------------
		|     AbajoIzquierda  Abajo   AbajoDerrecaha                AbajoIzquierda  Abajo   AbajoDerrecaha |
		--------------------------------------------        ------------------------------------------------
		|                                                                                                  |
		----------------------------------------------------------------------------------------------------
		*/
		tablero.moverMovibleAAbajoDerecha(jugador,soldado);

		assertEquals(soldado.getPosicion().getX(), 15 );
		assertEquals(soldado.getPosicion().getY(), 13);
	}

	@Test
	public void tableroTestDeCatapultaDeJugadorAAtacaAlAtacableYALosAtacablesContiguas1Test(){
		JugadorA jugador = new JugadorA();
		JugadorB jugadorB = new JugadorB();
		Tablero tablero = new Tablero();

		SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
		for (int i = 0; i < 20; i++){
			soldado[i] = jugadorB.elegirSoldado();
		}

		Posicion [] posicion = new Posicion[20];

		posicion[0] = new Posicion(13, 7);posicion[5] = new Posicion( 13, 11);
		posicion[1] = new Posicion( 14, 8);posicion[6] = new Posicion(14, 10);
		posicion[2] = new Posicion(15, 9);posicion[7] = new Posicion(16, 8);
		posicion[3] = new Posicion(16, 10);posicion[8] = new Posicion(17, 7);
		posicion[4] = new Posicion(17,11);

		posicion[9] = new Posicion(13, 9);posicion[13] = new Posicion(15, 7);
		posicion[10] = new Posicion( 14, 9);posicion[14] = new Posicion( 15, 8);
		posicion[11] = new Posicion( 16, 9);posicion[15] = new Posicion(15, 10);
		posicion[12] = new Posicion( 17, 9);posicion[16] = new Posicion( 15, 11);

		posicion[17] = new Posicion(19, 8);
		posicion[18] = new Posicion( 19, 9);
		posicion[19] = new Posicion( 19, 10);

		for (int i = 0; i < 20; i++){
			tablero.posicionarEn(jugadorB, soldado[i], posicion[i]);
		}


		Catapulta catapulta = new Catapulta(jugador);
		tablero.posicionarEn(jugador, catapulta, new Posicion(1,1));


		tablero.atacanteAtacarAtacable(jugador, catapulta, soldado[2]);

		for (int i = 0; i < 17; i++){
			assertEquals(soldado[i].obtenerVida(), 80);
		}

	}

	@Test
	public void tableroTestDeCatapultaDeJugadorBAtacaAlAtacableYALosAtacablesContiguas1Test(){
		JugadorA jugador = new JugadorA();
		JugadorB jugadorB = new JugadorB();
		Tablero tablero = new Tablero();

		SoldadoDeInfanteria [] soldado = new SoldadoDeInfanteria[20];
		for (int i = 0; i < 20; i++){
			soldado[i] = jugador.elegirSoldado();
		}

		Posicion [] posicion = new Posicion[20];

		posicion[0] = new Posicion(2,8);posicion[5] = new Posicion(2,12 );
		posicion[1] = new Posicion( 3, 9);posicion[6] = new Posicion(3,11);
		posicion[2] = new Posicion(4, 10);posicion[7] = new Posicion(5,9);
		posicion[3] = new Posicion(5, 11);posicion[8] = new Posicion(6,8);
		posicion[4] = new Posicion(6, 12);

		posicion[9] = new Posicion(4,8);posicion[13] = new Posicion(2,10);
		posicion[10] = new Posicion(4,9 );posicion[14] = new Posicion( 3,10);
		posicion[11] = new Posicion( 4,11);posicion[15] = new Posicion(5,10);
		posicion[12] = new Posicion( 4,12);posicion[16] = new Posicion( 6,10);

		posicion[17] = new Posicion(8,9);
		posicion[18] = new Posicion( 8,10);
		posicion[19] = new Posicion(8,11 );

		for (int i = 0; i < 20; i++){
			tablero.posicionarEn(jugador, soldado[i], posicion[i]);
		}


		Catapulta catapulta = new Catapulta(jugadorB);
		tablero.posicionarEn(jugadorB, catapulta, new Posicion(20,20));


		tablero.atacanteAtacarAtacable(jugadorB, catapulta, soldado[2]);

		for (int i = 0; i < 17; i++){
			assertEquals(soldado[i].obtenerVida(), 80);
		}

	}
	@Test
	public void unidadRecienCreadaNoposicionadaEnElTableroTieneCoordenadasQueNoPertenecenAlTableroTest(){

		Jugador jugador = new JugadorA();
		SoldadoDeInfanteria soldado = jugador.elegirSoldado();

		assertEquals(soldado.getPosicion().getX(), -1 );
		assertEquals(soldado.getPosicion().getY(), -1);
	}
}
