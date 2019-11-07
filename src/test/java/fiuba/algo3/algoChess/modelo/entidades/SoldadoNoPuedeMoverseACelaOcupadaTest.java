package fiuba.algo3.algoChess.modelo.entidades;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SoldadoNoPuedeMoverseACelaOcupadaTest {

		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		Curandero curandero = new Curandero();
		@Test
		void posicionNoModificada() {
			curandero.setPosicion(1, 2);
			soldado.setPosicion(1,1);
			
			soldado.moverUnidadA(1, 2);

			
			assertTrue(soldado.obtenerPosicionX() == 1);
			assertTrue(soldado.obtenerPosicionY() == 2);
			
		}


}
