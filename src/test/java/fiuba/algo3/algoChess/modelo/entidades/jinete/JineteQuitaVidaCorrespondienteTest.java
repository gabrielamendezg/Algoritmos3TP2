package fiuba.algo3.algoChess.modelo.entidades.jinete;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;
import fiuba.algo3.algoChess.modelo.jugador.*;
import java.util.ArrayList;

class JineteQuitaVidaCorrespondienteTest {
	JugadorA jugador = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugadorb);
	Curandero curandero = new Curandero(jugadorb);
	Jinete jinete = new Jinete(jugador);

	@Test
	void test() {
		curandero.setPosicion(new Posicion(1, 2));
		soldado.setPosicion(new Posicion(1,4));
		jinete.setPosicion(new Posicion(1, 1));
		ArrayList<Atacable> atacables = new ArrayList<Atacable>();
		atacables.add(curandero);
		atacables.add(soldado);
		
		jinete.atacarAtacable(jugador, curandero, atacables);
		
		assertTrue(curandero.obtenerVida() == 70);
		
		
		assertTrue(soldado.obtenerVida() ==100);
		
		assertThrows(FueraDelRangoDeAtaqueExcepcion.class,
				() -> {
					jinete.atacarAtacable(jugador, soldado,atacables);

				});
		
	}

}