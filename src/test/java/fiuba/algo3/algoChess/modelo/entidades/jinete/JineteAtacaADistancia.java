package fiuba.algo3.algoChess.modelo.entidades.jinete;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Catapulta;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.jugador.JugadorB;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

class JineteAtacaADistanciaTest {
	 
	JugadorA jugador = new JugadorA();
	JugadorB jugadorb = new JugadorB();
	SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugadorb);
	Curandero curandero = new Curandero(jugadorb);
	Jinete jinete = jugador.elegirJinete();
	Catapulta catapultaAliada = jugador.elegirCatapulta();
	
	@Test
	void test() {

			curandero.setPosicion(new Posicion(1, 2));
			soldado.setPosicion(new Posicion(1,5));
			jinete.setPosicion(new Posicion(1, 1));
			catapultaAliada.setPosicion(new Posicion(2,1));
			ArrayList<Atacable> atacables = new ArrayList<Atacable>();
			atacables.add(curandero);
			atacables.add(soldado);
			
			
			jinete.atacarAtacable(jugador, soldado, atacables);

			
			
			assertTrue(soldado.obtenerVida() ==85);
			
			assertThrows(FueraDelRangoDeAtaqueExcepcion.class,
					() -> {
						jinete.atacarAtacable(jugador, curandero,atacables);

					});
	}

}
