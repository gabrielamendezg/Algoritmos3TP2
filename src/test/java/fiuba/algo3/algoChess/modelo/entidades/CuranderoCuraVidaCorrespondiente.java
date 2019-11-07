package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuranderoCuraVidaCorrespondienteTest {
	
	Curandero curandero = new Curandero();
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria ();
	Jinete jinete = new Jinete();
	

	@Test
	void test() {
		
		soldado.setPosicion(1,1);
		jinete.setPosicion(1, 2);
		
		curandero.setPosicion(1, 5);
		
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		
		curandero.atacar(jinete);
		assertTrue(jinete.obtenerVida() == 95);
	}

}
