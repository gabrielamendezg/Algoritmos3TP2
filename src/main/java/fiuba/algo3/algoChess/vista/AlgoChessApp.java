package fiuba.algo3.algoChess.vista;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.*;

public class AlgoChessApp extends Application
{
	String fondo = "#484860";
	String celda = "#90c0c0";
	String bordeCelda = "#d8f0d8";
	
	ImagenTablero tablero;
	
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlgoChess");
		stage.getIcons().add(new Image(getClass().getResource("imagenes/Icon.png").toExternalForm())); 
		
		Scene menu = menu(stage);
	    stage.setScene(menu);
	    stage.show();
	}
	
	private Scene menu(Stage stage) {
		ImageView imagen = new ImageView(new Image(getClass().getResource("imagenes/Menu.png").toExternalForm()));
		Boton reglas = new Boton("¿Cómo jugar?","#000000","#39516d","#6886aa");
		Boton iniciar = new Boton("Iniciar","#000000","#39516d","#6886aa");
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().add(imagen);
		layout1.getChildren().add(reglas);
		layout1.getChildren().add(iniciar);
		layout1.setStyle("-fx-background-color: #484860");
		Scene menu = new Scene(layout1, 810, 700);
		reglas.setOnAction(e -> stage.setScene(this.reglas(stage,menu)));
		iniciar.setOnAction(e -> stage.setScene(this.faseJuego(stage)));
		return menu;
	}
	
	private Scene faseJuego(Stage stage) {
		VBox derecha = new VBox();
		derecha.setStyle("-fx-spacing: 5");	
		Label jugador = new Label("Jugador");
		Button pasarturno = new Boton("Pasar Turno","#ffffff","#e3913e","#f5b754");
		HBox acciones = new HBox();
		acciones.getChildren().addAll(new Button("Mover"),new Button("Atacar"));
		GridPane movimientos = new TecladoDeFlechas();
		Button deseleccionar = new Button("Deseleccionar");
		derecha.getChildren().addAll(jugador,pasarturno,acciones,movimientos,deseleccionar);
		
		BorderPane panelPrincipal = new BorderPane();
		panelPrincipal.setRight(derecha);
		
		//crea Tablero
		panelPrincipal.setCenter(new ImagenTablero());
		panelPrincipal.setStyle("-fx-background-color:"+fondo);
		panelPrincipal.setCenterShape(true);
		
		Scene faseJuego = new Scene(panelPrincipal,810, 700);
		return faseJuego;
	}
	
	private Scene eleccionUnidades(Stage stage, Scene faseJuego) {
		BorderPane panel = new BorderPane();
		Scene eleccionUnidades = new Scene(panel);
		return eleccionUnidades;
	}
	
	private Scene jugadores(Stage stage, Scene eleccionUnidades) {
		BorderPane panel = new BorderPane();
		Scene jugadores = new Scene(panel);
		return jugadores;
	}
	
	private Scene reglas(Stage stage,Scene menu) {
		VBox boxReglas = new VBox();
		Label reglastxt1 = new Label("¿CÓMO JUGAR?\n\n"
				+ "El objetivo es vencer al ejército enemigo acomodando las entidades "
				+ "aliadas en el tablero.\n"
				+ "Al iniciar el juego cada jugador tiene 20 puntos para intercambiar por entidades" + 
				" y posicionarlas en su lado del tablero. Durante el juego tanto las unidades aliadas como enemigas "
				+ "sufrirán un 5% más de daño si están sobre territorio del otro bando.\n"
				+ "En cada turno pueden realizarse hasta dos acciones, mover y/o atacar. Cada entidad puede moverse"
				+ " hasta un casillero por vez y los rangos de ataque dependen de la entidad:\n"
				+ "Distancia cercana: 1 a 2 casilleros en cualquier dirección. Media: 3 a 5 casilleros. Lejana: 6 a Infinito. "
				+ "\n\n"
				+ "SOLDADO: Puede atacar a un enemigo a corta distancia. " 
				+ "Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un Batallón y pueden moverse los 3 al mismo tiempo en el mismo turno.\n"
				+ "JINETE: Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media. " 
				+ "Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y únicamente puede atacar a enemigos en distancia corta.\n"
				+ "CURANDERO: Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.\n"
				+ "CATAPULTA: No puede moverse en toda la partida. " 
				+ "Ataca en una distancia lejana únicamente. [Puede dañar tanto a Enemigos como Aliados]. " 
				+ "Causa daño a la primera unidad enemiga alcanzada, y a todas las unidades directamente contiguas, y si a su vez la segunda unidad tiene otra unidad contigua, también causa el mismo daño (y así sucesivamente)");
		reglastxt1.setStyle("-fx-text-fill: white;-fx-wrap-text: true;-fx-font-size: 16px;-fx-label-padding: 30");
		Boton atras = new Boton("Atras","#000000","#39516d","#6886aa");
		atras.setOnAction(e -> stage.setScene(menu));
		boxReglas.setStyle("-fx-background-color: #484860");
		boxReglas.setAlignment(Pos.CENTER);
		boxReglas.getChildren().addAll(reglastxt1,atras);
		Scene reglas = new Scene(boxReglas,810,700);
		
		return reglas;
	}

}
