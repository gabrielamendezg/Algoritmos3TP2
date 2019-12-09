package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.vista.ImagenCelda;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;

public class DragClase{

    static String styleDefaul;

    AlgoChess algoChess = AlgoChess.getAlgoChess();

    public EventHandler<DragEvent> getDragOver(ImagenCelda celda){
        return new EventHandler<DragEvent>() {
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
        };
    }

    public EventHandler<DragEvent> getDragEntered(ImagenCelda celda){
        return new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != celda &&
                        event.getDragboard().hasImage()) {
                    styleDefaul = celda.getStyle();
                    celda.setStyle("-fx-background-color: #f2fcf2; -fx-border-color: #515260;"
                            + " -fx-border-width: 1px");
                }

                event.consume();
            }
        };
    }

    public EventHandler<DragEvent> getDragExited(ImagenCelda celda){
        return new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                celda.setStyle(styleDefaul);

                event.consume();
            }
        };
    }

    public EventHandler<DragEvent> getDragDropped(ImagenCelda celda){
        return new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {

                    ImageView imageView =new ImageView(db.getImage());
                    imageView.setFitHeight(30);
                    imageView.setFitWidth(30);
                    celda.setGraphic(imageView);
                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        };
    }
}
