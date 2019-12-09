package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Button;

public class Boton extends Button {
	public Boton(String texto, String colorTexto, String color1, String color2) {
		super();
		this.setText(texto);
		this.aplicarEstilo(colorTexto,color1,color2);
	}
	
	public void aplicarEstilo(String colorTexto, String color1, String color2) {
		this.setStyle("-fx-padding: 8 15 15 15;"+
	    "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;"+
	    "-fx-background-radius: 8;"+
	    "-fx-background-color:"+ color1+", "+color2+"; "+
	    "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );"+
	    "-fx-text-fill: "+colorTexto+";"+
	    "-fx-font-weight: bold;"+
	    "-fx-font-size: 1.1em;");
	}
	//#a34313, #DB5220
}
