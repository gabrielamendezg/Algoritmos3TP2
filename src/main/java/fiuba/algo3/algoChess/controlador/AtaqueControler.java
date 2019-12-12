package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.NoSePuedeAtacarUnidadPropiaExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.SelecionaUnaUnidaMasParaAtacarExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.UnidadNoEsAtacadorExcepcion;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AtaqueControler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoChessControler.getAlgoChessControler().primeraUnidadSeleccionadaAtacaSegundaUnida();
        } catch (UnidadNoEsAtacadorExcepcion e){
            new Informar("No es Atacador", "La primera unidad seleccionada tiene que ser Atacador");
        }catch (NoSePuedeAtacarUnidadPropiaExcepcion e){
            new Informar("No puedes Atacar", "No es posible atacar unidad propia");
        }catch (SelecionaUnaUnidaMasParaAtacarExcepcion e){
            new Informar("Selecciona un Atacable", "Tienes que seleccionar una unida Acatacable");
        }

    }
}
