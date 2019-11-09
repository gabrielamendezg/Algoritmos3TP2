package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;

public class Tablero {
	private static int tamanio = 20;
	private static boolean soyUnico = true;
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
	
	
	public static Tablero obtenerInstancia(Jugador jugadorA, Jugador jugadorB) throws InstanciaDeTableroYaExiste{
		if(!soyUnico){
			throw new InstanciaDeTableroYaExiste();
		}
		else {
			return new Tablero(jugadorA,jugadorB);
		}
	 }
	
	//No permite que se clone una instancia de tablero.
	public Tablero clone() throws CloneNotSupportedException {
		return null;
	}
	
	//Colocar una nueva pieza en el tablero. 
	public boolean colocarUnidad(Jugador jugador, Unidad unidad, int fila, int columna) throws Exception {
		try{
			return guardianMurallas.colocarEnPosicionPorJugador(jugador,unidad,fila,columna,matriz);
		}catch(Exception e) {
			 e.printStackTrace();
			throw e;
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
