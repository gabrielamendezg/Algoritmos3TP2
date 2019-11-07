package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;

public class Tablero {
	private static int tamanio = 20;
	private static boolean soyUnico = true;
	private Celda[][] matriz;
	
	private Tablero() {
		this.matriz = new Celda[tamanio][tamanio];
	}
	
	public static Tablero obtenerInstancia() throws InstanciaDeTableroYaExiste{
		if(!soyUnico){
			throw new InstanciaDeTableroYaExiste();
		}
		else {
			return new Tablero();
		}
	   }
	
	public Tablero clone() throws CloneNotSupportedException {
		return null;
	}

	public boolean moverUnidad(int fila, int columna) {
		return matriz[fila][columna].moverUnidad(matriz[0][0]);
	}
}
