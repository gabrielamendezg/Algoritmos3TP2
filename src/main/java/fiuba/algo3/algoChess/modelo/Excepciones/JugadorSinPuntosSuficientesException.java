package fiuba.algo3.algoChess.modelo.Excepciones;

@SuppressWarnings("serial")
public class JugadorSinPuntosSuficientesException extends RuntimeException{
	
	public JugadorSinPuntosSuficientesException() {
		
		super ("Jugador no tiene puntos suficientes");
		
	}
	
	

}
