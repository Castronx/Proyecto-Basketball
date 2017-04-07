package logical;

import java.io.Serializable;

public class Injury implements Serializable {

	private static final long serialVersionUID = 2202017412633310866L;
	private String jugador;
	private String equipo;
	private String tipo;
	private String fecha;
	private String infoAdicional;
	private String recuperacion;
	
	public Injury(String jugador, String equipo, String tipo, String fecha, String infoAdicional, String recuperacion) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.infoAdicional = infoAdicional;
		this.recuperacion = recuperacion;
	}
	public String getJugador() {
		return jugador;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	public String getRecuperacion() {
		return recuperacion;
	}
	public void setRecuperacion(String recuperacion) {
		this.recuperacion = recuperacion;
	}
}
