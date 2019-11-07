package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class SoldadoDeInfanteriaNoQuitaVidaSiNoEstaEnRangoTest {
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
	Curandero curandero = new Curandero();
	@Test
	void soldadoNoQuitaVida() {
		curandero.setPosicion(1, 4);
		soldado.setPosicion(1,1);
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 75);
		
	}

}