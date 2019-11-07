package fiuba.algo3.algoChess.modelo.entidades;


import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.tablero.*;


import org.junit.jupiter.api.Test;


public class CuranderoNoSeMueveACeldaOcupadaTest {
		
		Jugador jugador = new Jugador();
		Celda celda1 = new Celda(jugador);
		Celda celda2 = new Celda(jugador);
		
		Curandero curandero = new Curandero();
		Jinete  jinete = new Jinete();
		
		
		
		
		@Test
		void curanderoNoSeMueveDeSuPosicion() {
			celda1.setUnidad(curandero); //setea posicion
			
			curandero.setPosicion(1, 1);
			celda2.setUnidad(jinete); //setea posicion
			
			
			if(celda1.moverUnidad(celda2)) {
				curandero.setPosicion(1, 2);
			}
			
			assertTrue(curandero.obtenerPosicionX() == 1);
			assertTrue(curandero.obtenerPosicionY() == 1);
			
		}
}