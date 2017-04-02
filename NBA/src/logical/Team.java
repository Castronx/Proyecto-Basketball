package logical;

import java.util.ArrayList;

public class Team{
	
	private String nombreEquipo;
	private String ciudad;
	private String entrenador;
	private int victorias;
	private int derrotas;
	private String estadio;
	private ArrayList <Performance> estadisticas;
	private ArrayList <Player> jugador;
	public static Team equipo;

	public static Team getInstance(){
		if(equipo ==null){
			equipo = new Team();
		}
		return equipo;
	}
	public Team(String nombreEquipo, String ciudad, String entrenador, int victorias, int derrotas, String estadio) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.ciudad = ciudad;
		this.entrenador = entrenador;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.estadio = estadio;
		estadisticas = new ArrayList <>();
		jugador = new ArrayList<>();
	}
	
	public Team(String nombreEquipo,String ciudad, String entrenador, String estadio) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.ciudad = ciudad;
		this.entrenador = entrenador;
		this.estadio = estadio;
	}
	
	
	public Team() {
		
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
	public ArrayList <Performance> getEstadisticas() {
		return estadisticas;
	}
	public void setEstadisticas(ArrayList <Performance> estadisticas) {
		this.estadisticas = estadisticas;
	}
	public ArrayList <Player> getJugador() {
		return jugador;
	}
	public void setJugador(ArrayList <Player> jugador) {
		this.jugador = jugador;
	}
	
	public void InsertarJugador(Player jugadores)
	{
		jugador.add(jugadores);
	}
	
	public void InsertarEstadisticasEquipo(Performance estadisticasEq) {
		estadisticas.add(estadisticasEq);
	}
}

