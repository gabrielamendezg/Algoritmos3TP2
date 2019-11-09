package fiuba.algo3.algoChess.modelo.entidades.jinete;
import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.jugador.*;

import org.junit.jupiter.api.Test;


class JineteNoSeMueveACeldaOcupadaTest {

	Jugador jugador = new Jugador();
	Celda celda1 = new Celda();
	Celda celda2 = new Celda();
	
	Curandero curandero = new Curandero(jugador);
	Jinete jinete = new Jinete(jugador);
	
	
	
	
	@Test
	void jineteNoSeMueveDeSuPosicion() {
		celda1.setUnidad(jinete); //setea posicion
		
		jinete.setPosicion(1, 1);
		celda2.setUnidad(curandero); //setea posicion
		
		
		/*if(celda1.moverUnidad(celda2)) {
			jinete.setPosicion(1, 2);
		}*/
		
		assertTrue(jinete.obtenerPosicionX() == 1);
		assertTrue(jinete.obtenerPosicionY() == 1);
		
	}

}
