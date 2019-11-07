package fiuba.algo3.algoChess.modelo.entidades;

public class Unidad {
	protected int ataque;
	public int vida;
	
	// posicion
	public int x;
	public int y;
	
	
	public void recibirAtaque(int daño) {
		vida = vida- daño;
		
	}
	
	public void atacar (Unidad unidad) {
		unidad.recibirAtaque(ataque);
		
	}


}
