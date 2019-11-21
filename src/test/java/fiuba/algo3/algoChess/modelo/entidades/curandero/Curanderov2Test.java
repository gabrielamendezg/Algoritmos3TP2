package fiuba.algo3.algoChess.modelo.entidades.curandero;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

class Curanderov2Test {
	JugadorA jugadora = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	Curandero curandero = new Curandero(jugadora);
	
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria (jugadorb);
	Jinete jinete = new Jinete(jugadora);
	

	@Test
	void curaVidaCorrespondientetest() {
		
		soldado.setPosicion(new Posicion(1,1));
		jinete.setPosicion(new Posicion(1, 2));
		
		curandero.setPosicion(new Posicion(1, 5));
		
		soldado.atacar(jugadorb,jinete,0);
		soldado.atacar(jugadorb,jinete,0);
		
		curandero.sanar(jinete);
		assertTrue(jinete.obtenerVida() == 95);
	}

}
