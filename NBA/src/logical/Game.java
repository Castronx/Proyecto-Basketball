package logical;

import java.io.Serializable;

public class Game implements Serializable{
	
	private static final long serialVersionUID = 1703111886027154880L;
	private  String equipoLocal;
	private String equipoVisitante;
	private String localizacion;
	private String estadio;
	private String hora;
	private int marcadorLocal;
	private int marcadorVisitante;
	private String fecha;
	private boolean jugado;
	
	public Game() {
	}
	public Game(String equipoLocal, String equipoVisitante, String localizacion, String estadio, String hora, int marcadorLocal, int marcadorVisitante, String fecha, boolean jugado) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.localizacion = localizacion;
		this.estadio = estadio;
		this.hora = hora;
		this.marcadorLocal = marcadorLocal;
		this.marcadorVisitante = marcadorVisitante;
		this.fecha = fecha;
		this.jugado = jugado;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getMarcadorLocal() {
		return marcadorLocal;
	}
	public void setMarcadorLocal(int marcadorLocal) {
		this.marcadorLocal = marcadorLocal;
	}
	public int getMarcadorVisitante() {
		return marcadorVisitante;
	}
	public void setMarcadorVisitante(int marcadorVisitante) {
		this.marcadorVisitante = marcadorVisitante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isJugado() {
		return jugado;
	}
	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}
}