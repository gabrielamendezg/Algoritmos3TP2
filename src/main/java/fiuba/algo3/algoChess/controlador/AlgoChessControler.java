package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.Direccion.Direccion;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.vista.Ganaste;
import fiuba.algo3.algoChess.vista.imagenes.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.*;
import fiuba.algo3.algoChess.vista.*;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.File;
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
            if (unidad2 == unidad1) {
                unidad2 = null;
                throw new NoPuedesSeleccionaLaMismaUnidaDosVecesExcepcion();
            }
        }else throw new NoSePuedeSeleccionarMasDeDosUnidadesExcepcion();
    }

    public void addCeldaConImagen(ImagenCelda celda) {
        celdasConImagenes.add(celda);
    }

    public void setOnActionCeldaConImagen() {
        celdasConImagenes.stream().forEach(celda -> celda.setOnAction(new CeldaControler(celda)));
        actualizarTooltip();
    }

    public void deseleccionarUnidades() {
        if(unidad1 != null || unidad2 != null){
            ImagenTablero.getImagenTablero().colorPorDectoTablero();
            unidad1 = null;
            unidad2 = null;
        }

    }

    public void primeraUnidadSeleccionadaAtacaSegundaUnida() {
        if((unidad1 != null) && (unidad2 != null)) {
            if (!algoChess.getJugadorActivo().obtenerUnidades().contains(unidad2)) {
                if (unidad1 instanceof Atacante){
                    if (!turnoCompletado()){
                        algoChess.primeraUnidadSeleccionadaAtacaSegundaUnida((Atacante) unidad1, (Atacable) unidad2);
                        if (unidad2 !=null)
                            new Informar("Ataque recibido", "Puntos de vida restante\n" + unidad2.obtenerVida() + "\n","src/main/resources/sonidos/impacto.wav");
                        this.completarTurno();
                        this.actualizarTodo();
                        actualizarTooltip();
                        this.determininarSiHayGanador();
                        return;
                    }else throw new YaCompletasteTuTurnoExcecion();
                } else throw new UnidadNoEsAtacanteExcepcion();
            } else throw new NoSePuedeAtacarUnidadPropiaExcepcion();
        } throw new SelecionaUnaUnidaMasParaAtacarExcepcion();
    }

    private void actualizarTooltip() {
        celdasConImagenes.stream().forEach(celda -> {
            Tooltip tooltip = new Tooltip();
            Posicionable unidadPosicionada = algoChess.unidadDeLaPosicion(celda.getX() + 1, celda.getY() + 1);
            if(unidadPosicionada != null) {
                tooltip.setText(
                        "PUNTOS DE VIDA" + "\n" +
                                String.valueOf(unidadPosicionada.obtenerVida()));
                celda.setTooltip(tooltip);
            }
        });
    }

    public void determininarSiHayGanador() {
        if (algoChess.hayGanador()) {
            Jugador ganador = algoChess.obtenerGanador();
            if (ganador instanceof JugadorA){
                new Ganaste((JugadorA) ganador);
                Platform.exit();
            }else {
                new Ganaste((JugadorB) ganador);
                Platform.exit();
            }
        }
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
       this.actualizarTodo();
    }

    public void actualizarTodo() {
        this.deseleccionarUnidades();

        //elimino del modelo
        algoChess.eliminarUnidadesMuertasDelTabler();
        algoChess.eliminarUnidadesMuertasDeLosJugadores();

        //se elimina unidades muertas
        ArrayList<Posicionable> unidadConVidaCeroAzules = new ArrayList<>();
        posicionablesAzules.stream().forEach(unidadPosicionado -> {
            if(unidadPosicionado != null &&  unidadPosicionado.obtenerVida() <= 0)
                unidadConVidaCeroAzules.add(unidadPosicionado);
        });

        unidadConVidaCeroAzules.stream().forEach(unidadMuerta -> {
            try {

                if (EscenaTablero.getEscenaTablero() != null) {
                    if (unidadMuerta != null) {
                        Notifications.create()
                                .darkStyle()
                                .hideAfter(Duration.seconds(5))
                                .position(Pos.CENTER)
                                .title("Murio ;( tu unidad")
                                .text(EscenaTablero.getEscenaTablero().getNombreJugadorAzul() + " MURIO tu " + this.nombredeUnidad(unidadMuerta))
                                .showInformation();
                    }
                }
            } catch (Exception e) {}
            Media sound = new Media(new File("src/main/resources/sonidos/Shutdown.wav").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

            posicionablesAzules.remove(unidadMuerta);
        });

        ArrayList<Posicionable> unidadConVidaCeroRojas = new ArrayList<>();
        posicionablesRojos.stream().forEach(unidadPosicionado -> {
            if(unidadPosicionado != null && unidadPosicionado.obtenerVida() <= 0)
                unidadConVidaCeroRojas.add(unidadPosicionado);
        });
        unidadConVidaCeroRojas.stream().forEach(unidadMuerta -> {
            try {
                if (EscenaTablero.getEscenaTablero() != null) {
                    if (unidadMuerta != null) {
                        Notifications.create()
                                .hideAfter(Duration.seconds(5))
                                .position(Pos.CENTER)
                                .title("Murio ;( tu unidad")
                                .text(EscenaTablero.getEscenaTablero().getNombreJugadorRojo() + " MURIO tu " + this.nombredeUnidad(unidadMuerta))
                                .showInformation();
                    }
                }
            } catch (Exception e) {}
            Media sound = new Media(new File("src/main/resources/sonidos/Shutdown.wav").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            posicionablesRojos.remove(unidadMuerta);
        });

        celdasConImagenes.stream().forEach(celda -> {
            celda.setGraphic(null);
            celda.setTooltip(null);
        });

        //elinmo las celdad viejas
        celdasConImagenes = new LinkedList<ImagenCelda>();

        //Mostrar imagenes De los sobrevivientes y de los que se movieron
        this.mostrarImagenDeLosPosicionables();
        this.setOnActionCeldaConImagen();
        this.determininarSiHayGanador();
    }

    private String nombredeUnidad(Posicionable unidad) {
        if(unidad instanceof Curandero)
            return "CuranderoRojo";
        if(unidad instanceof Catapulta)
            return "Catapulta";
        if(unidad instanceof Jinete)
            return "Jinete";
        if(unidad instanceof SoldadoDeInfanteria)
            return "Soldado";
        return null;
    }

    public void moverUnidad(Direccion direccion) {
    	if((unidad1 != null)) {
    		if(unidad2 == null) {
        		if(algoChess.getJugadorActivo().obtenerUnidades().contains(unidad1)) {
        			if(unidad1 instanceof Movible) {
        				if(!movimientoCompletado) {
        					direccion.moverUnidad(algoChess,(Movible) unidad1);
        					this.completarMovimiento();
                            this.actualizarTooltip();
        					return;
        				}else throw new UnMovimientoPorTurnoExcepcion();
        			} else throw new UnidadNoEsMovibleExcepcion();
        		}else throw new SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion();
    		}else throw new SoloSePuedeMoverUnaUnidadExcepcion();
    	}else throw new NoHayNingunaUnidadSeleccionadaExcepcion();
    }
    
    private void mostrarImagenDeLosPosicionables() {
        posicionablesRojos.stream().forEach(unidadPosicionado -> {
            ImagenTablero.getImagenTablero().colocarImagenEnLaPosicion(this.imagenDePosicionableRojo(unidadPosicionado),unidadPosicionado.getPosicion().getX() - 1, unidadPosicionado.getPosicion().getY() - 1);
        });

        posicionablesAzules.stream().forEach(unidadPosicionado -> {
            ImagenTablero.getImagenTablero().colocarImagenEnLaPosicion(this.imagenDePosicionableAzul(unidadPosicionado),unidadPosicionado.getPosicion().getX() - 1, unidadPosicionado.getPosicion().getY() - 1);
        });
        actualizarTooltip();
    }

    private Image imagenDePosicionableRojo(Posicionable unidadPosicionado) {
        if(unidadPosicionado instanceof Curandero)
            return new ImageCurandero("imagenes/CuranderoRojo.png",30,30,true,true);
        if(unidadPosicionado instanceof Catapulta)
            return new ImageCatapulta("imagenes/CatapultaRojo.png",30,30,true,true);
        if(unidadPosicionado instanceof Jinete)
            return new ImageJinete("imagenes/JineteRojo.png",30,30,true,true);
        if(unidadPosicionado instanceof SoldadoDeInfanteria)
            return new ImageSoldadoDeInfanteria("imagenes/SoldadoRojo.png",30,30,true,true);
        return null;
    }

    private Image imagenDePosicionableAzul(Posicionable unidadPosicionado) {
        if(unidadPosicionado instanceof Curandero)
            return new ImageCurandero("imagenes/CuranderoAzul.png",30,30,true,true);
        if(unidadPosicionado instanceof Catapulta)
            return new ImageCatapulta("imagenes/CatapultaAzul.png",30,30,true,true);
        if(unidadPosicionado instanceof Jinete)
            return new ImageJinete("imagenes/JineteAzul.png",30,30,true,true);
        if(unidadPosicionado instanceof SoldadoDeInfanteria)
            return new ImageSoldadoDeInfanteria("imagenes/SoldadoAzul.png",30,30,true,true);
        return null;
    }
    
	public void primeraUnidadSeleccionadaCuraSegundaUnidad() throws Exception {
        if((unidad1 != null) && (unidad2 != null)) {
            if (algoChess.getJugadorActivo().obtenerUnidades().contains(unidad2)) {
                if (unidad1 instanceof Sanador){
                	if(unidad2 instanceof Sanable) {
                		if (!turnoCompletado()){
                			algoChess.primeraUnidadSeleccionadaCuraSegundaUnidad((Sanador) unidad1, (Sanable) unidad2);
                			celdasConImagenes.stream().forEach(celda -> {
                				final Tooltip tooltip = new Tooltip();
                				Posicionable unidadPosicionada = algoChess.unidadDeLaPosicion(celda.getX() + 1, celda.getY() + 1);
                				if(unidadPosicionada != null) {
                					tooltip.setText(
                							"PUNTOS DE VIDA" + "\n" + String.valueOf(unidadPosicionada.obtenerVida()));
                					celda.setTooltip(tooltip);
                				}
                			});
                			new Informar("Curación recibida", "Puntos de vida restante\n" + unidad2.obtenerVida() + "\n","src/main/resources/sonidos/guitar.wav");
                            this.completarTurno();
                            this.actualizarTodo();
                            actualizarTooltip();
                            this.determininarSiHayGanador();
                			return;
                    	}else throw new YaCompletasteTuTurnoExcecion();
                    }else throw new UnidadNoEsSanableExcepcion();
                } else throw new UnidadNoEsSanadorExcepcion();
            } else throw new NoSePuedeCurarUnidadEnemigaExcepcion();
        } throw new SelecionaUnaUnidaMasParaAtacarExcepcion();		
	}

    public void posicionableDePosicionRecibeAtaque(int x, int y) {
        ImagenTablero.getImagenTablero().efectoAtaqueEnLaCelda(x - 1, y - 1);
    }
}
