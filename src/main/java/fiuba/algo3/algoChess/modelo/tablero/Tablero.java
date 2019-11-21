package fiuba.algo3.algoChess.modelo.tablero;
import fiuba.algo3.algoChess.modelo.Excepciones.*;
import fiuba.algo3.algoChess.modelo.celda.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.jugador.*;

import java.util.HashMap;

public class Tablero {
	int filaminB = 11;
	private int tamanio = 20;
	private HashMap <String, Celda> matriz = new HashMap<String, Celda>();
	
	public  Tablero(){
		for(int i = 1; i < filaminB; i++) {
			for (int j = 1; j <= tamanio; j++) {
				matriz.put(new Posicion(j,i).toString(), new CeldaA());
			}
		}
		for(int i = filaminB; i <= tamanio; i++) {
			for (int j = 1; j <= tamanio; j++) {
				matriz.put(new Posicion(j,i).toString(), new CeldaB());
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
	public void moverMovibleA(JugadorB jugador, Movible movible, Posicion aPosicion) {
		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(Destino.celdaVacia() && this.verificarPosicion(aPosicion)) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
		}
	}
	
	public void moverMovibleA(JugadorA jugador, Movible movible, Posicion aPosicion) {
		Posicion dePosicion = movible.getPosicion();
		Celda Destino = matriz.get(aPosicion.toString());
		if(Destino.celdaVacia() && this.verificarPosicion(aPosicion)) {
			Celda Origen = matriz.get(dePosicion.toString());
			movible.movibleMoveteA(jugador, aPosicion);
			Destino.recibirMovible(Origen.vaciarCelda());
		}
	}


	/*@SuppressWarnings("unchecked")
	public LinkedList<Unidad> posicionablesADistanciaCercanaDe(Posicionable posicionable) {
		LinkedList<Unidad> aliadosCercanos = new LinkedList<Unidad>();
		int x = posicionable.getPosicion().getX();
		int y = posicionable.getPosicion().getY();
		for(int i = x - maxcercano; i <= x + maxcercano; i++) {
			for (int j = y - 2; j <= y + 2; j++) {
				try {
					if(this.verificarPosicion(new Posicion(i,j)) && (i != x || j != y)){
						if(!matriz.get(new Posicion(i, j).toString()).celdaVacia()){
							posicionablesCercanos.add(matriz.get(new Posicion(i, j).toString()).getPosicionable());
						}
					}
				} catch (CoordenadaFueraDelTableroExcepcion e) {
					//si las coordenadas estan fuera del tablero CoordenadaFueraDelTableroExcepcion.
				}

			}
		}
		return posicionablesCercanos;
	}
	
	public List posicionablesADistanciaMediaDe(Posicionable posicionable) {
		PosicionablesADistaciaCercana posicionablesCercanos = new LinkedList();
		if(!matriz.get(posicionable.getPosicion().toString()).celdaOcupadaPorPosicionable(posicionable)){
			return posicionablesCercanos;
		}

		for(int i = posicionable.getPosicion().getX() - 2; i <= posicionable.getPosicion().getX() + 2; i++) {
			for (int j = posicionable.getPosicion().getY() - 2; j <= posicionable.getPosicion().getY() + 2; j++) {

				try {
					if(this.verificarPosicion(new Posicion(i,j)) && (i != posicionable.getPosicion().getX() || j != posicionable.getPosicion().getY())){
						if(!matriz.get(new Posicion(i, j).toString()).celdaVacia()){
							posicionablesCercanos.add(matriz.get(new Posicion(i, j).toString()).getPosicionable());
						}
					}
				} catch (CoordenadaFueraDelTableroExcepcion e) {
					//si las coordenadas estan fuera del tablero CoordenadaFueraDelTableroExcepcion.
				}

			}
		}
		return posicionablesCercanos;
	}*/
}
