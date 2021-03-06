package fiuba.algo3.algoChess.modelo.entidades.curandero;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ArrayList;

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
		
		curandero.setPosicion(new Posicion(1, 3));
		
		soldado.atacarAtacable(jugadora, jinete, new ArrayList<Atacable>());
		soldado.atacarAtacable(jugadora, jinete, new ArrayList<Atacable>());
		
		curandero.sanar(jinete);
		assertTrue(jinete.obtenerVida() == 95);
	}

}
