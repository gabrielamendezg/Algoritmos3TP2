package fiuba.algo3.algoChess.modelo.algoChess;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
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

	private Jugador jugadorAtivo = jugadorA;
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

		if(jugadorAtivo instanceof JugadorA)
			tablero.posicionarEn((JugadorA) jugadorAtivo, posicionable, new Posicion(x, y));
		if(jugadorAtivo instanceof JugadorB)
			tablero.posicionarEn((JugadorB) jugadorAtivo, posicionable, new Posicion(x, y));
	}

	public Jugador getJugadorActivo() {
		return jugadorAtivo;
	}

	public void pasarTurno() {
		Jugador tem = jugadorAtivo;
		jugadorAtivo = jugadorOponente;
		jugadorOponente = tem;
	}

	public void jugadorActivoAzul() {
		jugadorAtivo = jugadorA;
		jugadorOponente = jugadorB;
	}
	public void jugadorActivoRojo() {
		jugadorAtivo = jugadorB;
		jugadorOponente = jugadorA;
	}
}
