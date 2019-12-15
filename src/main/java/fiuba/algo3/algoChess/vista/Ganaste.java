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
    public Ganaste(JugadorA jugadorAzul) {
        Label info = new Label("JugadorAzul");
        info.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("JugadorAzul");
        alert.setHeaderText(null);
        alert.setGraphic(null);

        DialogPane cuadro = alert.getDialogPane();
        cuadro.setGraphic(new ImageView(new Image("imagenes/Ganaste.png",700, 700, true,true)));
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
        Media sound = new Media(new File("src/main/resources/sonidos/Shutdown.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        alert.showAndWait();
    }
    public Ganaste(JugadorB jugadorAzul) {
        Label info = new Label("JugadorRojo");
        info.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("JugadorRojo");
        alert.setHeaderText(null);
        alert.setGraphic(null);

        DialogPane cuadro = alert.getDialogPane();
        cuadro.setGraphic(new ImageView(new Image("imagenes/Ganaste.png",700, 700, true,true)));
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
        Media sound = new Media(new File("src/main/resources/sonidos/Shutdown.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        alert.showAndWait();
    }
}
