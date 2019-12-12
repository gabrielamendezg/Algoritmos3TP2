package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import javafx.scene.control.Label;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacante;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.vista.ImagenCelda;
import fiuba.algo3.algoChess.vista.ImagenTablero;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.scene.control.Tooltip;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class AlgoChessControler implements Observador {
    private static AlgoChessControler algoChessControler = new AlgoChessControler();
    AlgoChess algoChess = AlgoChess.getAlgoChess();
    private Posicionable posicionable;
    private Label puntosLabel;
    private Posicionable unidad1 = null;
    private Posicionable unidad2 = null;
    private LinkedList <ImagenCelda> celdasConImagenes = new LinkedList<ImagenCelda>();
    private boolean turnoCompletado = false;
    private boolean movimientoCompletado = false;
    private ArrayList <Posicionable> posicionablesAzules = new ArrayList<>();
    private ArrayList <Posicionable> posicionablesRojos = new ArrayList<>();

    private AlgoChessControler(){}
    public static AlgoChessControler getAlgoChessControler() {
        return algoChessControler;
    }

    public void posicionarPosicionable(int x, int y) {
        AlgoChess.getAlgoChess().posicionarPosicionable(posicionable,x + 1, y + 1);
        if (algoChess.getJugadorActivo() instanceof JugadorA)
            posicionablesAzules.add(posicionable);
        else posicionablesRojos.add(posicionable);
        posicionable.addObserver(this);
    }

    public void pasarTurno() {
        this.deseleccionarUnidades();
        AlgoChess.getAlgoChess().pasarTurno();
        turnoCompletado = false;
        movimientoCompletado = false;
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
                            Integer.toString(algoChess.unidadDeLaPosicion(celda.getX() + 1, celda.getY() + 1).obtenerVida()));
            celda.setTooltip(tooltip);
        });
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
                    if (!turnoCompletado()){
                        algoChess.primeraUnidadSeleccionadaAtacaSegundaUnida((Atacante) unidad1, (Atacable) unidad2);
                        celdasConImagenes.stream().forEach(celda -> {
                            final Tooltip tooltip = new Tooltip();
                            Posicionable unidadPosicionada = algoChess.unidadDeLaPosicion(celda.getX() + 1, celda.getY() + 1);
                            if(unidadPosicionada != null) {
                                tooltip.setText(
                                        "PUNTOS DE VIDA" + "\n" +
                                                Integer.toString(unidadPosicionada.obtenerVida()));
                                celda.setTooltip(tooltip);
                            }
                        });
                        new Informar("Ataque recibido", "Puntos de vida restante\n" + unidad2.obtenerVida() + "\n");
                        this.completarTurno();
                        this.deseleccionarUnidades();
                        return;
                    }else throw new YaCompletasteTuTurnoExcecion();
                } else throw new UnidadNoEsAtacanteExcepcion();
            } else throw new NoSePuedeAtacarUnidadPropiaExcepcion();
        } throw new SelecionaUnaUnidaMasParaAtacarExcepcion();
    }

    private void completarTurno() {
        turnoCompletado = true;
    }

    private boolean turnoCompletado() {
        return turnoCompletado;
    }
    
    private void completarMovimiento() {
    	movimientoCompletado = true;
    }
    @Override
    public void change() {

    }
    
    public void moverUnidad(Direccion direccion) {
    	if((unidad1 != null)) {
    		if(unidad2 == null) {
        		if(algoChess.getJugadorActivo().obtenerUnidades().contains(unidad1)) {
        			if(unidad1 instanceof Movible) {
        				if(!movimientoCompletado) {
        					this.deseleccionarUnidades();
        					direccion.moverUnidad(algoChess,(Movible) unidad1);
        					this.completarMovimiento();
        				}else throw new UnMovimientoPorTurnoExcepcion();
        			} else throw new UnidadNoEsMovibleExcepcion();
        		}else throw new SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion();
    		}else throw new SoloSePuedeMoverUnaUnidadExcepcion();
    	}else throw new NoHayNingunaUnidadSeleccionadaExcepcion();
    }
    
    
}
