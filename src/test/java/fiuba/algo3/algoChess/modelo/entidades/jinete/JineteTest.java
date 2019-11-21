package fiuba.algo3.algoChess.modelo.entidades.jinete;

import fiuba.algo3.algoChess.modelo.Excepciones.NoEsTuUnidadExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Jinete;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import fiuba.algo3.algoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algoChess.modelo.jugador.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class JineteTest {
    @Test
    public void testJineteEsCorrectamenteCreado(){
        assertNotNull(new Jinete("elvis"));
    }

    @Test
    void curanderoNoPuedeSerColocadoEnPosicionOcupadaPorJinetePosicionOcupadaExcepcion() {
        Jugador jugador = new JugadorA("elvis");
        Curandero curandero = new Curandero(jugador.nombre());
        Jinete jinete = new Jinete(jugador.nombre());
        Tablero tablero = new Tablero();
        tablero.posicionarEn(jugador,jinete,new Posicion(1,1));
        assertThrows(PosicionOcupadaExcepcion.class, ()->{
            tablero.posicionarEn(jugador,curandero,new Posicion(1,1));
        }

        );
    }

    @Test
    void jineteNoPuedeSerColocarEnPosicionPorAlguienQueNoSeaSuDuenioNoEsTuUnidadExcepcion() {
        Jugador jugador = new JugadorA("elvis");
        Jinete jinete = new Jinete("hernan");
        Tablero tablero = new Tablero();
        assertThrows(NoEsTuUnidadExcepcion.class, ()->{
            tablero.posicionarEn(jugador,jinete,new Posicion(1,1));
                }
        );
    }
}
