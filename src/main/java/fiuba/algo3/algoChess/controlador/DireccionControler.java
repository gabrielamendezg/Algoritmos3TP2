package fiuba.algo3.algoChess.controlador;

import fiuba.algo3.algoChess.controlador.excepciones.*;
import fiuba.algo3.algoChess.modelo.Direccion.Direccion;
import fiuba.algo3.algoChess.modelo.Excepciones.CoordenadaFueraDelTableroExcepcion;
import fiuba.algo3.algoChess.modelo.Excepciones.PosicionOcupadaExcepcion;
import fiuba.algo3.algoChess.vista.Informar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DireccionControler {
	
	Direccion direccion;
    String sound = "src/main/resources/sonidos/Shutdown.wav";

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
					new Informar("Un movimiento por turno","Ya moviste una unidad en este turno, por favor ataca o pasa turno.",sound);
				} catch (UnidadNoEsMovibleExcepcion e) {
					new Informar("No puedo moverme!","No es posible mover esta unidad en todo el juego",sound);
				} catch (SeleccionaUnaUnidadQueTePertenecePrimeroExcepcion e) {
					new Informar("No te pertenece!","Selecciona una de tus unidades",sound);
				} catch (SoloSePuedeMoverUnaUnidadExcepcion e) {
					new Informar("Solo una!","Selecciona una sola unidad para mover",sound);
				} catch (NoHayNingunaUnidadSeleccionadaExcepcion e) {
					new Informar("Selecciona una unidad","Selecciona una unidad para mover",sound);
				} catch (PosicionOcupadaExcepcion e){
					new Informar("Posicion ocupada", "La posicion ya esta ocupada",sound);
				} catch (CoordenadaFueraDelTableroExcepcion e){
					new Informar("No te puedes MOVER", "No es posible moverce fuera del tablero",sound);
				}
		
			}
		};
	}

}
