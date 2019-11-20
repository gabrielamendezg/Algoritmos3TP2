package fiuba.algo3.algoChess.modelo.entidades.jinete;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class JineteQuitaVidaCorrespondienteTest {
	String jugador = "e";
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
	Curandero curandero = new Curandero(jugador);
	Jinete jinete = new Jinete(jugador);
	@Test
	void test() {
		curandero.setPosicion(new Posicion(1, 2));
		soldado.setPosicion(new Posicion(1,4));
		jinete.setPosicion(new Posicion(1, 1));
		
		jinete.atacar(curandero);
		jinete.atacar(soldado);
		
		assertTrue(curandero.obtenerVida() == 70);
		assertTrue(soldado.obtenerVida() ==100);
		
	}

}