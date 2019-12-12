package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.modelo.Excepciones.FueraDelRangoDeAtaqueExcepcion;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CuracionControler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoChessControler.getAlgoChessControler().primeraUnidadSeleccionadaCuraSegundaUnidad();
        } catch (UnidadNoEsSanadorExcepcion e){
            new Informar("No sé curar!", "La primera unidad seleccionada debe ser de tipo curandero");
        }catch (NoSePuedeCurarUnidadEnemigaExcepcion e){
            new Informar("Ese es el enemigo!", "No es posible curar a unidades enemigas");
        }catch (SelecionaUnaUnidaMasParaAtacarExcepcion e){
            new Informar("¿A quién debo curar?", "Selecciona una segunda unidad para curar");
        }catch (YaCompletasteTuTurnoExcecion e){
            new Informar("Ya curaste", "Solo puedes curar o atacar una vez, por favor pasa turno");
        }catch (FueraDelRangoDeAtaqueExcepcion e){
            new Informar("No es posible curar", "Objetivo fuera de rango");
        }catch (UnidadNoEsSanableExcepcion e) {
        	new Informar("No sé curar esto!", "La unidad a curar debe ser sanable");
        }catch (Exception e) {
        	new Informar("Error inesperado","Error inesperado, lo siento.");
        }

    }
}