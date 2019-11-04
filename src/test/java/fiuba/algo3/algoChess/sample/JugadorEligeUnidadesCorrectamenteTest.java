package fiuba.algo3.algoChess.sample;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class JugadorEligeUnidadesCorrectamenteTest{
  
	Jugador jugador= new Jugador();
	ArrayList<String> listaNueva = new ArrayList<String>();
	
	
	
	@Test
    public void deberiaSerVerdadero(){
        
		jugador.elegirSoldado();
		jugador.elegirCatapulta();
		jugador.elegirJinete();
		jugador.elegirCurandero();		
		listaNueva.add("Soldado");
		listaNueva.add("Catapulta");
		listaNueva.add("Jinete");
		listaNueva.add("Curandero");
		
		assertEquals(listaNueva, jugador.obtenerUnidades());
    
    }


}
