package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

public class EleccionUnidadesAzules extends VBox {
	
	public EleccionUnidadesAzules() {
		super();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		
		
		ToggleButton catapulta = new ToggleButton();
		catapulta.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/CatapultaAzul.png").toExternalForm(),30,30,true,true)));
		catapulta.setStyle("-fx-background-color: #ffffff");
		catapulta.setPrefSize(30, 30);
		catapulta.setToggleGroup(toggleGroup);
		this.getChildren().add(catapulta);
		
		Label preciocatapulta = new Label("20");
		preciocatapulta.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20");
		this.getChildren().add(preciocatapulta);
		
		ToggleButton curandero = new ToggleButton();
		curandero.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/CuranderoAzul.png").toExternalForm(),30,30,true,true)));
		curandero.setStyle("-fx-background-color: #ffffff");
		curandero.setPrefSize(30, 30);
		curandero.setToggleGroup(toggleGroup);
		this.getChildren().add(curandero);
		
		ToggleButton jinete = new ToggleButton();
		jinete.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/JineteAzul.png").toExternalForm(),30,30,true,true)));
		jinete.setStyle("-fx-background-color: #ffffff");
		jinete.setPrefSize(30, 30);
		jinete.setToggleGroup(toggleGroup);
		this.getChildren().add(jinete);
		
		ToggleButton soldado = new ToggleButton();
		soldado.setGraphic(new ImageView(new Image(getClass().getResource("imagenes/SoldadoAzul.png").toExternalForm(),30,30,true,true)));
		soldado.setStyle("-fx-background-color: #ffffff");
		soldado.setPrefSize(30, 30);
		soldado.setToggleGroup(toggleGroup);
		this.getChildren().add(soldado);
		
		
	}
}
