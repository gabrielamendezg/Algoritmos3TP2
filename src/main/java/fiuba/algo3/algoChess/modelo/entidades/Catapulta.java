package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacante;
import fiuba.algo3.algoChess.modelo.jugador.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Catapulta extends Unidad implements Posicionable, Atacante, Atacable {

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
	public void atacarAtacable(Jugador jugadorAtacante, Atacable unAtacable, ArrayList<Atacable> atacables) {
		ArrayList<Unidad> aliados = jugadorAtacante.obtenerUnidades();
		
		//ataca primera unidad alcanzada (unidad seleccionada)
		if(aliados.contains(unAtacable)) return;
		ataque.atacar(posicion.getX(), posicion.getY(), unAtacable);
		
        HashMap<String, Atacable> atacableHashMap = new HashMap<>();
		atacables.stream().forEach(atacable -> {
		    atacableHashMap.put(atacable.getPosicion().toString(), atacable);
		});
		
		//Adaptación del algoritmo BFS para atacar a todas las unidades contiguas al objetivo (unAtacable).
		LinkedList <Atacable> atacados = new LinkedList<Atacable>();
		Queue<Atacable> cola = new LinkedList<Atacable>(); 
		cola.add(unAtacable);
		atacados.add(unAtacable);
		
		while(!cola.isEmpty()) {
			Atacable actual = cola.poll();
			LinkedList <Atacable> atacablesContiguos = this.obtenerContiguosAtacables(atacableHashMap, actual);
			atacablesContiguos.forEach(atacable -> {
				if(!atacados.contains(atacable)) {
					ataque.ataquePorReaccionEnCadena(atacable);
					atacados.add(atacable);
					cola.add(atacable);
				}
			});
		}
		
	}
	
	private LinkedList<Atacable> obtenerContiguosAtacables(HashMap<String,Atacable> atacables,Atacable actual){
		LinkedList<Atacable> atacablesContiguos = new LinkedList<>();
		Integer actualX = actual.getPosicion().getX();
		Integer actualY = actual.getPosicion().getY();
		
		for(int x = actualX - 1; x <= actualX +1; x++) {
			for(int y = actualY -1; y <= actualY +1; y++) {
				if(x != actualX | y != actualY) {
					String pos = "("+x+", "+y+")";
					if(atacables.containsKey(pos)) {
						atacablesContiguos.add(atacables.get(pos));
					}
				}
			}
		}
		return atacablesContiguos;
	}
	
	@Override
	public int costo() {
		return costo;
	}
}
