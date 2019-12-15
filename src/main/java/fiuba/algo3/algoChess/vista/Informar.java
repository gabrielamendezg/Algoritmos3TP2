package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.media.*;

import java.io.File;

public class Informar {
    public Informar(String titulo, String mensaje) {
    	
    	Label info = new Label(mensaje);
    	info.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30");
    	
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        
        DialogPane cuadro = alert.getDialogPane();
        cuadro.setStyle("-fx-background-color: #484860;");
        alert.getDialogPane().setContent(info);

               
        Button ok = (Button) cuadro.lookupButton(ButtonType.OK);
        ok.setStyle("-fx-padding: 8 15 15 15;"+
	    "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;"+
	    "-fx-background-radius: 8;"+
	    "-fx-background-color: #39516d , #6886aa;"+
	    "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );"+
	    "-fx-text-fill: #ffffff;"+
	    "-fx-font-weight: bold;"+
	    "-fx-font-size: 1.1em;");
        
        //Media sound = new Media(new File("src/main/resources/sonidos/Shutdown.wav").toURI().toString());
        // mediaPlayer.play();
        
        alert.showAndWait();
    }
}
