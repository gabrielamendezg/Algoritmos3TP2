package fiuba.algo3.algoChess.tablero;
import fiuba.algo3.algoChess.modelo.entidades.Entidad;

abstract class EstadoCelda {
	abstract boolean recibirEntidad(Entidad contenido,Celda receptora);
	abstract boolean moverEntidad(Entidad contenido,Celda receptora,Celda emisora);
}
