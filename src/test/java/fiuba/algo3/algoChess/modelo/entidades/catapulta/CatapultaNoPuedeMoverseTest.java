package fiuba.algo3.algoChess.modelo.entidades.catapulta;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

public class CatapultaNoPuedeMoverseTest {

	Catapulta catapulta = new Catapulta("");
	Jugador jugador = new JugadorA("");
	Tablero tablero = new Tablero();
	
	@Test
	void test() {

		tablero.posicionarEn(jugador, catapulta, new Posicion(1, 1));
		//Por no ser movible no compila
		//tablero.moverUnidadA(jugador, catapulta, new Posicion(1, 2));
		
		assertTrue(catapulta.getPosicion().getX() ==1 );
		assertTrue(catapulta.getPosicion().getY() ==1);
		
	}

}
