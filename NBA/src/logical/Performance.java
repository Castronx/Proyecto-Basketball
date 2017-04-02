package logical;

public class Performance{
	private Player jugador;
	private Team equipo;
	private int asistencias;
	private int tirosLibres;
	private int tirosTres;
	private int rebotes;
	private int robos;
	private int tirosCampo;
	private int balonesPerdidos;


	public Performance(Player jugador, Team equipo, int asistencias, int tirosLibres, int tirosTres, int rebotes, int robos, int tirosCampo,
			int balonesPerdidos) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.asistencias = asistencias;
		this.tirosLibres = tirosLibres;
		this.tirosTres = tirosTres;
		this.rebotes = rebotes;
		this.robos = robos;
		this.tirosCampo = tirosCampo;
		this.balonesPerdidos = balonesPerdidos;
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

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getTirosLibres() {
		return tirosLibres;
	}

	public void setTirosLibres(int tirosLibres) {
		this.tirosLibres = tirosLibres;
	}

	public int getTirosTres() {
		return tirosTres;
	}

	public void setTirosTres(int tirosTres) {
		this.tirosTres = tirosTres;
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public int getRobos() {
		return robos;
	}

	public void setRobos(int robos) {
		this.robos = robos;
	}

	public int getTirosCampo() {
		return tirosCampo;
	}

	public void setTirosCampo(int tirosCampo) {
		this.tirosCampo = tirosCampo;
	}

	public int getBalonesPerdidos() {
		return balonesPerdidos;
	}

	public void setBalonesPerdidos(int balonesPerdidos) {
		this.balonesPerdidos = balonesPerdidos;
	}

}