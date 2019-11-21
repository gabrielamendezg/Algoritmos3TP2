package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.*;

class SoldadoDeInfanteriaRestaVidaCorrespondienteTest {
	
	JugadorA jugadora = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugadora);
	Curandero curandero = new Curandero(jugadorb);
	@Test
	void test() {
		curandero.setPosicion(new Posicion(1, 2));
		soldado.setPosicion(new Posicion(1,1));
		
		soldado.atacar(jugadora,curandero,0);
		
		assertTrue(curandero.obtenerVida() == 65);
		
	}

}
