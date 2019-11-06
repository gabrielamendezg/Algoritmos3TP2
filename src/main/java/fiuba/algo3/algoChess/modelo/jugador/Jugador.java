package fiuba.algo3.algoChess.modelo.jugador;
import java.util.*;


/*Agregar Mock unidad con aceptacion de String*/
/*JUGADOR CON MULTITON para 2 jugadores*/

public class Jugador{

	private int puntos;
	private ArrayList<String> unidades;
	
public Jugador() {	 	
	
	this.puntos= 20;
	this.unidades = new ArrayList<String>();
	 
 }
	


 public void elegirSoldado(){
	 
	 if(this.puntos>=1) {
	 this.unidades.add("Soldado");
	 this.puntos= this.puntos -1;
	 }else {
		 
		 System.out.println("Puntos insuficientes");
	 }
	 
 }
 
 public void elegirCatapulta(){
 	 
	 if(this.puntos>=5) {
	 this.unidades.add("Catapulta");
	 this.puntos= this.puntos -5;
	 }else {
		 
		 System.out.println("Puntos insuficientes");
	 }
 }
 
 public void elegirJinete(){
 	 
	 if(this.puntos>=3) {
	 this.unidades.add("Jinete");
	 this.puntos= this.puntos - 3;
	 }else {
		 
		 System.out.println("Puntos insuficientes");
	 }
 }
 
 public void elegirCurandero(){
 	 
	 if(this.puntos>=2) {
	 this.unidades.add("Curandero");
	 this.puntos= this.puntos - 2;
	 }else {
		 
		 System.out.println("Puntos insuficientes");
	 }
 }
 
	 
 
 
 public int cantidadDeUnidades() {
	 
	 return (this.unidades.size());
 }
 
 public ArrayList<String> obtenerUnidades(){
	 
	 
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
 
	
}
