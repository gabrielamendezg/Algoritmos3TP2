package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.modelo.celda.CeldaA;
import fiuba.algo3.algoChess.modelo.celda.CeldaB;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;
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

        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                celdas[x][y] = new ImagenCelda(x,y,colorJugadorA);
                this.add(celdas[x][y],x,y);
            }
        }
        for(int x = 10; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                celdas[x][y] = new ImagenCelda(x,y,colorJugadorB);
                this.add(celdas[x][y],x,y);
            }
        }
   }

    public static ImagenTablero getImagenTablero() {
        return imagenTablero;
    }

    public void desseleccionarPosicion(int i, int i1) {
	    if(i < 10)
	        celdas[i][i1].setStyle("-fx-background-color: "+ colorJugadorA +"; -fx-border-color: #484860;"
                    + " -fx-border-width: 1px");
	    else celdas[i][i1].setStyle("-fx-background-color: "+ colorJugadorB +"; -fx-border-color: #484860;"
                + " -fx-border-width: 1px");
    }
}