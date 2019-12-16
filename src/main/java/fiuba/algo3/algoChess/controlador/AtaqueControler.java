package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.NoSePuedeAtacarUnidadPropiaExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.SelecionaUnaUnidaMasParaAtacarExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.UnidadNoEsAtacanteExcepcion;
import fiuba.algo3.algoChess.controlador.excepciones.YaCompletasteTuTurnoExcecion;
import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AtaqueControler implements EventHandler<ActionEvent> {
    String sound = "src/main/resources/sonidos/Shutdown.wav";

	@Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoChessControler.getAlgoChessControler().primeraUnidadSeleccionadaAtacaSegundaUnida();
        } catch (UnidadNoEsAtacanteExcepcion e){
            new Informar("No sé atacar!", "La primera unidad seleccionada debe ser de tipo ofensivo",sound);
        }catch (NoSePuedeAtacarUnidadPropiaExcepcion e){
            new Informar("Fuego cruzado!", "No es posible atacar a tus propias unidades",sound);
        }catch (SelecionaUnaUnidaMasParaAtacarExcepcion e){
            new Informar("¿A quién debo atacar?", "Selecciona una segunda unidad (enemiga) para atacar",sound);
        }catch (YaCompletasteTuTurnoExcecion e){
            new Informar("Ya Atacaste", "Solo puedes atacar una vez por favor Pasa de turno",sound);
        }catch (FueraDelRangoDeAtaqueExcepcion e){
            new Informar("No es posible Atacar", "estas muy lejos o muy cerca no puedes ataca",sound);
        }

    }
}
