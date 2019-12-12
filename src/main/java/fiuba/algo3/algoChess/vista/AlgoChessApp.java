package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.modelo.algoChess.AlgoChess;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlgoChessApp extends Application
{
	private String fondo = "#484860";
	private String botonColor = "#6886aa";
	private String botonSombra = "#39516d";
	private String blanco ="#ffffff";
	
	public ImagenTablero tablero;

    public AlgoChessApp() {
        tablero = ImagenTablero.getImagenTablero();
    }


    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlgoChess");
		stage.getIcons().add(new Image("imagenes/Icon.png"));
		Scene menu = menu(stage);
	    stage.setScene(menu);
	    stage.show();
	}
	
	private Scene menu(Stage stage) {
		ImageView imagen = new ImageView(new Image("imagenes/Menu2.png",554,399,true,true));
		Boton reglas = new Boton("¿Cómo jugar?",blanco,botonSombra,botonColor);
		Boton iniciar = new Boton("Iniciar",blanco,botonSombra,botonColor);
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().add(imagen);
		layout1.getChildren().add(reglas);
		layout1.getChildren().add(iniciar);
		layout1.setStyle("-fx-background-color:"+fondo);
		Scene menu = new Scene(layout1, 990, 700);
		reglas.setOnAction(e -> stage.setScene(this.reglas(stage,menu)));
		iniciar.setOnAction(e -> stage.setScene(this.jugadores(stage)));
		return menu;
	}
	
	private Scene jugadores(Stage stage) {
		BorderPane panel = new BorderPane();
		panel.setStyle("-fx-background-color:"+fondo);
		Scene jugadores = new Scene(panel,990, 700);

		HBox tagJugadorAzul = new HBox();
		tagJugadorAzul.setStyle("-fx-spacing: 3");
		Label jugadorAzul = new Label("Jugador Azul:");
		jugadorAzul.setStyle("-fx-text-fill: white;-fx-font-size: 20px;-fx-label-padding: 30");
		tagJugadorAzul.getChildren().addAll(new ImageView(new Image("imagenes/emblemaAzul.PNG")),jugadorAzul);
		tagJugadorAzul.setAlignment(Pos.CENTER);
		
		HBox tagJugadorRojo = new HBox();
		tagJugadorRojo.setStyle("-fx-spacing: 3");
		Label jugadorRojo = new Label("Jugador Rojo:");
		jugadorRojo.setStyle("-fx-text-fill: white;-fx-font-size: 20px;-fx-label-padding: 30");
		tagJugadorRojo.getChildren().addAll(new ImageView(new Image("imagenes/emblemaRojo.PNG")),jugadorRojo);
		tagJugadorRojo.setAlignment(Pos.CENTER);
		
		Label placeholder = new Label("Jugador Rojo:");
		placeholder.setStyle("-fx-text-fill: #484860;-fx-font-size: 20px;-fx-label-padding: 30");
		TextField jugadorAzulNombre = new TextField();
		jugadorAzulNombre.setMaxWidth(100);
		TextField jugadorRojoNombre = new TextField();
		jugadorRojoNombre.setMaxWidth(100);
		Boton continuar = new Boton("Continuar",blanco,botonSombra,botonColor);
		continuar.setOnAction(e -> stage.setScene(this.iniciarJuego(stage,jugadorAzulNombre.getText(), jugadorRojoNombre.getText())));
		VBox layout2 = new VBox(tagJugadorAzul,jugadorAzulNombre,tagJugadorRojo,jugadorRojoNombre,placeholder,continuar);
		layout2.setAlignment(Pos.CENTER);
		panel.setCenter(layout2);
		return jugadores;
	}
	
	private Scene iniciarJuego(Stage stage,String jugadorAzul,String jugadorRojo) {
		Scene eleccion = new EscenaTablero(stage, jugadorAzul, jugadorRojo, tablero, new BorderPane());
		return eleccion;
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
		Boton atras = new Boton("Atras",blanco,botonSombra,botonColor);
		atras.setOnAction(e -> stage.setScene(menu));
		boxReglas.setStyle("-fx-background-color: "+fondo);
		boxReglas.setAlignment(Pos.CENTER);
		boxReglas.getChildren().addAll(reglastxt1,atras);
		Scene reglas = new Scene(boxReglas,990,700);
		
		return reglas;
	}

}

