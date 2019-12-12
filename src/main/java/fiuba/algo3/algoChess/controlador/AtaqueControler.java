package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.NoSePuedeAtacarUnidadPropiaExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.SelecionaUnaUnidaMasParaAtacarExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.UnidadNoEsAtacanteExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.YaCompletasteTuTurnoExcecion;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AtaqueControler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoChessControler.getAlgoChessControler().primeraUnidadSeleccionadaAtacaSegundaUnida();
        } catch (UnidadNoEsAtacanteExcepcion e){
            new Informar("No sé atacar!", "La primera unidad seleccionada debe ser de tipo ofensivo");
        }catch (NoSePuedeAtacarUnidadPropiaExcepcion e){
            new Informar("Fuego cruzado!", "No es posible atacar a tus propias unidades");
        }catch (SelecionaUnaUnidaMasParaAtacarExcepcion e){
            new Informar("¿A quién debo atacar?", "Selecciona una segunda unidad (enemiga) para atacar");
        }catch (YaCompletasteTuTurnoExcecion e){
            new Informar("Ya Atacaste", "Solo puedes atacar una vez");
        }

    }
}
