package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class ImagenCelda extends Button {
	private int x;
    private int y;
    //private ImagenUnidad unidad;
    Image image = new Image(getClass().getResourceAsStream("imagenes/CeldaSeleccionada.jpg"));
    
    public ImagenCelda(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        //this.unidad = null;
        //this.setGraphic(new ImageView(image));
    }
    
}
