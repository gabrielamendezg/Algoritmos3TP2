package fiuba.algo3.algoChess.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EscenaEleccionUnidades extends Scene {
	private ImageView jugadorAzulEmblema = new ImageView(new Image(getClass().getResource("imagenes/emblemaAzul.png").toExternalForm()));
	private ImageView jugadorRojoEmblema = new ImageView(new Image(getClass().getResource("imagenes/emblemaRojo.png").toExternalForm()));
	private String jugadorAzulNombre;
	private String jugadorRojoNombre;
	public ImagenTablero tablero;
	public Stage stagePrincipal;
	public BorderPane panelPrincipal;
	public int jugadorTurno;
	
	
	public EscenaEleccionUnidades(Stage stage, String jugadorAzul, String jugadorRojo, ImagenTablero tablero, BorderPane panel) {
		super(panel,990,700);
		jugadorAzulNombre = jugadorAzul;
		jugadorRojoNombre = jugadorRojo;
		panelPrincipal = panel;
		stagePrincipal = stage;
		
		panelPrincipal.setLeft(this.EleccionJugadorAzul(jugadorAzulNombre,jugadorAzulEmblema));
		VBox derecha = new VBox();
		derecha.setPrefWidth(144);
		panelPrincipal.setRight(derecha);

		panelPrincipal.setCenter(tablero);
		tablero.setAlignment(Pos.CENTER);
		panelPrincipal.setStyle("-fx-background-color: #484860");
		panelPrincipal.setCenterShape(true);
		return;
	}
	
	public VBox EleccionJugadorAzul(String nombreJugador,ImageView icono) {
		//Nombre jugador
		HBox tagJugador = new HBox();
		tagJugador.setStyle("-fx-background-color: #000000;-fx-spacing: 5");
		Label jugador = new Label(nombreJugador);
		jugador.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20");
		tagJugador.getChildren().addAll(icono,jugador); 
		
		//unidades y boton para terminar turno de elección
		VBox unidades = new EleccionUnidadesAzules();
		Boton terminar = new Boton("Terminar","#000000","#39516d","#6886aa");

		//Creo VBox.
		VBox controles = new VBox();
		terminar.setOnAction(e -> this.EleccionJugadorRojo(jugadorRojoNombre,jugadorRojoEmblema));
		controles.getChildren().addAll(tagJugador,unidades,terminar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		return controles;
	}

	private void EleccionJugadorRojo(String nombreJugador, ImageView icono) {
		VBox vacio = new VBox();
		vacio.setPrefWidth(144);
		panelPrincipal.setLeft(vacio);
		
		//Nombre jugador
		HBox tagJugador = new HBox();
		tagJugador.setStyle("-fx-background-color: #000000;-fx-spacing: 5");
		Label jugador = new Label(nombreJugador);
		jugador.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20");
		tagJugador.getChildren().addAll(icono,jugador); 
		
		VBox unidades = new EleccionUnidadesRojas();
		Boton terminar = new Boton("Terminar","#000000","#39516d","#6886aa");
		
		VBox controles = new VBox();
		terminar.setOnAction(e -> this.iniciarJuego());
		controles.getChildren().addAll(tagJugador,unidades,terminar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		panelPrincipal.setRight(controles);
		
	}
	
	private void iniciarJuego() {
		Scene faseJuego = new EscenaJuego(stagePrincipal,jugadorAzulNombre,jugadorRojoNombre,tablero,new BorderPane(),1);
		stagePrincipal.setScene(faseJuego);
	}
	
	
	
}
