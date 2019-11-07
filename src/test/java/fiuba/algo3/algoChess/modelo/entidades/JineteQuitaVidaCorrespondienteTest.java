package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class JineteQuitaVidaCorrespondienteTest {
	
	Jugador jugador = new Jugador();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
	Curandero curandero = new Curandero(jugador);
	Jinete jinete = new Jinete(jugador);
	@Test
	void test() {
		curandero.setPosicion(1, 2);
		soldado.setPosicion(1,4);
		jinete.setPosicion(1, 1);
		
		jinete.atacar(curandero);
		jinete.atacar(soldado);
		
		assertTrue(curandero.obtenerVida() == 70);
		assertTrue(soldado.obtenerVida() ==100);
		
	}

}