package fiuba.algo3.algoChess.modelo.entidades.jinete;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import fiuba.algo3.algoChess.modelo.Excepciones.FilaOColumnaNoPerteneceATuParteDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
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

	@Test
	void jineteAtacaAdistanciaMediatest() {
		JugadorA jugador = new JugadorA();
		Jinete jinete = jugador.elegirJinete();
		Catapulta catapultaAliada = jugador.elegirCatapulta();

		JugadorB jugadorb = new JugadorB();
		SoldadoDeInfanteria soldado = jugadorb.elegirSoldado();
		Curandero curandero = jugadorb.elegirCurandero();

		Tablero tablero = new Tablero();
		tablero.posicionarEn(jugadorb,curandero, new Posicion(15, 5));
		tablero.posicionarEn(jugadorb,soldado, new Posicion(14, 5));
		tablero.posicionarEn(jugador,jinete, new Posicion(9, 5));
		tablero.posicionarEn(jugador,catapultaAliada, new Posicion(10, 5));

		tablero.atacanteAtacarAtacable(jugador, jinete, soldado);
	}

	@Test
	void jineteNoAtacaAdistanciaCercanatest() {
		JugadorA jugador = new JugadorA();
		Jinete jinete = jugador.elegirJinete();
		Catapulta catapultaAliada = jugador.elegirCatapulta();

		JugadorB jugadorb = new JugadorB();
		SoldadoDeInfanteria soldado = jugadorb.elegirSoldado();
		Curandero curandero = jugadorb.elegirCurandero();

		Tablero tablero = new Tablero();
		tablero.posicionarEn(jugadorb,curandero, new Posicion(11, 5));
		tablero.posicionarEn(jugadorb,soldado, new Posicion(14, 5));
		tablero.posicionarEn(jugador,jinete, new Posicion(9, 5));
		tablero.posicionarEn(jugador,catapultaAliada, new Posicion(10, 5));

		assertThrows(FueraDelRangoDeAtaqueExcepcion.class,
				()->{
					tablero.atacanteAtacarAtacable(jugador, jinete, curandero);
				});
	}
}
