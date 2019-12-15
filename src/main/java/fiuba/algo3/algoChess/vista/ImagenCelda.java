package fiuba.algo3.algoChess.vista;

import fiuba.algo3.algoChess.controlador.DragClase;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class ImagenCelda extends Button {
    private final String colorDefaul;
    private int x;
    private int y;
    
    public ImagenCelda(int coordenadaX, int coordenadaY,String color)
    {
        super();
        x = coordenadaX;
        y = coordenadaY;
        this.inicializar(color);
        colorDefaul = color;

    }
    
    private void  inicializar(String color) {
    	this.setStyle("-fx-background-color: "+ color +"; -fx-border-color: #484860;"
        		+ " -fx-border-width: 1px");
		this.setPadding(Insets.EMPTY);
        this.setPrefHeight(35);
        this.setPrefWidth(35);
        
        this.setOnDragOver(new DragClase().getDragOver(this));
        this.setOnDragEntered(new DragClase().getDragEntered(this));
        this.setOnDragExited(new DragClase().getDragExited(this));
        this.setOnDragDropped(new DragClase().getDragDropped(this));
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

    public void colorPorDefecto() {
        this.setStyle("-fx-background-color: "+ colorDefaul +"; -fx-border-color: #484860;"
                + " -fx-border-width: 1px");
    }
}
