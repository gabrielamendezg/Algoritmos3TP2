package fiuba.algo3.algoChess.modelo.entidades;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.tablero.*;

import fiuba.algo3.algoChess.modelo.jugador.*;

import org.junit.jupiter.api.Test;;

public class SoldadoPuedeMoverseCorrectamenteTest {
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
	Curandero curandero = new Curandero();
	
	Jugador jugador = new Jugador();
	
	Celda celda1 = new Celda(jugador);
	Celda celda2 = new Celda(jugador);
	@Test
	void test() {
		
		soldado.setDuenio(jugador);
		
		celda1.setUnidad(soldado); //hace set posicion soldado
		soldado.setPosicion(1,1);
		
		celda1.moverUnidad(celda2); //hace soldado mover a posicion
		soldado.moverUnidadA(1, 2, jugador);
		
		assertTrue(soldado.obtenerPosicionX() ==1 );
		assertTrue(soldado.obtenerPosicionY() ==2);
		
	}

}
