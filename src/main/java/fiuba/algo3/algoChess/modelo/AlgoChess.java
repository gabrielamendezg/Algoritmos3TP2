package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.modelo.tablero.*;

import java.io.IOException;

import fiuba.algo3.algoChess.modelo.Excepciones.InstanciaDeTableroYaExiste;
import fiuba.algo3.algoChess.modelo.jugador.*;


@SuppressWarnings("unused")
public class AlgoChess {

	private static AlgoChess algoChess = new AlgoChess();
	private Tablero tablero = new Tablero();
	InterfazDeUsuario interfaz;
	private Jugador jugadorA = new JugadorA();
	private Jugador jugadorB = new JugadorB();
	

	private AlgoChess() {
		tablero = new Tablero();
	}

	public AlgoChess getAlgoChess(){
		return algoChess;
	}
	public static void reiniciarAlgoChess(){
		algoChess = new AlgoChess();
	}
	public void jugar(){}


	private void setPiezasEnElTablero(Jugador jugador) {
		
	}

	private void elegirUnidades(Jugador jugador) throws IOException{
		interfaz.elegirUnidades(tablero, jugador);
		jugadorA.actualizarUnidades(jugadorB.obtenerUnidades(),jugadorB.cantidadDeUnidades());
		jugadorB.actualizarUnidades(jugadorA.obtenerUnidades(),jugadorA.cantidadDeUnidades());
	}

	//Mover piezas durante los turnos
	private void colocarUnidadesEnTablero(Jugador jugador) {
		

	}
	
	
	
	

}
