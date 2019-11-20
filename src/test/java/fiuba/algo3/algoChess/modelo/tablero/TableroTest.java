package fiuba.algo3.algoChess.modelo.tablero;
import static org.junit.Assert.*;

import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.jugador.Jugador1;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

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
}
