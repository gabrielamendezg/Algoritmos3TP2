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
	
		JugadorA jugador = new JugadorA();
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
		Curandero curandero = new Curandero(jugador);
		Tablero tablero = new Tablero();
		@Test
		void test() {
			tablero.posicionarEn(jugador, soldado, new Posicion(1, 1));

			
			tablero.posicionarEn(jugador, curandero, new Posicion(2, 1)); // agregaentidad y setea posicion

			assertThrows( PosicionOcupadaExcepcion.class, ()->{
				tablero.moverMovibleADerecha(jugador, soldado);
			}

			);

			
		}
}
