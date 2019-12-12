package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import javafx.scene.control.Label;

import java.util.Random;

public class AlgoChessControler {
    private static AlgoChessControler algoChessControler = new AlgoChessControler();
    AlgoChess algoChess = AlgoChess.getAlgoChess();
    private Posicionable posicionable;
    private Label puntosLabel;

    private AlgoChessControler(){}
    public static AlgoChessControler getAlgoChessControler() {
        return algoChessControler;
    }

    public void posicionarPosicionable(int x, int y) {
        AlgoChess.getAlgoChess().posicionarPosicionable(posicionable,x + 1, y + 1);
    }

    public void pasarTurno() {
        AlgoChess.getAlgoChess().pasarTurno();
    }

    public void posicionableCataputaEnEspera() {
        posicionable = algoChess.getJugadorActivo().elegirCatapulta();
        
    }
    public void posicionableJineteEnEspera() {
        posicionable = algoChess.getJugadorActivo().elegirJinete();
    }

    public void posicionableSoldadoDeInfanteriaEnEspera() {
        posicionable = algoChess.getJugadorActivo().elegirSoldado();
    }

    public void posicionableCuranderoEnEspera() {
        posicionable = algoChess.getJugadorActivo().elegirCurandero();
    }

    public boolean turnoAleatorio() {
        Random rd = new Random();
        boolean turno = rd.nextBoolean();
        if(turno){
            algoChess.jugadorActivoAzul();
            return turno;
        }else {
            algoChess.jugadorActivoRojo();
            return turno;
        }
    }
    
    public int getPuntosJugadorActivo() {
    	return algoChess.getJugadorActivo().getPuntos();
    }
    
	public void setLabelPuntos(Label puntosJugadorActivo) {
		puntosLabel = puntosJugadorActivo;
	}
	public void actualizarPuntos() {
		puntosLabel.setText("Puntos: "+ Integer.toString(AlgoChessControler.getAlgoChessControler().getPuntosJugadorActivo()));
	}
}
