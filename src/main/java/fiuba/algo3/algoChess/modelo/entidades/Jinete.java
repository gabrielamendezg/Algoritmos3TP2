package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.celda.Posicionable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacable;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Atacador;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Movible;
import fiuba.algo3.algoChess.modelo.ataque.*;
import fiuba.algo3.algoChess.modelo.entidades.interfaces.Sanable;
import fiuba.algo3.algoChess.modelo.jugador.*;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

import java.util.ArrayList;
import java.util.LinkedList;

public class Jinete extends Unidad implements Sanable, Movible, Posicionable, Atacador, Atacable {

	private Ataque ataque;

	public Jinete (JugadorA jugador) {
		super(jugador);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
	}
	
	public Jinete (JugadorB jugador) {
		super(jugador);
		ataque = new AtaqueCercano(5);
		vida = 100;
		costo = 3;
	}
	
	private void setAtaque( Ataque ataqueNuevo) {
		this.ataque = ataqueNuevo;
	}

	@Override
	public void curarce(int conVida) {
		vida = vida + conVida;
	}

	@Override
	public boolean movibleMoveteA(JugadorA jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}
	@Override
	public boolean movibleMoveteA(JugadorB jugador, Posicion unaPosicion) {
		return tipo.moverA(this, jugador, unaPosicion);
	}

	@Override
	public void atacarAtacable(Jugador atacante, Atacable unAtacable, ArrayList<Atacable> atacables) {
		
	
		ArrayList<Unidad> aliados = new ArrayList<Unidad>(atacante.obtenerUnidades());
		ArrayList<Atacable> enemigosCopy = new ArrayList<Atacable> (atacables);
		boolean enemigoCerca = false;
		boolean noHayAliadosCerca = true;
		int distanciaX;
		int distanciaY;
		
		while(( !aliados.isEmpty()) && (noHayAliadosCerca)) {
			Unidad aliadoActual = aliados.remove(0);
			Posicion posicionAliado= aliadoActual.getPosicion();
			
			   distanciaX = Math.abs((posicionAliado.getX()) - this.getPosicion().getX());
			   distanciaY = Math.abs((posicionAliado.getY()) - this.getPosicion().getX());
			  
			  if ((distanciaX == 0 || distanciaX==1) &&
			  	 (distanciaY == 0 || distanciaY== 1)) {
				  
				  if(aliadoActual != this) {
					  noHayAliadosCerca = false;
				  }
			  }
		}
		

		
		
		while( !enemigosCopy.isEmpty() && !enemigoCerca) {
			
			Atacable enemigoActual = enemigosCopy.remove(0);
			Posicion posicionEnemigo = enemigoActual.getPosicion();
			
			  distanciaX = Math.abs((posicionEnemigo.getX()) - this.getPosicion().getX());
			  distanciaY = Math.abs((posicionEnemigo.getY()) - this.getPosicion().getX());
			  
			  if ((distanciaX == 0 || distanciaX==1) &&
			  	 (distanciaY == 0 || distanciaY== 1)) {
				  
				  enemigoCerca = true;
				  }
		}
			
			
		
		
		if(enemigoCerca && noHayAliadosCerca) {
			 this.setAtaque( new AtaqueCercano(5));
			 
			}
		else {
			this.setAtaque(new AtaqueDistanciaMedia(15));
		}
		
		
		 ataque.atacar(posicion.getX(), posicion.getY(), unAtacable);
		
	}
		

		}

