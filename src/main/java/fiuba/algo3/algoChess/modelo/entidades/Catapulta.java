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
		//Ataco atras segun mi perspectiva
		int i = unAtacable.getPosicion().getY() + 1;
		Atacable atacable = atacableHashMap.get(new Posicion(unAtacable.getPosicion().getX(), i).toString());
		while (atacable != null){
            ataque.atacar(posicion.getX(),posicion.getY(), atacable);
            i++;
            atacable = atacableHashMap.get(new Posicion(unAtacable.getPosicion().getX(), i).toString());
        }

		//Ataco adelante segun mi perspectiva
		 i = unAtacable.getPosicion().getY() - 1;
		 atacable = atacableHashMap.get(new Posicion(unAtacable.getPosicion().getX(), i).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i--;
			atacable = atacableHashMap.get(new Posicion(unAtacable.getPosicion().getX(), i).toString());
		}

		//Ataco derecha segun mi perspectiva
		i = unAtacable.getPosicion().getX() - 1;
		atacable = atacableHashMap.get(new Posicion(i, unAtacable.getPosicion().getY()).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i--;
			atacable = atacableHashMap.get(new Posicion(i, unAtacable.getPosicion().getY()).toString());
		}

		//Ataco izquierda segun mi perspectiva
		i = unAtacable.getPosicion().getX() + 1;
		atacable = atacableHashMap.get(new Posicion(i, unAtacable.getPosicion().getY()).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i++;
			atacable = atacableHashMap.get(new Posicion(i, unAtacable.getPosicion().getY()).toString());
		}

		//Ataco adelante a derecha segun mi perspectiva
		i = unAtacable.getPosicion().getX() - 1;
		int j = unAtacable.getPosicion().getY() - 1;
		atacable = atacableHashMap.get(new Posicion(i, j).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i--;
			j--;
			atacable = atacableHashMap.get(new Posicion(i, j).toString());
		}

		//Ataco atras a izquierda segun mi perspectiva
		i = unAtacable.getPosicion().getX() + 1;
		j = unAtacable.getPosicion().getY() + 1;
		atacable = atacableHashMap.get(new Posicion(i, j).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i++;
			j++;
			atacable = atacableHashMap.get(new Posicion(i, j).toString());
		}

		//Ataco adelante a izquierda segun mi perspectiva
		i = unAtacable.getPosicion().getX() + 1;
		j = unAtacable.getPosicion().getY() - 1;
		atacable = atacableHashMap.get(new Posicion(i, j).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i++;
			j--;
			atacable = atacableHashMap.get(new Posicion(i, j).toString());
		}

		//Ataco atras a derecha segun mi perspectiva
		i = unAtacable.getPosicion().getX() - 1;
		j = unAtacable.getPosicion().getY() + 1;
		atacable = atacableHashMap.get(new Posicion(i, j).toString());
		while (atacable != null){
			ataque.atacar(posicion.getX(),posicion.getY(), atacable);
			i--;
			j++;
			atacable = atacableHashMap.get(new Posicion(i, j).toString());
		}
	}
}
