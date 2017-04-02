package logical;

public class Injury {
	private Player jugador;
	private Team equipo;
	private String tipo;
	private String fecha;
	private String infoAdicional;
	private String recuperacion;

	public Injury(Player jugador, Team equipo, String tipo, String fecha, String infoAdicional, String recuperacion) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.infoAdicional = infoAdicional;
		this.recuperacion = recuperacion;
	}

	public Player getJugador() {
		return jugador;
	}

	public void setJugador(Player jugador) {
		this.jugador = jugador;
	}

	public Team getEquipo() {
		return equipo;
	}

	public void setEquipo(Team equipo) {
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
