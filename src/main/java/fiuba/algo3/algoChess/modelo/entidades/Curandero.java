package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.ataque.*;

public class Curandero extends Unidad{
	
	public Curandero() {
		vida = 75;
		ataque = new AtaqueDistanciaMedia(15);
		costo = 2;
	}
	
	@Override
	public void atacar(Unidad unidad) {
		ataque.sanar(posicionX, posicionY, unidad);
	}
}
