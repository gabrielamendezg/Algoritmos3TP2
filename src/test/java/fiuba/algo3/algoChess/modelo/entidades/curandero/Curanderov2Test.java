package fiuba.algo3.algoChess.modelo.entidades.curandero;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

class Curanderov2Test {
	String jugador = "elvis";
	Curandero curandero = new Curandero(jugador);
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria (jugador);
	Jinete jinete = new Jinete(jugador);
	

	@Test
	void curaVidaCorrespondientetest() {
		
		soldado.setPosicion(new Posicion(1,1));
		jinete.setPosicion(new Posicion(1, 2));
		
		curandero.setPosicion(new Posicion(1, 5));
		
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		
		curandero.sanar(jinete);
		assertTrue(jinete.obtenerVida() == 95);
	}

}
