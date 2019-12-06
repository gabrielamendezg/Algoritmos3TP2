package fiuba.algo3.algoChess.vista;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class EntidadesPosicionable extends VBox {

    public EntidadesPosicionable(){
        Button catapultaAzul = new Button();
        Image imgCatapultaAzul = new Image("imagenes/CatapultaAzul.png",90,90,true,true);
        ImageView imgViewCatapultaAzul = new ImageView(imgCatapultaAzul);
        catapultaAzul.setGraphic(imgViewCatapultaAzul);
        catapultaAzul.setStyle("-fx-background-color: rgba(72,72,96,0.75)");
        catapultaAzul.setPrefSize(110, 110);
        catapultaAzul.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = catapultaAzul.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("imagenes/CatapultaAzul.png",30,30,true,true));
                db.setContent(content);

                event.consume();
            }
        });
        this.getChildren().addAll(catapultaAzul);

        Button curanderoAzul = new Button();
        curanderoAzul.setGraphic(new ImageView(new Image("imagenes/CuranderoAzul.png",90,90,true,true)));
        curanderoAzul.setStyle("-fx-background-color: rgba(72,72,96,0.75)");
        curanderoAzul.setPrefSize(110, 110);
        curanderoAzul.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = curanderoAzul.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("imagenes/CuranderoAzul.png",30,30,true,true));
                db.setContent(content);

                event.consume();
            }
        });
        this.getChildren().addAll(curanderoAzul);

        Button soldadoAzul = new Button();
        soldadoAzul.setGraphic(new ImageView(new Image("imagenes/SoldadoAzul.png",90,90,true,true)));
        soldadoAzul.setStyle("-fx-background-color: rgba(72,72,96,0.75)");
        soldadoAzul.setPrefSize(110, 110);
        soldadoAzul.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = soldadoAzul.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("imagenes/SoldadoAzul.png",30,30,true,true));
                db.setContent(content);

                event.consume();
            }
        });
        this.getChildren().addAll(soldadoAzul);


        Button jineteAzul = new Button();
        Image imgJineteAzul = new Image("imagenes/JineteAzul.png",90,90,true,true);
        ImageView imgViewJineteAzul = new ImageView(imgJineteAzul);
        jineteAzul.setGraphic(imgViewJineteAzul);
        jineteAzul.setStyle("-fx-background-color: rgba(72,72,96,0.75)");
        jineteAzul.setPrefSize(110, 110);
        jineteAzul.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = jineteAzul.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("imagenes/JineteAzul.png",30,30,true,true));
                db.setContent(content);

                event.consume();
            }
        });
        this.getChildren().addAll(jineteAzul);
    }

}
