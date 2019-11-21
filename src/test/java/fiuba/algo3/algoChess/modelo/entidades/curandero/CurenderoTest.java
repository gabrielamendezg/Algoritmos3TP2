package fiuba.algo3.algoChess.modelo.entidades.curandero;

import fiuba.algo3.algoChess.modelo.Excepciones.FilaOColumnaNoPerteneceATuParteDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CurenderoTest {
    @Test
    public void testCuranderoEsCorrectamenteCreada(){
    	JugadorA jugadora = new JugadorA();
    	assertNotNull(new Curandero(jugadora));
    }

    @Test
    void curanderoNoPuedeSerColocadoEnPosicionDelJugador2SiendoSuDuenioJugador1FilaOColumnaNoPerteneceATuParteDelTableroExcepcion() {
       JugadorA jugador = new JugadorA();
       Curandero curandero = new Curandero(jugador);
        Tablero tablero = new Tablero();
        assertThrows(FilaOColumnaNoPerteneceATuParteDelTableroExcepcion.class, ()->{
                    tablero.posicionarEn(jugador,curandero,new Posicion(11,1));
                }
        );
    }
}
