package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
	
	private static final long serialVersionUID = -543838711625534963L;
	private String nombreEquipo;
	private String ciudad;
	private String entrenador;
	private int victorias;
	private int derrotas;
	private String estadio;
	private ArrayList <Performance> misEstadisticas = new ArrayList<>();
	private ArrayList <Player> misJugadores = new ArrayList<>();
	public static Team equipo;
	
	public Team(String nombreEquipo, String ciudad, String entrenador, int victorias, int derrotas, String estadio) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.ciudad = ciudad;
		this.entrenador = entrenador;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.estadio = estadio;
		misEstadisticas = new ArrayList <>();
		misJugadores = new ArrayList<>();
	}
	public Team() {
	}
	//singleton
	public static Team getInstances(){
		if(equipo ==null){
			equipo = new Team();
		}
		return equipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public ArrayList<Performance> getMisEstadisticas() {
		return misEstadisticas;
	}
	public void setMisEstadisticas(ArrayList<Performance> misEstadisticas) {
		this.misEstadisticas = misEstadisticas;
	}
	public ArrayList<Player> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Player> misJugadores) {
		this.misJugadores = misJugadores;
	}
	//metodo insertar jugador.
	public void InsertarJugador(Player jugadores)
	{
		misJugadores.add(jugadores);
	}
	//metodo eliminar jugador.
	public void elminiarJugador(Player jugadores){
		misJugadores.remove(jugadores);
	}
	//metodo insertar estadisticas.
	public void InsertarEstadisticasEquipo(Performance estadisticasEq) {
		misEstadisticas.add(estadisticasEq);
	}
	//roster inicial
	public ArrayList<Player> getRoster() {
		ArrayList<Player> Roster = null;
		for (Team aux : Nba.getInstances().getMisEquipos()) {
			for (Player aux2 : aux.getMisJugadores()) {
				Roster = aux.getMisJugadores();
			}
		}
		return Roster;
	}
	public Player buscarJugador(String name) {
		int i=0;
		boolean find = false;
		Player aux =null;
		while(i<misJugadores.size() && find == false){
			if(misJugadores.get(i).getNombre().equalsIgnoreCase(name)){
				aux = misJugadores.get(i);
				find = true;
			}
		}
		return aux;
	}
}