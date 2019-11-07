package fiuba.algo3.algoChess.modelo.entidades;
import fiuba.algo3.algoChess.modelo.ataque.*;

public class Catapulta extends Unidad{
	
	public Catapulta() {
		
	
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
	
	
}
