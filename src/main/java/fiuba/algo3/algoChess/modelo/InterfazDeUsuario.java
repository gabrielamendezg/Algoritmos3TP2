package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.modelo.tablero.*;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class InterfazDeUsuario {
	
	public boolean elegirUnidades(Tablero tablero, Jugador jugador) {
		boolean sePudoElegirCorrectamente=false;
		System.out.println("Elija unidades hasta agotar sus 20 puntos");
		System.out.println("1- Soldado de infanteria %n 2-Jinete%n 3-Catapulta%n 4-Curandero");
		
		
		
		return sePudoElegirCorrectamente;
	}
	
	public boolean moverUnidades(Tablero tablero, Jugador jugador) {
		boolean sePudoMoverCorrectamente= false;
		
		
		return sePudoMoverCorrectamente;
	}
	
	public boolean mostrarPorConsola(String mensaje) {
		
		System.out.println(mensaje);
		
		return true ;
		
	}
	
	public boolean posicionarUnidades(Tablero tablero, Jugador jugador) {
		boolean sePosicionarionCorrectamente= false;
		
		
		return sePosicionarionCorrectamente;
	}
	
	
	
	
}
