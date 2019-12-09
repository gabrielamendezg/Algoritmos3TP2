package fiuba.algo3.algoChess.vista;

import javafx.scene.layout.GridPane;

public class ImagenTablero extends GridPane {

	ImagenCelda[][] celdas = new ImagenCelda[20][20];
	public ImagenCelda seleccionado = null;
	private String colorJugadorA = "#8cb5bc";
	private String colorJugadorB = "#da6166";
	public ImagenTablero()
    {
        super();

        // initialize 20x20 array of spaces
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                celdas[x][y] = new ImagenCelda(x,y,colorJugadorA);
                this.add(celdas[x][y],x,y);
            }
        }
        
        for (int x = 10; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                celdas[x][y] = new ImagenCelda(x,y,colorJugadorB);
                this.add(celdas[x][y],x,y);
            }
        }
        
   }
	
}