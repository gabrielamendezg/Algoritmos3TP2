package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TecladoDeFlechas extends GridPane {
	
	public TecladoDeFlechas() {
		super();
		
		this.add(this.flecha("imagenes/flechaArribaIzq.png"),0,0);
		
		this.add(this.flecha("imagenes/flechaArriba.png"), 1, 0);
		
		this.add(this.flecha("imagenes/flechaArribaDer.png"), 2, 0);
		
		this.add(this.flecha("imagenes/flechaIzq.png"), 0, 1);
		
		Button placeholder = this.flecha("imagenes/placeholder.png");
		placeholder.setStyle("-fx-background-color: #484860");
		this.add(placeholder, 1, 1);
		
		this.add(this.flecha("imagenes/flechaDer.png"), 2, 1);
		
		this.add(this.flecha("imagenes/flechaAbajoIzq.png"), 0, 2);
		
		this.add(this.flecha("imagenes/flechaAbajo.png"), 1, 2);
		
		this.add(this.flecha("imagenes/flechaAbajoDer.png"), 2, 2);
	}
	
	private Button flecha(String imagen) {
		Button flecha = new Button();
		flecha.setGraphic(new ImageView(new Image(imagen,16,16,true,true)));
		flecha.setStyle("-fx-background-color: #ffffff");
		flecha.setPrefSize(30, 30);
		return flecha;
	}
}
