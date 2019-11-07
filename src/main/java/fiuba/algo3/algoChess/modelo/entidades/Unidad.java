package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.jugador.*;

import fiuba.algo3.algoChess.modelo.ataque.*;

public class Unidad {
	
	
	Ataque ataque;
	public int vida;
	public int costo;
	
	public Jugador duenio;
	
	// posicion
	public int posicionX;
	public int posicionY;
	
	
	public void recibirAtaque(int daño) {
		vida = vida- daño;
		
	}

	public void sanar(int sanacion) {
		vida = vida + sanacion;
	}
	public void atacar (Unidad unidad) {
		ataque.atacar(posicionX, posicionY, unidad);		
	}
	
	public void setPosicion( int x, int y) {
		posicionX = x;
		posicionY = y;
	}

	public void setDuenio(Jugador jugadorDuenio) {
		
		duenio = jugadorDuenio;
	}
	
	public int obtenerPosicionX() {
		return posicionX;
	}
	
	public int obtenerPosicionY() {
		return posicionY;
	}
	
	public int obtenerVida(){
		return vida;
	}
		
	private boolean movimientoValido(int nuevaPosicionX, int nuevaPosicionY) {
		
		 boolean movimientoValido = false;
		 int distanciaX = Math.abs(nuevaPosicionX - posicionX);
		 int distanciaY = Math.abs(nuevaPosicionY - posicionY);
		 
		 if (  ( (0 == distanciaX) || (distanciaX == 1) ) 
				 &&
			  (  (0 == distanciaY) || (distanciaY ==1))  ){
			 
			 
			 movimientoValido = true;
		 }
		 
		 return movimientoValido;

	}
	
	public boolean moverUnidadA(int nuevaPosicionX, int nuevaPosicionY) {
		
		boolean unidadMovida = false;
		
		if (this.movimientoValido(nuevaPosicionX, nuevaPosicionY) ){
			
			this.setPosicion(nuevaPosicionX, nuevaPosicionY);
			unidadMovida = true;
		}
		return unidadMovida;
	}
	

}
