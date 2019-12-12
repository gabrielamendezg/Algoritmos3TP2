package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.AlgoChessControler;
import fiuba.algo3.algoChess.controlador.AtaqueControler;
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
	private ImageView jugadorAzulEmblema = new ImageView(new Image("imagenes/emblemaAzul.PNG",50,50,true,true));
	private ImageView jugadorRojoEmblema = new ImageView(new Image("imagenes/emblemaRojo.PNG",50,50,true,true));
	private String jugadorAzulNombre;
	private String jugadorRojoNombre;
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

		panelPrincipal.setCenter(ImagenTablero.getImagenTablero());
		tablero.setAlignment(Pos.CENTER);
		panelPrincipal.setStyle("-fx-background-color: #484860");
		panelPrincipal.setCenterShape(true);
		return;
	}
	
	private HBox tagJugador(String nombreJugador, ImageView icono) {
		HBox tagJugador = new HBox();
		tagJugador.setStyle("-fx-background-color: #000000;-fx-spacing: 5");
		Label jugador = new Label(nombreJugador);
		jugador.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20");
		tagJugador.getChildren().addAll(icono,jugador);
		return tagJugador;
	}
	
	public VBox eleccionJugadorAzul(String nombreJugador, ImageView icono) {
		//Set de unidades disponibles
		VBox unidades = new EleccionUnidadesAzules();
		
		//Boton para pasar turno de elección de unidades.
		Boton terminar = new Boton("Terminar","#ffffff","#39516d","#6886aa");
		terminar.setOnAction(e -> {
			this.eleccionJugadorRojo(jugadorRojoNombre,jugadorRojoEmblema);
		});
		HBox botonterminar = new HBox(terminar);
		botonterminar.setAlignment(Pos.CENTER);
		
		//Nombre jugador y puntos.
		Label puntosjugador = new Label("Puntos: "+ Integer.toString(AlgoChessControler.getAlgoChessControler().getPuntosJugadorActivo()));
		puntosjugador.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30;"+
				"-fx-font-weight: bold;");
		AlgoChessControler.getAlgoChessControler().setLabelPuntos(puntosjugador);
		HBox puntos = new HBox(puntosjugador);
		puntos.setAlignment(Pos.CENTER);
		VBox datosjugador = new VBox(this.tagJugador(nombreJugador, icono),puntos);
		datosjugador.setSpacing(1);

		//Contenedor
		VBox controles = new VBox();
		controles.getChildren().addAll(datosjugador,unidades,botonterminar);
		controles.setStyle("-fx-spacing: 4");
		controles.setPrefWidth(144);
		return controles;
	}

	private void eleccionJugadorRojo(String nombreJugador, ImageView icono) {
		//Cambia jugador activo.
		AlgoChessControler.getAlgoChessControler().pasarTurno();
		
		//Elimina de la escena los controles del jugador azul.
		VBox vacio = new VBox();
		vacio.setPrefWidth(144);
		panelPrincipal.setLeft(vacio);
		
		//Unidades disponibles para posicionar
		VBox unidades = new EleccionUnidadesRojas();
		unidades.setAlignment(Pos.CENTER);
		
		//boton para terminar fase inicial.
		Boton terminar = new Boton("Terminar","#ffffff","#39516d","#6886aa");
		terminar.setOnAction(e -> {
			this.iniciarJuego(AlgoChessControler.getAlgoChessControler().turnoAleatorio());
		});
		HBox botonterminar = new HBox(terminar);
		botonterminar.setAlignment(Pos.CENTER);
		
		//Nombre jugador y puntos.
		Label puntosjugador = new Label("Puntos: "+ Integer.toString(AlgoChessControler.getAlgoChessControler().getPuntosJugadorActivo()));
		puntosjugador.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30;"+
						"-fx-font-weight: bold;");
		AlgoChessControler.getAlgoChessControler().setLabelPuntos(puntosjugador);
		HBox puntos = new HBox(puntosjugador);
		puntos.setAlignment(Pos.CENTER);
		VBox datosjugador = new VBox(this.tagJugador(nombreJugador, icono),puntos);
		datosjugador.setSpacing(1);		
		
		VBox controles = new VBox();
		controles.getChildren().addAll(datosjugador,unidades,botonterminar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		panelPrincipal.setRight(controles);
		
	}
	
	private void iniciarJuego(boolean turno) {
		AlgoChessControler.getAlgoChessControler().setOnActionCeldaConImagen();
		if(turno) {
			jugadorTurno = 2;
			panelPrincipal.setLeft(this.jugadorControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
		}else {
			jugadorTurno = 1;
			VBox izquierda = new VBox();
			izquierda.setPrefWidth(144);
			panelPrincipal.setLeft(izquierda);
			panelPrincipal.setRight(this.jugadorControles(jugadorRojoNombre, jugadorRojoEmblema));
		}
	}
	
	public VBox jugadorControles(String nombreJugador, ImageView icono) {
		//Botones
		Boton pasarturno = new Boton("Pasar Turno","#ffffff","#e3913e","#f5b754");
		pasarturno.setOnAction(e -> {
			AlgoChessControler.getAlgoChessControler().pasarTurno();
			this.pasarTurno();
		});
		pasarturno.setPrefWidth(144);
		
		Boton deseleccionar = new Boton("Deseleccionar","#ffffff","#39516d","#6886aa");
		deseleccionar.setOnAction(e -> {
			AlgoChessControler.getAlgoChessControler().deseleccionarUnidades();
		});
		deseleccionar.setPrefWidth(144);
		
		Boton atacar = new Boton("Atacar","#ffffff","#39516d","#6886aa");
		atacar.setOnAction(new AtaqueControler());
		atacar.setPrefWidth(144);
		
		Boton curar = new Boton( "Curar", "#ffffff", "#39516d","#6886aa" );
		curar.setPrefWidth(144);
		
		//Controles de flechas
		GridPane movimientos = new TecladoDeFlechas();
		movimientos.setAlignment(Pos.CENTER);
		
		//Creo VBox.
		VBox controles = new VBox();
		controles.getChildren().addAll(this.tagJugador(nombreJugador,icono),pasarturno,movimientos,atacar,curar,deseleccionar);
		controles.setStyle("-fx-spacing: 5");
		controles.setPrefWidth(144);
		return controles;
	}
	
	public void pasarTurno() {
		if(jugadorTurno == 2) {
			VBox izquierda = new VBox();
			izquierda.setPrefWidth(144);
			panelPrincipal.setLeft(izquierda);
			panelPrincipal.setRight(this.jugadorControles(jugadorRojoNombre, jugadorRojoEmblema));
			jugadorTurno = 1;
		}
		else{
			panelPrincipal.setLeft(this.jugadorControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
			jugadorTurno = 2;
		}
	}
	
}
