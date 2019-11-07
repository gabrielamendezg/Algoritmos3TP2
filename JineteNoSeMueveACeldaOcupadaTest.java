package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.tablero.*;
import fiuba.algo3.algoChess.modelo.entidades.*;

import org.junit.jupiter.api.Test;


class JineteNoSeMueveACeldaOcupadaTest {
	
	Jugador jugador = new Jugador();
	Celda celda1 = new Celda(jugador);
	Celda celda2 = new Celda(jugador);
	
	Curandero curandero = new Curandero();
	Jinete  jinete = new Jinete();
	
	
	
	
	@Test
	void jineteNoSeMueveDeSuPosicion() {
		celda1.setUnidad(jinete); //setea posicion
		
		jinete.setPosicion(1, 1);
		celda2.setUnidad(curandero); //setea posicion
		
		
		if(celda1.moverUnidad(celda2)) {
			jinete.setPosicion(1, 2);
		}
		
		assertTrue(jinete.obtenerPosicionX() == 1);
		assertTrue(jinete.obtenerPosicionY() == 1);
		
	}

}
