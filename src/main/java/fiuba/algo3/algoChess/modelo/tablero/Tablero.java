package fiuba.algo3.algoChess.modelo.tablero;
import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.celda.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
	int filaminB = 11;
	private int tamanio = 20;
	private HashMap <String, Celda> matriz = new HashMap<String, Celda>();
	MovimientoDeBatallonDeSoldadosDeInfanteria movimientoDeBatallonDeSoldadosDeInfanteria = null;
	
	public  Tablero(){
		for(int i = 1; i < filaminB; i++) {
			for (int j = 1; j <= tamanio; j++) {
				matriz.put(new Posicion(i,j).toString(), new CeldaA());
			}
		}
		for(int i = filaminB; i <= tamanio; i++) {
			for (int j = 1; j <= tamanio; j++) {
				matriz.put(new Posicion(i,j).toString(), new CeldaB());
			}
		}
	}
	
	private boolean verificarPosicion(Posicion unaPosicion) {
		if(unaPosicion.getX() <= tamanio && unaPosicion.getY() <= tamanio && unaPosicion.getX() > 0 && unaPosicion.getY() > 0) {
			return true;
		}
		throw new CoordenadaFueraDelTableroExcepcion();
	}
	
	//Colocar una nueva pieza en el tablero.
	//Modifico para hacer uso de CeldaA y CeldaB, encapsular y eliminar condiciones ifs y evaluaciones lógicas.
	public void posicionarEn(JugadorA jugador, Posicionable posicionable, Posicion aPosicion){
		matriz.get(aPosicion.toString()).recibirPosicionable(jugador, posicionable, aPosicion);
	}
	
	public void posicionarEn(JugadorB jugador, Posicionable posicionable, Posicion aPosicion){
		matriz.get(aPosicion.toString()).recibirPosicionable(jugador, posicionable, aPosicion);
	}

	//Mueve la unidad (si existe) en la posición de origen a la posición destino.
	//Reescribo un poco por más orden.
	private void moverMovibleA(JugadorB jugador, Movible movible, Posicion aPosicion) {

		if(movimientoDeBatallonDeSoldadosDeInfanteria == null){
			movimientoDeBatallonDeSoldadosDeInfanteria = new MovimientoDeBatallonDeSoldadosDeInfanteria(3);
			if(movimientoDeBatallonDeSoldadosDeInfanteria.moverBatallonDeMovibleA(this, jugador, movible, aPosicion)){
				movimientoDeBatallonDeSoldadosDeInfanteria = null;
				return;
			}
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
		}

		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(Destino.celdaVacia() && this.verificarPosicion(aPosicion)) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
		}
	}
	
	private void moverMovibleA(JugadorA jugador, Movible movible, Posicion aPosicion) {

		if(movimientoDeBatallonDeSoldadosDeInfanteria == null){
			movimientoDeBatallonDeSoldadosDeInfanteria = new MovimientoDeBatallonDeSoldadosDeInfanteria(3);
			if(movimientoDeBatallonDeSoldadosDeInfanteria.moverBatallonDeMovibleA(this, jugador, movible, aPosicion)){
				movimientoDeBatallonDeSoldadosDeInfanteria = null;
				return;
			}
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
		}

		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(Destino.celdaVacia() && this.verificarPosicion(aPosicion)) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
			return;
		}
		throw new PosicionOcupadaExcepcion();
	}

	public void moverMovibleADerecha(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAIzquierda(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAAdelante(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() + 1));
	}
	public void moverMovibleAAtras(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() - 1));
	}

	public void moverMovibleADerecha(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAIzquierda(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAAdelante(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAAtras(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() + 1));
	}


	public void atacanteAtacarAtacable(JugadorA jugadorAtacanteA, Atacador unAtacante, Atacable unAtacable) {
		ArrayList <Atacable> atacables = this.atacablesPorElAtacante(unAtacante);
		unAtacante.atacarAtacable(jugadorAtacanteA, unAtacable, atacables);
	}
	public void atacanteAtacarAtacable(JugadorB jugadorAtacanteB, Atacador unAtacante, Atacable unAtacable) {
		ArrayList <Atacable> atacables = this.atacablesPorElAtacante(unAtacante);
		unAtacante.atacarAtacable(jugadorAtacanteB, unAtacable, atacables);
	}

	private ArrayList<Atacable> atacablesPorElAtacante(Atacador unAtacante) {

		ArrayList<Atacable> atacables = new ArrayList<Atacable>();
		for(int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if(new Posicion(i,j).toString() != unAtacante.getPosicion().toString()){
					if(!matriz.get(new Posicion(i,j).toString()).celdaVacia()){
						atacables.add((Atacable) matriz.get(new Posicion(i,j).toString()).getPosicionable());
					}
				}
			}
		}

		return atacables;
	}

}
