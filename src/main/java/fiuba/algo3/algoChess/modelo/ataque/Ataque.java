package fiuba.algo3.algoChess.modelo.ataque;

import fiuba.algo3.algoChess.modelo.entidades.*;

public abstract class Ataque {

	 protected int rangoInicial;
	 protected int rangoFinal;
	 
	 protected int ataque;
	 
	 public boolean estaEnRango( int posicionXUnidadAtacante, int posicionYUnidadAtacante,  Unidad unidadAtacada) {
		 
		 boolean estaEnRango = false;

		 return estaEnRango;
	 }
	 
	 public void atacar( int posicionXUnidadAtacante, int posicionYUnidadAtacante,  Unidad unidadAtacada) {
	 
	 
		 if ( this.estaEnRango(posicionXUnidadAtacante, posicionYUnidadAtacante, unidadAtacada)){
		 
			 unidadAtacada.recibirAtaque(ataque);
		 }
	 }
	 public void sanar( int posicionXUnidadAtacante, int posicionYUnidadAtacante,  Unidad unidadAtacada) {
		 
		 
		 if ( this.estaEnRango(posicionXUnidadAtacante, posicionYUnidadAtacante, unidadAtacada)){
		 
			 unidadAtacada.sanar(ataque);
		 }
	 }
}
