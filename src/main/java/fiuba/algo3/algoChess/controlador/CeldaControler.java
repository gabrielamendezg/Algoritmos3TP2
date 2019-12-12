package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.NoSePuedeSeleccionarMasDeDosUnidadesExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion;
import fiuba.algo3.algoChess.vista.ImagenCelda;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CeldaControler implements EventHandler<ActionEvent> {
    ImagenCelda imagenCelda;
    public CeldaControler(ImagenCelda celda) {
        imagenCelda = celda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoChessControler.getAlgoChessControler().posicionXYSeleccionado(imagenCelda.getX(), imagenCelda.getY());
            imagenCelda.setStyle("-fx-background-color: #f2fcf2; -fx-border-color: #515260;"
                    + " -fx-border-width: 1px");
        } catch (NoSePuedeSeleccionarMasDeDosUnidadesExcepcion e) {
            new Informar("Dos Unidades Seleccionadas", "No se puede seleccionar mas de dos unidades");
        } catch (SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion e){
            new Informar("Seleccion de unidad ", "Selecciona una unidad aliada");
        }

    }
}
