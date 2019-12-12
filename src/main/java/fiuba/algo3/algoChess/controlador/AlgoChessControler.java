package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import javafx.scene.control.Label;
import fiuba.algo3.algoChess.modelo.entidades.Curandero;
import fiuba.algo3.algoChess.modelo.entidades.Unidad;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacante;
import fiuba.algo3.algoChess.vista.ImagenCelda;
import fiuba.algo3.algoChess.vista.ImagenTablero;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.scene.control.Tooltip;

import java.util.LinkedList;
import java.util.Random;

public class AlgoChessControler {
    private static AlgoChessControler algoChessControler = new AlgoChessControler();
    AlgoChess algoChess = AlgoChess.getAlgoChess();
    private Posicionable posicionable;
    private Label puntosLabel;
    private Posicionable unidad1 = null;
    private Posicionable unidad2 = null;
    private LinkedList <ImagenCelda> celdasConImagenes = new <ImagenCelda>LinkedList();

    private AlgoChessControler(){}
    public static AlgoChessControler getAlgoChessControler() {
        return algoChessControler;
    }

    public void posicionarPosicionable(int x, int y) {
        AlgoChess.getAlgoChess().posicionarPosicionable(posicionable,x + 1, y + 1);
    }

    public void pasarTurno() {
        this.deseleccionarUnidades();
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

    public void posicionXYSeleccionado(int x, int y) {
        if(unidad1 == null ) {
            if(algoChess.getJugadorActivo().obtenerUnidades().contains(algoChess.unidadDeLaPosicion(x + 1, y + 1)))
                unidad1 = algoChess.unidadDeLaPosicion(x + 1, y + 1);
            else throw new SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion();
        }else if(unidad2 == null) {
            unidad2 = algoChess.unidadDeLaPosicion(x + 1, y + 1);
        }else throw new NoSePuedeSeleccionarMasDeDosUnidadesExcepcion();
    }

    public void addCeldaConImagen(ImagenCelda celda) {
        celdasConImagenes.add(celda);
    }

    public void setOnActionCeldaConImagen() {
        celdasConImagenes.stream().forEach(celda -> celda.setOnAction(new CeldaControler(celda)));
        celdasConImagenes.stream().forEach(celda -> {
            final Tooltip tooltip = new Tooltip();
            tooltip.setText(
                    "PUNTOS DE VIDA" + "\n" +
                           algoChess.unidadDeLaPosicion(celda.getX() + 1, celda.getY() + 1) + "\n"
            );
            celda.setTooltip(tooltip);
        });
    }

    public void terminarDePosicionar() {
        AlgoChess.getAlgoChess().jugadorActivoRojo();
    }

    public void deseleccionarUnidades() {
        if(unidad1 != null){
            ImagenTablero.getImagenTablero().desseleccionarPosicion(unidad1.getPosicion().getX() -1, unidad1.getPosicion().getY() - 1);
            unidad1 = null;
        }
        if(unidad2 != null){
            ImagenTablero.getImagenTablero().desseleccionarPosicion(unidad2.getPosicion().getX() -1, unidad2.getPosicion().getY() - 1);
            unidad2 = null;
        }
    }

    public void primeraUnidadSeleccionadaAtacaSegundaUnida() {
        if((unidad1 != null) && (unidad2 != null)) {
            if (!algoChess.getJugadorActivo().obtenerUnidades().contains(unidad2)) {
                if (unidad1 instanceof Atacante){
                    algoChess.primeraUnidadSeleccionadaAtacaSegundaUnida((Atacante) unidad1, (Atacable) unidad2);
                    new Informar("Ataque recibido", "Puntos de vida restante\n" + unidad2.obtenerVida() + "\n");
                    this.deseleccionarUnidades();
                    return;
                } else throw new UnidadNoEsAtacanteExcepcion();
            } else throw new NoSePuedeAtacarUnidadPropiaExcepcion();
        } throw new SelecionaUnaUnidaMasParaAtacarExcepcion();
    }
}
