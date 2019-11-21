package fiuba.algo3.algoChess.modelo.jugador;

import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;


/*REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir*/


public interface Jugador {
	
	//Obtención y creación de una Unidad de tipo:
    public SoldadoDeInfanteria elegirSoldado();
    public Catapulta elegirCatapulta();
    public Jinete elegirJinete();
    public Curandero elegirCurandero();
    
    //Obtiene limites de territorio.
    public abstract int getFilaMin();
	public abstract int getFilaMax();
	public abstract int getColumnaMin();
	public abstract int getColumnaMax();

	//Otros Metodos
	public int cantidadDeUnidades();
	public ArrayList<Unidad> obtenerUnidades();
	public void eliminarUnidad(Unidad unaUnidad);
	//public void colocarenposicion(Unidad unidad, int fila, int columna, Unidad[][] matriz);
	public void actualizarUnidades(ArrayList<Unidad> unidadesEnemigas,int cantidadEnemigas);
	
}
