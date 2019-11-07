package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class SoldadoDeInfanteriaRestaVidaCorrespondienteTest {
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
	Curandero curandero = new Curandero();
	@Test
	void test() {
		curandero.setPosicion(1, 2);
		soldado.setPosicion(1,1);
		
		soldado.atacar(curandero);
		
		assertTrue(curandero.obtenerVida() == 65);
		
	}

}
