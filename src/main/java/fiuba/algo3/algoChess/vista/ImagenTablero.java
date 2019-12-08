package fiuba.algo3.algoChess.vista;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ImagenTablero extends GridPane {

	ImagenCelda[][] celdas = new ImagenCelda[20][20];
	public ImagenCelda seleccionado = null;
	
	public ImagenTablero()
    {
        super();

        // initialize 20x20 array of spaces
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                celdas[x][y] = inicializarEstiloCeldaAzul(x,y);
                this.add(celdas[x][y],x,y);
            }
        }
        
        for (int x = 10; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                celdas[x][y] = inicializarEstiloCeldaRojo(x,y);
                this.add(celdas[x][y],x,y);
            }
        }
        
   }
	
	private ImagenCelda inicializarEstiloCeldaAzul(int x, int y) {
		ImagenCelda celda = new ImagenCelda(x,y);
		celda.setStyle("-fx-background-color: #8cb5bc; -fx-border-color: #484860;"
        		+ " -fx-border-width: 1px");
		celda.setPadding(Insets.EMPTY);
        //celda.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/SoldadoAzul.png").toExternalForm(),30,30,true,true)));
        celda.setPrefHeight(35);
        celda.setPrefWidth(35);
		return celda;
	}
	
	private ImagenCelda inicializarEstiloCeldaRojo(int x, int y) {
		ImagenCelda celda = new ImagenCelda(x,y);
		celda.setStyle("-fx-background-color: #da6166; -fx-border-color: #484860;"
        		+ " -fx-border-width: 1px");
		celda.setPadding(Insets.EMPTY);
        celda.setGraphic(new ImageView(new Image("imagenes/CatapultaRojo.png",30,30,true,true)));
        celda.setPrefHeight(35);
        celda.setPrefWidth(35);
		return celda;
	}
	
}