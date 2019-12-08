package fiuba.algo3.algoChess.vista;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EscenaTablero extends Scene {
	private ImageView jugadorAzulEmblema = new ImageView(new Image("imagenes/emblemaAzul.PNG"));
	private ImageView jugadorRojoEmblema = new ImageView(new Image("imagenes/emblemaRojo.PNG"));
	private String jugadorAzulNombre;
	private String jugadorRojoNombre;
	public ImagenTablero tablero;
	public Stage stagePrincipal;
	public BorderPane panelPrincipal;
	public int jugadorTurno;
	
	
	public EscenaTablero(Stage stage, String jugadorAzul, String jugadorRojo, ImagenTablero tablero, BorderPane panel) {
		super(panel,990,700);
		jugadorAzulNombre = jugadorAzul;
		jugadorRojoNombre = jugadorRojo;
		panelPrincipal = panel;
		stagePrincipal = stage;
		
		panelPrincipal.setLeft(this.eleccionJugadorAzul(jugadorAzulNombre,jugadorAzulEmblema));
		VBox derecha = new VBox();
		derecha.setPrefWidth(144);
		panelPrincipal.setRight(derecha);

		panelPrincipal.setCenter(tablero);
		tablero.setAlignment(Pos.CENTER);
		panelPrincipal.setStyle("-fx-background-color: #484860");
		panelPrincipal.setCenterShape(true);
		return;
	}
	
	public VBox eleccionJugadorAzul(String nombreJugador, ImageView icono) {
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
		terminar.setOnAction(e -> this.eleccionJugadorRojo(jugadorRojoNombre,jugadorRojoEmblema));
		controles.getChildren().addAll(tagJugador,unidades,terminar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		return controles;
	}

	private void eleccionJugadorRojo(String nombreJugador, ImageView icono) {
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
		terminar.setOnAction(e -> this.iniciarJuego(this.turnoAleatorio()));
		controles.getChildren().addAll(tagJugador,unidades,terminar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		panelPrincipal.setRight(controles);
		
	}
	
	private boolean turnoAleatorio() {
		Random rd = new Random();
		return rd.nextBoolean();
	}
	private void iniciarJuego(boolean turno) {
		if(turno) {
			panelPrincipal.setLeft(this.imagenTableroControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
		}else {
			VBox izquierda = new VBox();
			izquierda.setPrefWidth(144);
			panelPrincipal.setLeft(izquierda);
			panelPrincipal.setRight(this.imagenTableroControles(jugadorRojoNombre, jugadorRojoEmblema));
		}
	}
	
	public VBox imagenTableroControles(String nombreJugador, ImageView icono) {
		//Nombre jugador
		HBox tagJugador = new HBox();
		tagJugador.setStyle("-fx-background-color: #000000;-fx-spacing: 5");
		Label jugador = new Label(nombreJugador);
		jugador.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20");
		tagJugador.getChildren().addAll(icono,jugador); 
		//Botones
		Boton pasarturno = new Boton("Pasar Turno","#ffffff","#e3913e","#f5b754");
		pasarturno.setOnAction(e -> this.pasarTurno());
		Boton deseleccionar = new Boton("Deseleccionar","#000000","#39516d","#6886aa");
		Boton mover = new Boton("Mover","#000000","#39516d","#6886aa");
		Boton atacar = new Boton("Atacar","#000000","#39516d","#6886aa");
		
		HBox acciones = new HBox();
		acciones.getChildren().addAll(mover,atacar);
		
		//Controles de flechas
		GridPane movimientos = new TecladoDeFlechas();
		
		//Creo VBox.
		VBox controles = new VBox();
		controles.getChildren().addAll(tagJugador,pasarturno,acciones,movimientos,deseleccionar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		return controles;
	}
	
	public void pasarTurno() {
		if(jugadorTurno==1) {
			VBox izquierda = new VBox();
			izquierda.setPrefWidth(144);
			panelPrincipal.setLeft(izquierda);
			panelPrincipal.setRight(this.imagenTableroControles(jugadorRojoNombre, jugadorRojoEmblema));
			jugadorTurno = 2;
		}
		else{
			panelPrincipal.setLeft(this.imagenTableroControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
			jugadorTurno = 1;
		}
	}
	
}
