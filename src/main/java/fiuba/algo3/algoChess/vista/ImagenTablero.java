package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.modelo.celda.CeldaA;
import fiuba.algo3.algoChess.modelo.celda.CeldaB;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ImagenTablero extends GridPane {

	ImagenCelda[][] celdas = new ImagenCelda[20][20];
	private static ImagenTablero imagenTablero = new ImagenTablero();
	public ImagenCelda seleccionado = null;
	private String colorJugadorA = "#8cb5bc";
	private String colorJugadorB = "#da6166";
	
	private ImagenTablero()
    {
        super();

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

    public void desseleccionarPosicion(int x, int y) {
	    if(x < 10)
	        celdas[x][y].setStyle("-fx-background-color: "+ colorJugadorA +"; -fx-border-color: #484860;"
                    + " -fx-border-width: 1px");
	    else celdas[x][y].setStyle("-fx-background-color: "+ colorJugadorB +"; -fx-border-color: #484860;"
                + " -fx-border-width: 1px");
    }


    public void colocarImagenEnLaPosicion(Image image, int x, int y) {
        celdas[x][y].setGraphic(new ImageView(image));
        AlgoChessControler.getAlgoChessControler().addCeldaConImagen(celdas[x][y]);
    }
}