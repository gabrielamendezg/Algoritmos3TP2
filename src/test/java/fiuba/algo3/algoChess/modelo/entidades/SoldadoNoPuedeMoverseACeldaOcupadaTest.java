package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.jugador.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SoldadoNoPuedeMoverseACeldaOcupadaTest {
	
		Jugador jugador = new Jugador();
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
		Curandero curandero = new Curandero(jugador);
		
		Celda celda1 = new Celda();
		
		Celda celda2 = new Celda ();
		@Test
		void test() {
			
			celda1.setUnidad(soldado); //agrega entidad y setea posicion
			celda1.recibirUnidad(soldado);
			soldado.setPosicion(1,1);
			
			celda2.setUnidad(curandero); // agregaentidad y setea posicion
			
			
			
			if(celda1.recibirUnidad(curandero)) {
				soldado.moverUnidadA(jugador,1,2);
			}
			
			assertTrue(soldado.obtenerPosicionX() ==1 );
			assertTrue(soldado.obtenerPosicionY() ==1);
			
		}
}
