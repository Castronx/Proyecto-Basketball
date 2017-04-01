package logical;

public class Injury {
	private String nombreJugador;
	private String equipo;
	private String tipo;
	private String fecha;
	private String infoAdicional;
	private String recuperacion;

	public Injury() {
		// TODO Auto-generated constructor stub
	}
	public Injury(String nombreJugador, String equipo, String tipo, String fecha, String infoAdicional, String recuperacion) {
		super();
		this.nombreJugador = nombreJugador;
		this.equipo = equipo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.infoAdicional = infoAdicional;
		this.recuperacion = recuperacion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
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
