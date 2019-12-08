package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Button;

public class ImagenCelda extends Button {
	private int x;
    private int y;
    //private ImagenUnidad unidad;
    
    public ImagenCelda(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        //this.unidad = null;
        //this.setGraphic(new ImageView(image));
    }

}
