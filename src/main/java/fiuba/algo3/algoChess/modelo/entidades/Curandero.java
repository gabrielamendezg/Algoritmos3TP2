package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.jugador.*;

public class Curandero extends Unidad{
	
	public Curandero(Jugador jugador) {
		vida = 75;
		ataque = new AtaqueDistanciaMedia(15);
		costo = 2;
		this.setDuenio(jugador);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		ataque.sanar(posicionX, posicionY, unidad);
	}
}
