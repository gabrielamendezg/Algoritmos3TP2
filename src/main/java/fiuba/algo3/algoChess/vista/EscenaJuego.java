package fiuba.algo3.algoChess.vista;

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

public class EscenaJuego extends Scene {
	private ImageView jugadorAzulEmblema = new ImageView(new Image(getClass().getResource("imagenes/emblemaAzul.png").toExternalForm()));
	private ImageView jugadorRojoEmblema = new ImageView(new Image(getClass().getResource("imagenes/emblemaRojo.png").toExternalForm()));
	private String jugadorAzulNombre;
	private String jugadorRojoNombre;
	public ImagenTablero tablero;
	public Stage stage;
	public BorderPane panelPrincipal;
	public int jugadorTurno;
	
	
	public EscenaJuego(Stage stage, String jugadorAzul, String jugadorRojo, ImagenTablero tablero, BorderPane panel,int turno) {
		super(panel,990,700);
		jugadorAzulNombre = jugadorAzul;
		jugadorRojoNombre = jugadorRojo;
		panelPrincipal = panel;
		jugadorTurno = turno;
		
		if(turno == 1) {
			panelPrincipal.setLeft(this.ImagenTableroControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
		}else {
			VBox izquierda = new VBox();
			izquierda.setPrefWidth(144);
			panelPrincipal.setLeft(izquierda);
			panelPrincipal.setRight(this.ImagenTableroControles(jugadorRojoNombre, jugadorRojoEmblema));
		}
		panelPrincipal.setCenter(tablero);
		tablero.setAlignment(Pos.CENTER);
		panelPrincipal.setStyle("-fx-background-color: #484860");
		panelPrincipal.setCenterShape(true);
	}
	
	public VBox ImagenTableroControles(String nombreJugador,ImageView icono) {
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
			panelPrincipal.setRight(this.ImagenTableroControles(jugadorRojoNombre, jugadorRojoEmblema));
			jugadorTurno = 2;
		}
		else{
			panelPrincipal.setLeft(this.ImagenTableroControles(jugadorAzulNombre,jugadorAzulEmblema));
			VBox derecha = new VBox();
			derecha.setPrefWidth(144);
			panelPrincipal.setRight(derecha);
			jugadorTurno = 1;
		}
	}
	
	
}
