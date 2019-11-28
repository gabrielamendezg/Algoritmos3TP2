package fiuba.algo3.algoChess.modelo.entidades.soldadoDeInfanteria;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;
import fiuba.algo3.algoChess.modelo.jugador.*;
import java.util.ArrayList;

class SoldadoDeInfanteriaNoQuitaVidaSiNoEstaEnRangoTest {
	
	JugadorA jugador = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador);
	Curandero curandero = new Curandero(jugadorb);
	@Test
	void soldadoNoQuitaVida() {
		curandero.setPosicion(new Posicion(1, 4));
		soldado.setPosicion(new Posicion(1,1));

		assertThrows(FueraDelRangoDeAtaqueExcepcion.class,
				()->{
					soldado.atacarAtacable(jugador, curandero, new ArrayList<Atacable>());
				});
		
		assertTrue(curandero.obtenerVida() == 75);
		
	}

}