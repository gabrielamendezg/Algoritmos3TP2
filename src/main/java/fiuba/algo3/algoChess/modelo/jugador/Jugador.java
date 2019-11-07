package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;
import fiuba.algo3.algoChess.modelo.entidades.*;


/*Agregar Mock unidad con aceptacion de String*/
/*JUGADOR CON MULTITON para 2 jugadores*/

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
 
 public void jugarTurno() {
	 
	 if(this.sigueEnJuego()) {
		 
	 }else {
		 
		 System.out.println("Jugador ha perdido");
		 
	 }
		 
	 
 }
	
 private boolean sigueEnJuego() {
	 
	 return (unidades.size() != 0);
 }
 
 public void eliminarUnidad(Entidad unaEntidad) {
	 
	 this.unidades.remove(unaEntidad);
	 
 }
 
	
}
