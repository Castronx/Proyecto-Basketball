package logical;

import java.io.Serializable;

public class Performance implements Serializable{
	
	private static final long serialVersionUID = 7135371189765182097L;
	private int asistencias;
	private int tirosLibres;
	private int tirosTres;
	private int rebotes;
	private int robos;
	private int tirosCampo;
	private int balonesPerdidos;
	private int puntoTotales;

	public Performance(int asistencias, int tirosLibres, int tirosTres, int rebotes, int robos, int tirosCampo,
			int balonesPerdidos) {
		super();
		this.asistencias = asistencias;
		this.tirosLibres = tirosLibres;
		this.tirosTres = tirosTres;
		this.rebotes = rebotes;
		this.robos = robos;
		this.tirosCampo = tirosCampo;
		this.balonesPerdidos = balonesPerdidos;
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
	public int getPuntoTotales() {
		return (tirosTres*3)+(tirosCampo*2)+(tirosLibres*1);
	}
	public void setPuntoTotales(int puntoTotales) {
		this.puntoTotales = puntoTotales;
	}
}
