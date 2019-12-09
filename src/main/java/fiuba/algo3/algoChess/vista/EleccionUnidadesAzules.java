package fiuba.algo3.algoChess.vista;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EleccionUnidadesAzules extends VBox {
	
	public EleccionUnidadesAzules() {
		super();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageView(new Image("imagenes/CatapultaAzul.png",70,70,true,true)),"CATAPULTA","$5","50","Ataque: 20"));
		
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageView(new Image("imagenes/CuranderoAzul.png",70,70,true,true)),"CURANDERO","$2","75","Curación: 15"));

		this.getChildren().add(this.publicarUnidad(toggleGroup, new ImageView(new Image("imagenes/JineteAzul.png",70,70,true,true)), "JINETE", "$3","100","Ataque cercano: 5 / medio: 15"));

		this.getChildren().add(this.publicarUnidad(toggleGroup, new ImageView(new Image("imagenes/SoldadoAzul.png",70,70,true,true)), "SOLDADO", "$1","100","Ataque: 10"));
		
		
	}
	
	private HBox publicarUnidad(ToggleGroup grupo,ImageView imagen,String nombre, String precio, String vida, String ataque) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(imagen);
		unidad.setStyle("-fx-background-color: #484860");
		unidad.setPrefSize(110, 110);
		unidad.setToggleGroup(grupo);

		final Tooltip tooltip = new Tooltip();
		tooltip.setText(
				nombre + "\n" +
				"Precio: " + precio + "\n" +
				"Vida: " + vida + "\n" + 
				ataque
		);

		unidad.setTooltip(tooltip);

		unidad.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				/* drag was detected, start a drag-and-drop gesture*/
				/* allow any transfer mode */
				Dragboard db = unidad.startDragAndDrop(TransferMode.ANY);

				/* Put a string on a dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagen.getImage());
				db.setContent(content);

				event.consume();
			}
		});
		
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
		publicacion.setAlignment(Pos.CENTER);
		return publicacion;
	}
}