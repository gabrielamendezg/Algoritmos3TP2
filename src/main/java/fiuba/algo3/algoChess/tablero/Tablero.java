package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

public class Tablero {
	private static int tamanio = 20;
	private static Tablero tablero = null ;
	private Celda[][] matriz;
	private GuardianMurallas guardianMurallas;
	
	private Tablero(Jugador jugadorA, Jugador jugadorB) {
		matriz = new Celda[tamanio][tamanio];
		guardianMurallas = new GuardianMurallas(20,jugadorA,jugadorB);
		for(int i = 0; i < tamanio; i++) {
			for (int j = 0; i < tamanio; i++) {
				matriz[i][j] = new Celda();
			}
		}
	}
	
	
	public static Tablero obtenerInstancia(Jugador jugadorA, Jugador jugadorB){
		if (tablero == null){
			tablero = new Tablero(jugadorA,jugadorB);
			return tablero;
		}
			return tablero;
	 }

	
	//Colocar una nueva pieza en el tablero. 
	public boolean colocarUnidad(Jugador jugador, Unidad unidad, int fila, int columna){
		try {
			if (guardianMurallas.colocarEnPosicionPorJugador(jugador,unidad,fila,columna,matriz)) {
				return true;
			} else {
				return false;
			}
		} catch (PosicionInvalidaException e){
			throw new PosicionInvalidaException();
		}

	}
	
	//Mueve la unidad (si existe) en la posición de origen a la posición destino. 
	public boolean moverUnidad(Jugador jugador, int filaorigen, int columnaorigen, int filadestino, int columnadestino) {
		try {
			if(guardianMurallas.verificarposicion(filaorigen, columnaorigen) && guardianMurallas.verificarposicion(filadestino,columnadestino)) {
				return matriz[filaorigen][columnaorigen].moverUnidad(jugador, filadestino, columnadestino);
			}
		} catch (PosicionInvalidaException e) {
			return false;
		}
		return false;
	}
	
	//Mueve la unidad a la posición indicada.
	public boolean recibirUnidad(Unidad unidad, int fila, int columna) {
		try {
			if(guardianMurallas.verificarposicion(fila, columna)) {
				return matriz[fila][columna].recibirUnidad(unidad);
			}
		} catch (PosicionInvalidaException e) {
			return false;
		}
		return false;
	}

}
