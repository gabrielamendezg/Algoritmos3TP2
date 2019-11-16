package fiuba.algo3.algoChess.modelo.jugador;


import fiuba.algo3.algoChess.modelo.Excepciones.JugadorSinPuntosSuficientesException;
import fiuba.algo3.algoChess.modelo.entidades.*;



public class SelectorDeUnidades {
	
	Unidad unidad;
	final int puntosParaSoldado=1;
	final int puntosParaCatapulta=5;
	final int puntosParaJinete = 3;
	final int puntosParaCurandero = 2;
	
	SelectorDeUnidades() {
		
		unidad=null;
	}

	public Unidad elegirSoldado(Jugador jugador) {
		
		if (jugador.getPuntos()>=puntosParaSoldado) {
		unidad = new SoldadoDeInfanteria(jugador);
		jugador.restarPuntos(puntosParaSoldado);
		}else{
			throw new JugadorSinPuntosSuficientesException();
			
		}
		
		return unidad;
	}

	public Unidad elegirCatapulta(Jugador jugador) {
		// TODO Auto-generated method stub
		
		
		if (jugador.getPuntos()>=puntosParaCatapulta){
		unidad = new Catapulta(jugador);
		jugador.restarPuntos(puntosParaCatapulta);
		}else {
			throw new JugadorSinPuntosSuficientesException();
		}
		return unidad;
	}

	public Unidad elegirJinete(Jugador jugador) {
		// TODO Auto-generated method stub
		
		
		if (jugador.getPuntos()>=puntosParaJinete) {
		unidad = new Jinete(jugador);
		jugador.restarPuntos(puntosParaJinete);
		}else {
			
			throw new JugadorSinPuntosSuficientesException();
		}
		
		return unidad;
	}

	public Unidad elegirCurandero(Jugador jugador) {
		// TODO Auto-generated method stub
		
		
		if (jugador.getPuntos()>=puntosParaCurandero) {
		unidad = new Curandero(jugador);
		jugador.restarPuntos(puntosParaCurandero);
		}else {
			
			throw new JugadorSinPuntosSuficientesException();
		}
		
		return unidad;
	}
	
	

}
