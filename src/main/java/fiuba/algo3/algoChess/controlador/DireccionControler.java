package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DireccionControler {
	
	Direccion direccion;
	
	public DireccionControler(Direccion direccionmovimiento) {
		super();
		direccion = direccionmovimiento;
	}
	
	public EventHandler<ActionEvent> gethandler() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try{
					AlgoChessControler.getAlgoChessControler().moverUnidad(direccion);
				} catch (UnMovimientoPorTurnoExcepcion e) {
					new Informar("Un movimiento por turno","Ya moviste una unidad en este turno, por favor ataca o pasa turno.");
				} catch (UnidadNoEsMovibleExcepcion e) {
					new Informar("No puedo moverme!","No es posible mover esta unidad en todo el juego");
				} catch (SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion e) {
					new Informar("No te pertenece!","Selecciona una de tus unidades");
				} catch (SoloSePuedeMoverUnaUnidadExcepcion e) {
					new Informar("Solo una!","Selecciona una sola unidad para mover");
				} catch (NoHayNingunaUnidadSeleccionadaExcepcion e) {
					new Informar("Selecciona una unidad","Selecciona una unidad para mover");
				}
		
			}
		};
	}

}
