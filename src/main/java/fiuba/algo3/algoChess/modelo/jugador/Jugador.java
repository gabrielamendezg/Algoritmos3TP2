package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;
import fiuba.algo3.algoChess.sample.JugadorSinUnidadesPierdeException;


/*REFACTOREAR A JUGADOR CON MULTITON para 2 jugadores?? Discutir y definir*/

//CAMBIAR ENTIDAD POR UNIDAD

public class Jugador{

	private int puntos;
	private ArrayList<Entidad> unidades;
	
public Jugador() {	 	
	
	this.puntos= 20;
	this.unidades = new ArrayList<Entidad>();
	 
 }
	


 public Entidad elegirSoldado(){
	 
	 Entidad nuevaEntidad = null;
	
	 	if(this.puntos>=1) {
	 		
	 		nuevaEntidad= new SoldadoDeInfanteria();
	 		this.unidades.add(nuevaEntidad);
	 		this.puntos= this.puntos -1;
	 	
	 	}else {
		 
		 System.out.println("Puntos insuficientes, devuelve null");
	 }
	 
	 return nuevaEntidad;
 }
 
 public Entidad elegirCatapulta(){
	 
	 Entidad nuevaEntidad = null;
	 
	 if(this.puntos>=5) {
	
		nuevaEntidad= new Catapulta();
	 	this.unidades.add(nuevaEntidad);
	 	this.puntos= this.puntos -5;
	 	
	 }else {
		 
		 System.out.println("Puntos insuficientes, devuelve null");
	 }
	 
	 return nuevaEntidad;
 }
 
 public Entidad elegirJinete(){
 	 
	 Entidad nuevaEntidad = null;
	 
	 if(this.puntos>=3) {
		 
		nuevaEntidad= new Jinete();
	 	this.unidades.add(nuevaEntidad);
	 	this.puntos= this.puntos - 3;

	 
	 }else {
		 
		 System.out.println("Puntos insuficientes, devuelve null");
	 }
	 
	 return nuevaEntidad;
 }
 
 public Entidad elegirCurandero(){
 	 
	 Entidad nuevaEntidad = null;
	 
	 if(this.puntos>=2) {
		 
		nuevaEntidad= new Curandero();
	 	this.unidades.add(nuevaEntidad);
	 	this.puntos= this.puntos - 2;
	 
	 }else {
		 
		 System.out.println("Puntos insuficientes, devuelve null");
	 }
 
	 return nuevaEntidad;
 }
 
	 
 
 
 public int cantidadDeUnidades() {
	 
	 return (this.unidades.size());
 }
 
 public ArrayList<Entidad> obtenerUnidades(){
	 
	 
	 return this.unidades;
	 
 }

		 
	 
 	
 private boolean sigueEnJuego() {
	 
	 return (unidades.size() != 0);
 }
 
 public void eliminarUnidad(Entidad unaEntidad) throws JugadorSinUnidadesPierdeException {
	 
	 this.unidades.remove(unaEntidad);
	 
	 if(!this.sigueEnJuego()) {
		 throw new JugadorSinUnidadesPierdeException();
	
	 }
 }
 
 public boolean ordenarAtaque() {
	
	 boolean pudoOrdenarAtaque=true;
	 Iterator<Entidad> iterador = unidades.iterator();
	 while (iterador.hasNext()) {
	 iterador.getClass().atacar();
	 }
	
	 if (this.cantidadDeUnidades() == 0) {
		 pudoOrdenarAtaque=false;
	 }
	 
	return pudoOrdenarAtaque; 
 }
 
 
	
}
