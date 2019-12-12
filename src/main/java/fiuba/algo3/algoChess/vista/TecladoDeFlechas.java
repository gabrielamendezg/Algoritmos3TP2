package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TecladoDeFlechas extends GridPane {
	
	public TecladoDeFlechas() {
		super();
		
		Button arribaIzq = this.flecha("imagenes/flechaArribaIzq.png");
		arribaIzq.setOnAction((new DireccionControler((Direccion) new ArribaIzquierda()).gethandler()));
		this.add(arribaIzq,0,0);
		
		Button arriba = this.flecha("imagenes/flechaArriba.png");
		arriba.setOnAction((new DireccionControler((Direccion) new Arriba()).gethandler()));
		this.add(arriba, 1, 0);
		
		Button arribaDerecha = this.flecha("imagenes/flechaArribaDer.png");
		arribaDerecha.setOnAction((new DireccionControler((Direccion) new ArribaDerecha()).gethandler()));
		this.add(arribaDerecha, 2, 0);
		
		Button izquierda = this.flecha("imagenes/flechaIzq.png");
		izquierda.setOnAction((new DireccionControler((Direccion) new Izquierda()).gethandler()));
		this.add(izquierda, 0, 1);
		
		
		Button placeholder = this.flecha("imagenes/placeholder.png");
		placeholder.setStyle("-fx-background-color: #484860");
		this.add(placeholder, 1, 1);
		
		Button derecha = this.flecha("imagenes/flechaDer.png");
		derecha.setOnAction((new DireccionControler((Direccion) new Derecha()).gethandler()));
		this.add(derecha, 2, 1);
		
		Button abajoIzquierda = this.flecha("imagenes/flechaAbajoIzq.png");
		abajoIzquierda.setOnAction((new DireccionControler((Direccion) new AbajoIzquierda()).gethandler()));
		this.add(abajoIzquierda, 0, 2);
		
		Button abajo = this.flecha("imagenes/flechaAbajo.png");
		abajo.setOnAction((new DireccionControler((Direccion) new Abajo()).gethandler()));
		this.add(abajo, 1, 2);
		
		Button abajoDerecha = this.flecha("imagenes/flechaAbajoDer.png");
		abajoDerecha.setOnAction((new DireccionControler((Direccion) new AbajoDerecha()).gethandler()));
		this.add(abajoDerecha, 2, 2);
	}
	
	private Button flecha(String imagen) {
		Button flecha = new Button();
		flecha.setGraphic(new ImageView(new Image(imagen,16,16,true,true)));
		flecha.setStyle("-fx-background-color: #ffffff");
		flecha.setPrefSize(30, 30);
		return flecha;
	}
}
