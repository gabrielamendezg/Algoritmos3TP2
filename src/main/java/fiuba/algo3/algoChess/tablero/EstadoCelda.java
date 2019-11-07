package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;

abstract class EstadoCelda {
	abstract boolean recibirUnidad(Unidad contenido,Celda receptora);
	abstract boolean moverUnidad(Unidad contenido,Celda receptora,Celda emisora);
}
