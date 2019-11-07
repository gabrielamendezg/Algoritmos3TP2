package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.tablero.*;
import fiuba.algo3.algoChess.modelo.jugador.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SoldadoNoPuedeMoverseACeldaOcupadaTest {
	

		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		Curandero curandero = new Curandero();
		Jugador jugador = new Jugador();
		
		Celda celda1 = new Celda(jugador);
		
		Celda celda2 = new Celda (jugador);
		@Test
		void test() {
			
			celda1.setUnidad(soldado); //agrega entidad y setea posicion
			soldado.setPosicion(1,1);
			
			celda2.setUnidad(curandero); // agregaentidad y setea posicion
			
			if(celda1.moverUnidad(celda2)) {
				soldado.moverUnidadA(1,	2, jugador);
			}
			
			assertTrue(soldado.obtenerPosicionX() ==1 );
			assertTrue(soldado.obtenerPosicionY() ==1);
			
		}
}
