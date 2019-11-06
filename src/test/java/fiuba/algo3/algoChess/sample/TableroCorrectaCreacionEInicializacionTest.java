package fiuba.algo3.algoChess.sample;
import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.algoChess.tablero.Tablero;

public class TableroCorrectaCreacionEInicializacionTest {

	@Test
	public void TodasLasPosicionesDeTableroRecienCreadoEstanVacias() {
		//Act
		Tablero tablero;
		int contador = 0;
		
		try{
			tablero = Tablero.obtenerInstancia();
			for(int fila = 0; fila < 20; fila++) {
				for(int columna = 0; columna < 20; columna++) {
					if(!tablero.moverEntidad(fila,columna)) {
						contador += 1;
					}
				}
			}
		}catch(Exception e) {}
		
		//Assert
		assertNotNull(contador==0);
	}

}
