package fiuba.algo3.algoChess.modelo.entidades.curandero;

import fiuba.algo3.algoChess.modelo.Excepciones.FilaOColumnaNoPerteneceATuParteDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class CurenderoTest {
    @Test
    public void testCuranderoEsCorrectamenteCreada(){
    	assertNotNull(new Curandero(""));
    }

    @Test
    void curanderoNoPuedeSerColocadoEnPosicionDelJugador2SiendoSuDuenioJugador1FilaOColumnaNoPerteneceATuParteDelTableroExcepcion() {
        Jugador jugador = new JugadorA("elvis");
       Curandero curandero = new Curandero(jugador.nombre());
        Tablero tablero = new Tablero();
        assertThrows(FilaOColumnaNoPerteneceATuParteDelTableroExcepcion.class, ()->{
                    tablero.posicionarEn(jugador,curandero,new Posicion(11,1));
                }
        );
    }
}
