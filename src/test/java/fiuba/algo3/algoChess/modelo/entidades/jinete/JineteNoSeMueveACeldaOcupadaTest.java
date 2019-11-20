package fiuba.algo3.algoChess.modelo.entidades.jinete;

import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class JineteNoSeMueveACeldaOcupadaTest {

	Jugador jugador = new Jugador1("elvis");
	Curandero curandero = new Curandero(jugador.nombre());
	Jinete jinete = new Jinete(jugador.nombre());
	Tablero tablero = new Tablero();
	
	@Test
	void jineteNoSeMueveDeSuPosicion() {
		tablero.posicionarEn(jugador,jinete,new Posicion(1,1));
		tablero.posicionarEn(jugador,curandero,new Posicion(1,2));
		assertEquals(jinete.getPosicion().getX(), 1);
		assertEquals(jinete.getPosicion().getY(), 1);
		
	}

}
