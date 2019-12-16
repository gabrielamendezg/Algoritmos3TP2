package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.modelo.jugador.JugadorA;
import fiuba.algo3.algoChess.modelo.jugador.JugadorB;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Ganaste {
	ImageView ganaste = new ImageView(new Image("imagenes/Ganaste.png",700, 700, true,true));
	ImageView emblemaAzul = new ImageView(new Image("imagenes/emblemaAzul.png",300,300,true,true));
	ImageView emblemaRojo = new ImageView(new Image("imagenes/emblemaRojo.png",300,300,true,true));
	MediaPlayer mediaPlayer;
    
	public Ganaste(JugadorA jugador) {
        Alert alert = this.getAlert("Ganador: " + EscenaTablero.getEscenaTablero().getNombreJugadorAzul() + " ", emblemaAzul);
        alert.showAndWait();
    }

    public Ganaste(JugadorB jugador) {
        Alert alert = this.getAlert("Ganador: " + EscenaTablero.getEscenaTablero().getNombreJugadorRojo() + " ", emblemaRojo);
        alert.showAndWait();
    }
	
	private Alert getAlert(String titulo, ImageView emblema) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setGraphic(null);

        DialogPane cuadro = alert.getDialogPane();
        cuadro.setGraphic(ganaste);
        cuadro.setStyle("-fx-background-color: #121221;");
        alert.getDialogPane().setContent(emblema);


        Button ok = (Button) cuadro.lookupButton(ButtonType.OK);
        ok.setStyle("-fx-padding: 8 15 15 15;"+
                "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;"+
                "-fx-background-radius: 8;"+
                "-fx-background-color: #39516d , #6886aa;"+
                "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );"+
                "-fx-text-fill: #ffffff;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 1.1em;");
        Media sound = new Media(new File("src/main/resources/sonidos/trompeta.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        return alert;
	}
    
}
