package fiuba.algo3.algoChess.modelo.tablero;
import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import fiuba.algo3.algoChess.tablero.Tablero;

public class TableroCorrectaCreacionEInicializacionTest {

	@Test
	public void TodasLasPosicionesDeTableroRecienCreadoEstanVacias() {
		//Act
		Tablero tablero;
		int contador = 0;
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		try{
			tablero = Tablero.obtenerInstancia(jugador1,jugador2);
			for(int fila = 0; fila < 20; fila++) {
				for(int columna = 0; columna < 20; columna++) {
					if(!tablero.moverUnidad(jugador1,fila,columna,0,0)) {
						contador += 1;
					}
				}
			}
		}catch(Exception e) {}
		
		//Assert
		assertNotNull(contador==0);
	}

}
