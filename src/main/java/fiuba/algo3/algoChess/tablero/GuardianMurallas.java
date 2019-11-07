package fiuba.algo3.algoChess.tablero;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class GuardianMurallas {
	private int columnamin = 0;
	private int columnamax;
	private int filamin = 0;
	private int filamax;
	private Jugador jugador1;
	private Jugador jugador2;
	private int jugador1filamin = 0;
	private int jugador1filamax;
	private int jugador2filamin;
	private int jugador2filamax;
	
	public GuardianMurallas(int i, Jugador jugadorA, Jugador jugadorB) {
		columnamax = i;
		filamax = i-1;
		jugador1 = jugadorA;
		jugador2 = jugadorB;
		jugador1filamax = (i/2)-1;
		jugador2filamin = jugador1filamax +1;
		jugador2filamax = filamax;
	}

	public boolean verificarposicion(int fila, int columna) throws PosicionInvalidaException{
		if(fila < filamin || fila > filamax || columna < columnamin || columna > columnamax) {
			throw new PosicionInvalidaException();
		}
		return true;
	}

	public boolean colocarEnPosicionPorJugador(Jugador jugador, Unidad unidad, int fila, int columna) throws Exception{
		try{
			if(jugador == jugador1) {
				return this.jugador1colocarenposicion(unidad,fila,columna);
			}
			if(jugador == jugador2) {
				return this.jugador2colocarenposicion(unidad,fila,columna);
			}
		}catch(PosicionInvalidaException e) {
			throw new PosicionInvalidaException();
		}
			throw new JugadorInvalido();
	}
	
	private boolean jugador1colocarenposicion(Unidad unidad, int fila, int columna) throws PosicionInvalidaException{
		if(fila < jugador1filamin || fila > jugador1filamax || columna < columnamin || columna > columnamax) {
			throw new PosicionInvalidaException();
		}
		return unidad.moverUnidadA(jugador1, fila, columna);
	}
	
	private boolean jugador2colocarenposicion(Unidad unidad, int fila, int columna) throws PosicionInvalidaException{
		if(fila < jugador2filamin || fila > jugador2filamax || columna < columnamin || columna > columnamax) {
			throw new PosicionInvalidaException();
		}
		return unidad.moverUnidadA(jugador2, fila, columna);
	}
	
}
