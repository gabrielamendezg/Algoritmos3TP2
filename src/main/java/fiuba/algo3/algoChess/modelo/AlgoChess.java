package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.modelo.tablero.*;

import java.io.IOException;

import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;

public class AlgoChess {

	private Tablero tablero;
	InterfazDeUsuario interfaz;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public AlgoChess() {
		
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		interfaz = new InterfazDeUsuario();	
		this.tablero = Tablero.obtenerInstancia(jugador1, jugador2);

	}
	
	public boolean jugar() throws IOException{
		
		boolean seDesarrollaElJuegoNormalmente = true;
		
		interfaz.mostrarPorConsola("Bienvenido a AlgoChess V1.0");
		
		this.elegirUnidades(jugador1);
		this.elegirUnidades(jugador2);
		
		this.setPiezasEnElTablero(jugador1);
		this.setPiezasEnElTablero(jugador2);
		
		while (seDesarrollaElJuegoNormalmente) {
			
		
			this.colocarUnidadesEnTablero(jugador1);
			this.colocarUnidadesEnTablero(jugador2);
			
			this.desarrollarTurno(jugador1, jugador2);
			
			
			/* Luego de cada turno se comprueba que ninguno de los jugadores haya perdido
			Luego hay que refactorear cuando redefinamos turno y ataques
			Ademas de que en como esta codeado ahora podrian perder ambos
			en el mismo turno. Ademas no verifica cual de los jugadores perdio aun, sino
			que identifica que uno perdio.
			*/
			seDesarrollaElJuegoNormalmente = jugador1.sigueEnJuego();
			seDesarrollaElJuegoNormalmente = jugador2.sigueEnJuego();
		}
		
		
		
		
		//REPENSAR SI AGREGO OTRO BOOL O SI USO EL MISMO
		
		return !seDesarrollaElJuegoNormalmente;
	}
	
	
	private void setPiezasEnElTablero(Jugador jugador) {
		
		
		
		
	}
	
	
	// Por ahora turno consiste en que cada jugador mueva y ordene ataque a sus unidades
	//Queda ver que unidad mueve
	private void desarrollarTurno(Jugador jugadorA, Jugador jugadorB) {
		
		
		jugadorA.ordenarAtaque(jugadorB.obtenerUnidades());
		
		
		
		jugadorB.ordenarAtaque(jugadorA.obtenerUnidades());
		
		
		
	}
	
	
	private void elegirUnidades(Jugador jugador) throws IOException{
		
		
		interfaz.elegirUnidades(tablero, jugador);
		
		
	}
	
	//Mover piezas durante los turnos
	private void colocarUnidadesEnTablero(Jugador jugador) {
		
		
		
		
	}
	
}
