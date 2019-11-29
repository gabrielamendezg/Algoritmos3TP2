package fiuba.algo3.algoChess.vista;

import java.io.FileInputStream;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlgoChessApp extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlgoChess");
		
		VBox derecha = new VBox();
		derecha.setStyle("-fx-background-color: #484860");
		Label jugador = new Label("Jugador");
		Button pasarturno = new Button("Pasar Turno");
		HBox acciones = new HBox();
		acciones.getChildren().addAll(new Button("Mover"),new Button("Atacar"));
		GridPane movimientos = getMovimientos();
		Button deseleccionar = new Button("Deseleccionar");
		derecha.getChildren().addAll(jugador,pasarturno,acciones,movimientos,deseleccionar);
		
		BorderPane panelPrincipal = new BorderPane();
		panelPrincipal.setRight(derecha);
		
		//crea Tablero
		panelPrincipal.setCenter(new ImagenTablero());
		panelPrincipal.setStyle("-fx-background-color:#484860");
		panelPrincipal.setCenterShape(true);
	    Scene mainScene = new Scene(panelPrincipal);
	    //#484860
	    stage.setScene(mainScene);
	    stage.show();
	}
	
	private GridPane getMovimientos() {
		GridPane movimientos = new GridPane();

		Button arribaIzq = new Button();
		arribaIzq.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaArribaIzq.png").toExternalForm(),16,16,true,true)));
		arribaIzq.setStyle("-fx-background-color: #ffffff");
		arribaIzq.setPrefSize(30, 30);
		movimientos.add(arribaIzq,0,0);
		
		Button arriba = new Button();
		arriba.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaArriba.png").toExternalForm(),16,16,true,true)));
		arriba.setStyle("-fx-background-color: #ffffff");
		arriba.setPrefSize(30, 30);
		movimientos.add(arriba, 1, 0);
		
		Button arribaDer = new Button();
		arribaDer.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaArribaDer.png").toExternalForm(),16,16,true,true)));
		arribaDer.setStyle("-fx-background-color: #ffffff");
		arribaDer.setPrefSize(30, 30);
		movimientos.add(arribaDer, 2, 0);
		
		Button izquierda = new Button();
		izquierda.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaIzq.png").toExternalForm(),16,16,true,true)));
		izquierda.setStyle("-fx-background-color: #ffffff");
		izquierda.setPrefSize(30, 30);
		movimientos.add(izquierda, 0, 1);
		
		Button medio = new Button();
		medio.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/placeholder.png").toExternalForm(),16,16,true,true)));
		medio.setStyle("-fx-background-color: #484860");
		medio.setPrefSize(30, 30);
		movimientos.add(medio, 1, 1);
		
		Button derecha = new Button();
		derecha.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaDer.png").toExternalForm(),16,16,true,true)));
		derecha.setStyle("-fx-background-color: #ffffff");
		derecha.setPrefSize(30, 30);
		movimientos.add(derecha, 2, 1);
		
		Button abajoIzq = new Button();
		abajoIzq.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaAbajoIzq.png").toExternalForm(),16,16,true,true)));
		abajoIzq.setStyle("-fx-background-color: #ffffff");
		abajoIzq.setPrefSize(30, 30);
		movimientos.add(abajoIzq, 0, 2);
		
		Button abajo = new Button();
		abajo.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaAbajo.png").toExternalForm(),16,16,true,true)));
		abajo.setStyle("-fx-background-color: #ffffff");
		abajo.setPrefSize(30, 30);
		movimientos.add(abajo, 1, 2);
		
		Button abajoDer = new Button();
		abajoDer.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/flechaAbajoDer.png").toExternalForm(),16,16,true,true)));
		abajoDer.setStyle("-fx-background-color: #ffffff");
		abajoDer.setPrefSize(30, 30);
		movimientos.add(abajoDer, 2, 2);
		        
		return movimientos;
	}
}
