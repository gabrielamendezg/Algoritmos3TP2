package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.tablero.*;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;

public class AlgoChess {

	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public AlgoChess() {
		
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		
		try {
			
			this.tablero = Tablero.obtenerInstancia(jugador1, jugador2);
		
		}catch(InstanciaDeTableroYaExiste e) {
			
			System.out.println("Error por tablero existente de antemano");
			}
		
		
		
	}
	
	public boolean jugar() {
		
		boolean seDesarrollaElJuegoNormalmente = true;
		
		this.setPiezasEnElTablero(jugador1);
		this.setPiezasEnElTablero(jugador2);
		
		while (seDesarrollaElJuegoNormalmente) {
			
			this.desarrollarTurno(jugador1, jugador2);
			
			seDesarrollaElJuegoNormalmente = jugador1.sigueEnJuego();
			seDesarrollaElJuegoNormalmente = jugador2.sigueEnJuego();
		}
		
		
		
		
		//REPENSAR SI AGREGO OTRO BOOL O SI USO EL MISMO
		
		return !seDesarrollaElJuegoNormalmente;
	}
	
	
	private void setPiezasEnElTablero(Jugador jugador) {
		
		
	}
	
	private void desarrollarTurno(Jugador jugadorA, Jugador jugadorB) {
		jugadorA.ordenarAtaque(jugadorB.obtenerUnidades());
		jugadorB.ordenarAtaque(jugadorA.obtenerUnidades());
		
	}
	
}
