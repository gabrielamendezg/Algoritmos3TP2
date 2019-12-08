package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EleccionUnidadesRojas extends VBox {
	
	public EleccionUnidadesRojas() {
		super();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageView(new Image("imagenes/CatapultaRojo.png",70,70,true,true)),"Catapulta","$5 - 50 - 20"));
		
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageView(new Image("imagenes/CuranderoRojo.png",70,70,true,true)),"Curandero","$2 - 75 - 15"));

		this.getChildren().add(this.publicarUnidad(toggleGroup, new ImageView(new Image("imagenes/JineteRojo.png",70,70,true,true)), "Jinete", "$3 - 100 - 5/15"));

		this.getChildren().add(this.publicarUnidad(toggleGroup, new ImageView(new Image("imagenes/SoldadoRojo.png",70,70,true,true)), "Soldado", "$1 - 100 - 10"));
		
		
	}
	
	private HBox publicarUnidad(ToggleGroup grupo,ImageView imagen,String nombre, String precio) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(imagen);
		unidad.setStyle("-fx-background-color: #ffffff");
		unidad.setPrefSize(110, 110);
		unidad.setToggleGroup(grupo);

		final Tooltip tooltip = new Tooltip();
		tooltip.setText(
				"Nombre :" + nombre +
						"\nPresio: " + precio + "\n"
		);

		unidad.setTooltip(tooltip);
		
		/*VBox info = new VBox();
		Label infoLabel = new Label(nombre);
		infoLabel.setStyle("-fx-text-fill: white;-fx-font-size: 12px");
		Label infoLabel2 = new Label(precio);
		infoLabel2.setStyle("-fx-text-fill: white;-fx-font-size: 12px");
		info.getChildren().addAll(infoLabel,infoLabel2);*/
		
		HBox publicacion = new HBox();
		//publicacion.getChildren().addAll(unidad,info);
		publicacion.getChildren().addAll(unidad);
		publicacion.setStyle("-fx-spacing: 5");
		return publicacion;
	}
}
