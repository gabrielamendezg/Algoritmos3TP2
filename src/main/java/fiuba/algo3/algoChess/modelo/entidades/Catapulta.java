package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class Catapulta extends Unidad{
	
	public Catapulta(Jugador jugador) {
		
	
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
		this.setDuenio(jugador);
	}
	
	
}
