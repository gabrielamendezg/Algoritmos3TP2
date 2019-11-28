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

	//Otros Metodos
	public int cantidadDeUnidades();
	public ArrayList<Unidad> obtenerUnidades();
	public void eliminarUnidad(Unidad unaUnidad);
}
