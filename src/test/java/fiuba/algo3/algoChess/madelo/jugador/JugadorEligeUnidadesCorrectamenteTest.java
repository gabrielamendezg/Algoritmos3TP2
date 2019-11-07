package fiuba.algo3.algoChess.madelo.jugador;

import fiuba.algo3.algoChess.modelo.entidades.*;
import static org.junit.Assert.*;


import fiuba.algo3.algoChess.modelo.jugador.Jugador;
import org.junit.Test;

// Cambiar ENTIDAD por UNIDAD

public class JugadorEligeUnidadesCorrectamenteTest{
  
	Jugador jugador=new Jugador();
	Entidad unaUnidad;
	
	
	
	@Test
    public void deberiaSerVerdadero(){
        
		unaUnidad = jugador.elegirSoldado();
		assertTrue(unaUnidad instanceof SoldadoDeInfanteria);
		unaUnidad = jugador.elegirCatapulta();
		assertTrue(unaUnidad instanceof Catapulta);
		unaUnidad = jugador.elegirJinete();
		assertTrue(unaUnidad instanceof Jinete);
		unaUnidad = jugador.elegirCurandero();		
		assertTrue(unaUnidad instanceof Curandero);
		
    
    }


}
