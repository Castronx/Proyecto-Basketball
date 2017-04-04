package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 3950417824981446715L;
	private String nombre;
	private String apellido;
	private String pais;
	private String fechaNacimiento;
	private int edad;
	private float pies;
	private float pulgadas;
	private float peso;
	private int numero;
	private String posicion;
	private String equipo;
	private boolean lesionado;
	private ArrayList <Injury> lesion;
	private ArrayList <Performance> estadisticasJugador;
	private static Player jugador;

	public Player() {
		lesion = new ArrayList<>();
		estadisticasJugador = new ArrayList<>();
	}
	public Player(String nombre, String apellido, String pais, String fechaNacimiento, int edad, float pies,
			float pulgadas, float peso, int numero, String posicion, String equipo, boolean lesionado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.pies = pies;
		this.pulgadas = pulgadas;
		this.peso = peso;
		this.numero = numero;
		this.posicion = posicion;
		this.equipo = equipo;
		this.lesionado = lesionado;
	}
	public static Player getInstance() {
		if(jugador == null){
			jugador = new Player();
		}
		return jugador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public boolean isLesionado() {
		return lesionado;
	}
	public void setLesion(boolean lesion) {
		this.lesionado = lesionado;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getPies() {
		return pies;
	}
	public void setPies(float pies) {
		this.pies = pies;
	}
	public float getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}
	public ArrayList <Injury> getLesion() {
		return lesion;
	}
	public void setLesion(ArrayList <Injury> lesion) {
		this.lesion = lesion;
	}
	public ArrayList <Performance> getEstadisticasJugador() {
		return estadisticasJugador;
	}
	public void setEstadisticasJugador(ArrayList <Performance> estadisticasJugador) {
		this.estadisticasJugador = estadisticasJugador;
	}
	//metodo insertar lesionado
	public void InsertarLesion(Injury lesiones){
		lesion.add(lesiones);
	}
	//metodo borrar lesionado
	public void removerLesion(Injury lesiones){
		lesion.remove(lesiones);
	}
	//metodo insertar estadisiticas jugador
	public void InsertarEstadisticasJugador(Performance estadisticasJug) {
		estadisticasJugador.add(estadisticasJug);
	}
	//metodo puntos totales
	public int gettotalPuntos() {
		int total = 0;
		for (Team aux : Nba.getInstances().getMisEquipos()) {
			for (Player aux2 : aux.getMisJugadores()) {
				total += aux.getMisJugadores().get(0).getEstadisticasJugador().get(0).getPuntoTotales();
			}
		}
		return total;
	}
}

