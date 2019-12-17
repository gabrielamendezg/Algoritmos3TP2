package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.controlador.DragClase;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class ImagenTablero extends GridPane {

	ImagenCelda[][] celdas = new ImagenCelda[20][20];
	private static ImagenTablero imagenTablero = new ImagenTablero();
	public ImagenCelda seleccionado = null;
	private String colorJugadorA = "#8cb5bc";
	private String colorJugadorB = "#da6166";
    private Image explosion;
    Media soundExplosion;

    private ImagenTablero()
    {
        super();
        soundExplosion = new Media(new File("src/main/resources/sonidos/impacto.wav").toURI().toString());
        explosion = new Image("animaciones/explosion.gif", 30, 30, true, true);
        int aux = 0;
        for(int y = 19; 0 <= y ; y--) {
            for (int x = 0; x < 10; x++) {
                celdas[x][aux] = new ImagenCelda(x,aux,colorJugadorA);
                this.add(celdas[x][aux],x,y);

            }
            aux++;
        }

        aux = 0;
        for(int y = 19; 0 <= y ; y--) {
            for (int x = 10; x < 20; x++) {
                celdas[x][aux] = new ImagenCelda(x,aux,colorJugadorB);
                this.add(celdas[x][aux],x,y);

            }
            aux++;
        }
   }

    public static ImagenTablero getImagenTablero() {
        return imagenTablero;
    }

    public void colorPorDectoTablero() {

        for(int y = 0; y < 20 ; y++) {
            for (int x = 0; x < 20; x++) {
                celdas[x][y].colorPorDefecto();
            }
        }
    }


    public void colocarImagenEnLaPosicion(Image image, int x, int y) {
        celdas[x][y].setGraphic(new ImageView(image));
        AlgoChessControler.getAlgoChessControler().addCeldaConImagen(celdas[x][y]);
    }

    public void desactivarDragAndDrop() {
        for(int y = 0; y < 20 ; y++) {
            for (int x = 0; x < 20; x++) {
                celdas[x][y].setOnDragOver(null);
                celdas[x][y].setOnDragEntered(null);
                celdas[x][y].setOnDragExited(null);
                celdas[x][y].setOnDragDropped(null);

            }
        }
    }

    public void efectoAtaqueEnLaCelda(int x, int y) {

        celdas[x][y].setGraphic(null);
        celdas[x][y].setGraphic(new ImageView(explosion));
        MediaPlayer mediaPlayer = new MediaPlayer(soundExplosion);
        mediaPlayer.play();

	}
}