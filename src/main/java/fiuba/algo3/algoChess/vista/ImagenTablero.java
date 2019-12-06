package fiuba.algo3.algoChess.vista;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
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

        celda.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                /* accept it only if it is not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != celda &&
                        event.getDragboard().hasImage()) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });

        celda.setOnDragEntered(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != celda &&
                        event.getDragboard().hasImage()) {
                    celda.setStyle("-fx-background-color: #372cbc; -fx-border-color: #515260;"
                            + " -fx-border-width: 1px");
                }

                event.consume();
            }
        });
        celda.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                celda.setStyle("-fx-background-color: #8cb5bc; -fx-border-color: #484860;"
                        + " -fx-border-width: 1px");

                event.consume();
            }
        });
        celda.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    celda.setGraphic(new ImageView(db.getImage()));
                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });
        //celda.setGraphic(new ImageView(new Image("imagenes/SoldadoAzul.png",30,30,true,true)));
        celda.setPrefHeight(35);
        celda.setPrefWidth(35);
		return celda;
	}
	
	private ImagenCelda inicializarEstiloCeldaRojo(int x, int y) {
		ImagenCelda celda = new ImagenCelda(x,y);
		celda.setStyle("-fx-background-color: #da6166; -fx-border-color: #484860;"
        		+ " -fx-border-width: 1px");
		celda.setPadding(Insets.EMPTY);
        //celda.setGraphic(new ImageView(new Image("imagenes/CatapultaRojo.png",30,30,true,true)));
        celda.setPrefHeight(35);
        celda.setPrefWidth(35);
		return celda;
	}
	
}