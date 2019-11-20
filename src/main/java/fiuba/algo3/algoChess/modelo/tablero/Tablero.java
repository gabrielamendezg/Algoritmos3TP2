package fiuba.algo3.algoChess.modelo.tablero;
import fiuba.algo3.algoChess.modelo.Excepciones.CoordenadaFueraDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.FilaOColumnaNoPerteneceATuParteDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.celda.Celda;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.SoldadoDeInfanteria;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.entidades.posicionables.PosicionableADistaciaCercana;
import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import java.util.HashMap;

public class Tablero {
	private int tamanio = 20;
	private HashMap <String, Celda> matriz = new HashMap<String, Celda>();
	public  Tablero(){
		for(int i = 1; i <= tamanio; i++) {
			for (int j = 1; j <= tamanio; j++) {
				matriz.put(new Posicion(j,i).toString(), new Celda());
			}
		}
	}

	//Colocar una nueva pieza en el tablero.
	public void posicionarEn(Jugador jugador, Posicionable posicionable, Posicion aPosicion){

		if(this.verificaSiPerteneceAMiParteDelTablero(jugador, aPosicion) && this.verificaSiEstaLibreLaPosicion(aPosicion)) {
			posicionable.posicionateEnEstaPosicion(jugador.nombre(), aPosicion);
			matriz.get(aPosicion.toString()).recibirPosicionable(posicionable);
		}
	}

	public boolean verificaSiEstaLibreLaPosicion(Posicion unaPosicion) {
		if (matriz.get(unaPosicion.toString()).celdaVacia()){
			return true;
		} else {
			throw new PosicionOcupadaExcepcion();
		}
	}

	private boolean verificaSiPerteneceAMiParteDelTablero(Jugador jugador, Posicion aPosicion) {
		if (aPosicion.getX() >= jugador.getFilaMin() && aPosicion.getX() <= jugador.grtFilaMax() && aPosicion.getY() >= jugador.getColumnaMin() && aPosicion.getY() <= jugador.getColumnaMax()){
			return true;
		}else {
				throw new FilaOColumnaNoPerteneceATuParteDelTableroExcepcion();
		}
	}


	//Mueve la unidad (si existe) en la posición de origen a la posición destino.
	public void moverMovibleA(Jugador jugador, Movible movible, Posicion aPosicion) {

		if(this.verificarPosicion(movible.getPosicion()) && this.verificarPosicion(aPosicion)) {

			if (this.verificaSiEstaLibreLaPosicion(aPosicion)) {
				movible.movibleMoveteA(jugador.nombre(), aPosicion);
				matriz.get(aPosicion.toString()).recibirPosicionable(matriz.get(movible.getPosicion().toString()).vaciarCelda());
			}
		}
	}

	private boolean verificarPosicion(Posicion posicio) {
		if(posicio.getX() <= tamanio && posicio.getY() <= tamanio && posicio.getX() > 0 && posicio.getY() > 0)
			return true;
		throw new CoordenadaFueraDelTableroExcepcion();
	}

	public PosicionableADistaciaCercana posicionablesADistanciaCercanaDe(Posicionable posicionable) {
		PosicionableADistaciaCercana posicionablesCercanos = new PosicionableADistaciaCercana();
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
	}
}
