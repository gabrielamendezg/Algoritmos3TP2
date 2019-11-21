package fiuba.algo3.algoChess.modelo.entidades.jinete;

import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JineteTest {
    @Test
    public void testJineteEsCorrectamenteCreado(){
    	JugadorA jugador = new JugadorA();
    	assertNotNull(new Jinete(jugador));
    }

    @Test
    void curanderoNoPuedeSerColocadoEnPosicionOcupadaPorJinetePosicionOcupadaExcepcion() {
        JugadorA jugador = new JugadorA();
        Curandero curandero = new Curandero(jugador);
        Jinete jinete = new Jinete(jugador);
        Tablero tablero = new Tablero();
        tablero.posicionarEn(jugador,jinete,new Posicion(1,1));
        assertThrows(PosicionOcupadaExcepcion.class, ()->{
            tablero.posicionarEn(jugador,curandero,new Posicion(1,1));
        }

        );
    }

    @Test
    void jineteNoPuedeSerColocarEnPosicionPorAlguienQueNoSeaSuDuenioNoEsTuUnidadExcepcion() {
        JugadorA jugador = new JugadorA();
        JugadorB jugadorb = new JugadorB();
        Jinete jinete = new Jinete(jugadorb);
        Tablero tablero = new Tablero();
        assertThrows(NoEsTuUnidadExcepcion.class, ()->{
            tablero.posicionarEn(jugador,jinete,new Posicion(1,1));
                }
        );
    }
}
