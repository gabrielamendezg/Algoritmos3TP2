package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.vista.imagenes.ImageCatapulta;
import fiuba.algo3.algoChess.vista.imagenes.ImageCurandero;
import fiuba.algo3.algoChess.vista.imagenes.ImageJinete;
import fiuba.algo3.algoChess.vista.imagenes.ImageSoldadoDeInfanteria;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

public class EleccionUnidadesRojas extends VBox {
	
	public EleccionUnidadesRojas() {
		super();
		
		ToggleGroup toggleGroup = new ToggleGroup();


		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageCatapulta("imagenes/CatapultaRojo.png",70,70,true,true),"CATAPULTA","$5","50","Ataque: 20"));
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageCurandero("imagenes/CuranderoRojo.png",70,70,true,true),"CURANDERO","$2","75","Curación: 15"));
		this.getChildren().add(this.publicarUnidad(toggleGroup,new ImageJinete("imagenes/JineteRojo.png",70,70,true,true), "JINETE", "$3","100","Ataque cercano: 5 / medio: 15"));
		this.getChildren().add(this.publicarUnidad(toggleGroup, new ImageSoldadoDeInfanteria("imagenes/SoldadoRojo.png",70,70,true,true), "SOLDADO", "$1","100","Ataque: 10"));


	}

	private HBox publicarUnidad(ToggleGroup grupo,ImageCatapulta imagenCatapulta,String nombre, String precio, String vida, String ataque) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(new ImageView(imagenCatapulta));
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
				// Comienza un gesto de drag-n-drop.
				// permitir cualquier transferencia.
				Dragboard db = unidad.startDragAndDrop(TransferMode.ANY);

				//coloca la imagen de la unidad en el dragboard.
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenCatapulta);
				db.setContent(content);

				//contolador hay un catapulta para posicionar
				AlgoChessControler.getAlgoChessControler().posicionableCataputaEnEspera();

				event.consume();
			}
		});

		HBox publicacion = new HBox();
		publicacion.getChildren().addAll(unidad);
		publicacion.setStyle("-fx-spacing: 5");
		publicacion.setAlignment(Pos.CENTER);
		return publicacion;
	}
	private HBox publicarUnidad(ToggleGroup grupo, ImageJinete imagenJinete, String nombre, String precio, String vida, String ataque) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(new ImageView(imagenJinete));
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
				// Comienza un gesto de drag-n-drop.
				// permitir cualquier transferencia.
				Dragboard db = unidad.startDragAndDrop(TransferMode.ANY);

				//coloca la imagen de la unidad en el dragboard.
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenJinete);
				db.setContent(content);

				//contolador hay un catapulta para posicionar
				AlgoChessControler.getAlgoChessControler().posicionableJineteEnEspera();

				event.consume();
			}
		});

		HBox publicacion = new HBox();
		publicacion.getChildren().addAll(unidad);
		publicacion.setStyle("-fx-spacing: 5");
		publicacion.setAlignment(Pos.CENTER);
		return publicacion;
	}
	private HBox publicarUnidad(ToggleGroup grupo, ImageSoldadoDeInfanteria imagenSoldado, String nombre, String precio, String vida, String ataque) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(new ImageView(imagenSoldado));
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
				// Comienza un gesto de drag-n-drop.
				// permitir cualquier transferencia.
				Dragboard db = unidad.startDragAndDrop(TransferMode.ANY);

				//coloca la imagen de la unidad en el dragboard.
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenSoldado);
				db.setContent(content);

				//contolador hay un catapulta para posicionar
				AlgoChessControler.getAlgoChessControler().posicionableSoldadoDeInfanteriaEnEspera();

				event.consume();
			}
		});

		HBox publicacion = new HBox();
		publicacion.getChildren().addAll(unidad);
		publicacion.setStyle("-fx-spacing: 5");
		publicacion.setAlignment(Pos.CENTER);
		return publicacion;
	}
	private HBox publicarUnidad(ToggleGroup grupo, ImageCurandero imagenCurandero, String nombre, String precio, String vida, String ataque) {
		ToggleButton unidad = new ToggleButton();
		unidad.setGraphic(new ImageView(imagenCurandero));
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
				// Comienza un gesto de drag-n-drop.
				// permitir cualquier transferencia.
				Dragboard db = unidad.startDragAndDrop(TransferMode.ANY);

				//coloca la imagen de la unidad en el dragboard.
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenCurandero);
				db.setContent(content);

				//contolador hay un catapulta para posicionar
				AlgoChessControler.getAlgoChessControler().posicionableCuranderoEnEspera();

				event.consume();
			}
		});

		HBox publicacion = new HBox();
		publicacion.getChildren().addAll(unidad);
		publicacion.setStyle("-fx-spacing: 5");
		publicacion.setAlignment(Pos.CENTER);
		return publicacion;
	}

	
}