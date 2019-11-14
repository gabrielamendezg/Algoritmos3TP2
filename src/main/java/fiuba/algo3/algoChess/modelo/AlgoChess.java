package fiuba.algo3.algoChess.modelo;

import fiuba.algo3.algoChess.modelo.tablero.*;

import java.io.IOException;
import java.util.*;

import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.sample.InstanciaDeTableroYaExiste;

public class AlgoChess {

	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public AlgoChess() {
		
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		this.tablero = Tablero.obtenerInstancia(jugador1, jugador2);

	}
	
	public boolean jugar() throws IOException{
		
		boolean seDesarrollaElJuegoNormalmente = true;
		
		
		this.elegirUnidades(jugador1);
		this.elegirUnidades(jugador2);
		
		this.setPiezasEnElTablero(jugador1);
		this.setPiezasEnElTablero(jugador2);
		
		while (seDesarrollaElJuegoNormalmente) {
			
		
			this.elegirUnidadYMoverUnidadEnTablero(jugador1);
			this.elegirUnidadYMoverUnidadEnTablero(jugador2);
			
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
		
		ArrayList<Unidad> unidades = jugador.obtenerUnidades();
		int posicionX=1;
		int posicionY=1;
		Scanner scanner = new Scanner (System.in);
		Iterator<Unidad> iterador = unidades.iterator();
		Unidad unidadActual;
		
		
		while (iterador.hasNext()) {
			unidadActual=iterador.next();
			System.out.println("El jugador "+jugador+" elige posicion de unidad "+unidadActual);
			System.out.println("Ingrese posicion x de la unidad");
			posicionX= scanner.nextInt();
			System.out.println("Ingrese posicion y de la unidad");
			posicionY= scanner.nextInt();
			unidadActual.setPosicion(posicionX, posicionY);
			tablero.colocarUnidad(jugador, unidadActual, posicionX, posicionY);
		}
		
	
		
		
	}
	
	
	// Por ahora turno consiste en que cada jugador mueva y ordene ataque a sus unidades
	//Queda ver que unidad mueve
	private void desarrollarTurno(Jugador jugadorA, Jugador jugadorB) {
		
		
		jugadorA.ordenarAtaque(jugadorB.obtenerUnidades());
		
		
		
		jugadorB.ordenarAtaque(jugadorA.obtenerUnidades());
		
		
		
	}
	
	
	public boolean elegirUnidades(Jugador jugador) throws IOException{
		String eleccion="1";
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Elegir entre las siguientes unidades");
		System.out.println("1-Soldado 2-Jinete 3-Catapulta 4-Curandero");
		do {
			System.out.println("Elegir");
	
		eleccion = scanner.nextLine();
		System.out.println (eleccion);
		
		
		switch (eleccion) {
		case "1":
			jugador.elegirSoldado();
		case "2":
			jugador.elegirJinete();
		case "3":
			jugador.elegirCatapulta();
		case "4":
			jugador.elegirCurandero();
			}
		}while(jugador.tienePuntosRestantes());
		
		return (!jugador.tienePuntosRestantes());
	}
	
	//Mover piezas durante los turnos
	private void elegirUnidadYMoverUnidadEnTablero(Jugador jugador) {
		

		
		
		
	}
	
}
