package fiuba.algo3.algoChess.modelo.tablero;
import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.Observable;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacante;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {

	private int xMinB = 11;
	private int tamanio = 20;
	private HashMap <String, Celda> matriz = new HashMap<String, Celda>();
	MovimientoDeBatallonDeSoldadosDeInfanteria movimientoDeBatallonDeSoldadosDeInfanteria = null;

	public  Tablero(){
		for(int x = 1; x < xMinB; x++) {
			for (int y = 1; y <= tamanio; y++) {
				matriz.put(new Posicion(x,y).toString(), new CeldaA());
			}
		}
		for(int x = xMinB; x <= tamanio; x++) {
			for (int y = 1; y <= tamanio; y++) {
				matriz.put(new Posicion(x,y).toString(), new CeldaB());
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
		try {
			if(movimientoDeBatallonDeSoldadosDeInfanteria == null){
				movimientoDeBatallonDeSoldadosDeInfanteria = new MovimientoDeBatallonDeSoldadosDeInfanteria(3);
				if(movimientoDeBatallonDeSoldadosDeInfanteria.moverBatallonDeMovibleA(this, jugador, movible, aPosicion)){
					movimientoDeBatallonDeSoldadosDeInfanteria = null;
					return;
				}
				movimientoDeBatallonDeSoldadosDeInfanteria = null;
			}
		}catch (PosicionOcupadaExcepcion e){
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
			throw  new PosicionOcupadaExcepcion();
		}catch (CoordenadaFueraDelTableroExcepcion e){
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
			throw new CoordenadaFueraDelTableroExcepcion();
		}


		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(this.verificarPosicion(aPosicion) && Destino.celdaVacia()) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
			AlgoChess.getAlgoChess().actualizarObservadores((Observable) movible);
			return;
		}
		throw new PosicionOcupadaExcepcion();
	}

	private void moverMovibleA(JugadorA jugador, Movible movible, Posicion aPosicion) {

		try {
			if(movimientoDeBatallonDeSoldadosDeInfanteria == null){
				movimientoDeBatallonDeSoldadosDeInfanteria = new MovimientoDeBatallonDeSoldadosDeInfanteria(3);
				if(movimientoDeBatallonDeSoldadosDeInfanteria.moverBatallonDeMovibleA(this, jugador, movible, aPosicion)){
					movimientoDeBatallonDeSoldadosDeInfanteria = null;
					return;
				}
				movimientoDeBatallonDeSoldadosDeInfanteria = null;
			}
		}catch (PosicionOcupadaExcepcion e){
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
			throw  new PosicionOcupadaExcepcion();
		}catch (CoordenadaFueraDelTableroExcepcion e){
			movimientoDeBatallonDeSoldadosDeInfanteria = null;
			throw new CoordenadaFueraDelTableroExcepcion();
		}


		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(this.verificarPosicion(aPosicion) && Destino.celdaVacia()) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
			AlgoChess.getAlgoChess().actualizarObservadores((Observable) movible);
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
	public void moverMovibleAArriba(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() + 1));
	}
	public void moverMovibleAAbajo(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAAbajoDerecha(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAArribaDerecha(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY() + 1));
	}
	public void moverMovibleAAbajoIzquierda(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAArribaIzquierda(JugadorA jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY() + 1));
	}


	public void moverMovibleADerecha(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAIzquierda(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY()));
	}
	public void moverMovibleAArriba(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() + 1));
	}
	public void moverMovibleAAbajo(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX(), movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAAbajoDerecha(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAArribaDerecha(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() + 1, movible.getPosicion().getY() + 1));
	}
	public void moverMovibleAAbajoIzquierda(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY() - 1));
	}
	public void moverMovibleAArribaIzquierda(JugadorB jugador, Movible movible) {
		moverMovibleA(jugador, movible, new Posicion(movible.getPosicion().getX() - 1, movible.getPosicion().getY() + 1));
	}

	public void atacanteAtacarAtacable(JugadorA jugadorAtacanteA, Atacante unAtacante, Atacable unAtacable) {
		ArrayList <Atacable> atacables = this.atacablesPorElAtacante(unAtacante);
		unAtacante.atacarAtacable(jugadorAtacanteA, unAtacable, atacables);
	}
	public void atacanteAtacarAtacable(JugadorB jugadorAtacanteB, Atacante unAtacante, Atacable unAtacable) {
		ArrayList <Atacable> atacables = this.atacablesPorElAtacante(unAtacante);
		unAtacante.atacarAtacable(jugadorAtacanteB, unAtacable, atacables);
	}

	private ArrayList<Atacable> atacablesPorElAtacante(Atacante unAtacante) {

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

	public Posicionable getPosicionableDeLaPosicion(Posicion posicion) {
		try {
			if (this.verificarPosicion(posicion)) {
				if (!matriz.get(posicion.toString()).celdaVacia())
					return matriz.get(posicion.toString()).getPosicionable();
			}
		} catch (CoordenadaFueraDelTableroExcepcion e) {}
		return null;
	}
	public Celda getCeldaDeLaPosicion(int x, int y) {
		return matriz.get(new Posicion(x,y).toString());
	}

	public void eliminarUnidadesMuertasDelTabler() {
		matriz.values().stream().forEach(celda -> {
			if(celda.getPosicionable() != null && celda.getPosicionable().obtenerVida() <= 0)
				celda.vaciarCelda();
		});
		matriz.values().stream().forEach(celda -> {
			if(celda.getPosicionable() != null)
				AlgoChess.getAlgoChess().actualizarObservadores((Observable) celda.getPosicionable());
		});
	}
}
