package fiuba.algo3.algoChess.modelo.algoChess;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.tablero.*;

/*Rearmar base
 * 
 * 
 * 
 */

import fiuba.algo3.algoChess.modelo.jugador.*;

public class AlgoChess {

	private static AlgoChess algoChess = new AlgoChess();
	private Tablero tablero = new Tablero();
	private JugadorA jugadorA = new JugadorA();
	private JugadorB jugadorB = new JugadorB();

	private Jugador jugadorActivo = jugadorA;
	private Jugador jugadorOponente = jugadorB;

	

	private AlgoChess() {
		tablero = new Tablero();
	}

	public static AlgoChess getAlgoChess(){
		return algoChess;
	}
	public static void reiniciarAlgoChess(){
		algoChess = new AlgoChess();
	}

	public void posicionarPosicionable(Posicionable posicionable, int x, int y) {

		if(jugadorActivo instanceof JugadorA)
			tablero.posicionarEn((JugadorA) jugadorActivo, posicionable, new Posicion(x, y));
		if(jugadorActivo instanceof JugadorB)
			tablero.posicionarEn((JugadorB) jugadorActivo, posicionable, new Posicion(x, y));
	}

	public Jugador getJugadorActivo() {
		return jugadorActivo;
	}

	public void pasarTurno() {
		Jugador tem = jugadorActivo;
		jugadorActivo = jugadorOponente;
		jugadorOponente = tem;
	}

	public void jugadorActivoAzul() {
		jugadorActivo = jugadorA;
		jugadorOponente = jugadorB;
	}
	public void jugadorActivoRojo() {
		jugadorActivo = jugadorB;
		jugadorOponente = jugadorA;
	}

	public Posicionable unidadDeLaPosicion(int x, int y) {
		return tablero.getPosicionableDeLaPosicion(new Posicion(x, y));
	}

	public void primeraUnidadSeleccionadaAtacaSegundaUnida(Atacador unidad1, Atacable unidad2) {
		if(jugadorActivo instanceof JugadorA)
			tablero.atacanteAtacarAtacable((JugadorA) jugadorActivo, unidad1, unidad2);
		if(jugadorActivo instanceof JugadorB)
			tablero.atacanteAtacarAtacable((JugadorB) jugadorActivo, unidad1, unidad2);
	}
}
