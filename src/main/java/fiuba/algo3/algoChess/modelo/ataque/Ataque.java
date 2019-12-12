package fiuba.algo3.algoChess.modelo.ataque;

import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;

public abstract class Ataque {

	 protected int rangoInicial;
	 protected int rangoFinal;
	 
	 protected int ataque;
	 
	 public boolean estaEnRango( int posicionXUnidadAtacante, int posicionYUnidadAtacante,  Atacable unidadAtacada) {

		  int distanciaX = Math.abs((unidadAtacada.getPosicion().getX()) - posicionXUnidadAtacante);
		 int distanciaY = Math.abs((unidadAtacada.getPosicion().getY()) - posicionYUnidadAtacante);

		 if(distanciaY <= rangoInicial) {
			 if ((rangoInicial <= distanciaX) && (distanciaX <= rangoFinal)) return true;
		 }else if (distanciaX <= rangoInicial){
		 	if ((rangoInicial <= distanciaY) && (distanciaY <= rangoFinal)) return true;
		 }else if (((rangoInicial <= distanciaX) && (distanciaX <= rangoFinal) ) && ((rangoInicial <= distanciaY) && (distanciaY <= rangoFinal))){
			return true;
		 }

		 return false;
	 }
	 
	 public void atacar( int posicionXUnidadAtacante, int posicionYUnidadAtacante,  Atacable unidadAtacada) {
	 
	 
		 if ( this.estaEnRango(posicionXUnidadAtacante, posicionYUnidadAtacante, unidadAtacada)){
		 
			 unidadAtacada.recibirAtaque(ataque);
			 return;
		 }
		 throw new FueraDelRangoDeAtaqueExcepcion();
	 }

}
