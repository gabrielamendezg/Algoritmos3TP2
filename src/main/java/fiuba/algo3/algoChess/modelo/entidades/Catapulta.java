package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Catapulta extends Unidad implements Posicionable, Atacador, Atacable {

	private AtaqueDistanciaLejana ataque;

	public Catapulta(JugadorA jugador) {
		super(jugador);
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}
	
	public Catapulta(JugadorB jugador) {
		super(jugador);
		vida = 50;
		ataque = new AtaqueDistanciaLejana(20);
		costo = 5;
	}

	@Override
	public void atacarAtacable(Jugador atacante, Atacable unAtacable, LinkedList <Atacable> atacables) {
		ArrayList aliados = atacante.obtenerUnidades();
		if(aliados.contains(unAtacable)) return;
		ataque.atacar(posicion.getX(), posicion.getY(), unAtacable);
        HashMap<String, Atacable> atacableHashMap = new HashMap<>();
		atacables.stream().forEach(atacable -> {
		    atacableHashMap.put(atacable.getPosicion().toString(), atacable);
		});
		int i = unAtacable.getPosicion().getY();
		Atacable atacable = atacableHashMap.get(new Posicion(unAtacable.getPosicion().getX(), i + 1).toString());
		while (atacable != null){
            ataque.atacar(posicion.getX(),posicion.getY(), atacable);
        }
	}
}
