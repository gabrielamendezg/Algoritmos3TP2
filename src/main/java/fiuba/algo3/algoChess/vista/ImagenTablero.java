package fiuba.algo3.algoChess.vista;

import javafx.scene.layout.GridPane;

public class ImagenTablero extends GridPane {

	ImagenCelda[][] celdas = new ImagenCelda[20][20];
	public ImagenCelda seleccionado = null;
	
	public ImagenTablero()
    {
        super();

        // initialize 20x20 array of spaces
        for (int x = 0; x < celdas[0].length; x++)
        {
            for (int y = 0; y < celdas[1].length; y++)
            {
                ImagenCelda celda = new ImagenCelda(x,y);
                celda.setStyle("-fx-background-color: #90c0c0; -fx-border-color: #d8f0d8;"
                		+ " -fx-border-width: 1px");
                //celda.setStyle("");
                celda.setPrefHeight(30);
                celda.setPrefWidth(30);
                celdas[x][y] = celda;
                this.add(celdas[x][y],x,y);
            }
        }
   }
}

