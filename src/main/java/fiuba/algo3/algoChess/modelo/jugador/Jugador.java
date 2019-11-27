package fiuba.algo3.algoChess.modelo.jugador;

import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;


/*	-REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir
 * 	
 * -Ver responsabilidad de saber espacio del tablero (Jugador o tablero)
 * -Ver Encapsular puntaje e implementar selector de unidades
 * -- Ver refactoreo a Multiton para 2 (implementar con Dictionary)
 * 
 * */


public interface Jugador {
	
	//Obtención y creación de una Unidad de tipo:
    public SoldadoDeInfanteria elegirSoldado();
    public Catapulta elegirCatapulta();
    public Jinete elegirJinete();
    public Curandero elegirCurandero();
    
    /*/Obtiene limites de territorio. tablero maneja estas cosas
    public abstract int getFilaMin();
	public abstract int getFilaMax();
	public abstract int getColumnaMin();
	public abstract int getColumnaMax();*/

	//Otros Metodos
	public int cantidadDeUnidades();
	public ArrayList<Unidad> obtenerUnidades();
	public void eliminarUnidad(Unidad unaUnidad);
	//public void colocarenposicion(Unidad unidad, int fila, int columna, Unidad[][] matriz);
	//public void actualizarUnidades(ArrayList<Unidad> unidadesEnemigas,int cantidadEnemigas);
	
}
