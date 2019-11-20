package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SoldadoNoPuedeMoverseACeldaOcupadaTest {
	
		Jugador jugador = new Jugador1("Zele");
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador.nombre());
		Curandero curandero = new Curandero(jugador.nombre());
		Tablero tablero = new Tablero();
		@Test
		void test() {
			tablero.posicionarEn(jugador, soldado, new Posicion(1, 1));

			
			tablero.posicionarEn(jugador, curandero, new Posicion(1, 2)); // agregaentidad y setea posicion

			assertThrows( PosicionOcupadaExcepcion.class, ()->{
				tablero.moverMovibleA(jugador, soldado, new Posicion( 1, 2));
			}

			);

			
		}
}
