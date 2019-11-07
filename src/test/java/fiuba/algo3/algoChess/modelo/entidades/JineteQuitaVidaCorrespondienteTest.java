package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class JineteQuitaVidaCorrespondienteTest {
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
	Curandero curandero = new Curandero();
	Jinete jinete = new Jinete();
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