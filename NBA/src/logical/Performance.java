package logical;

import java.io.Serializable;

public class Performance implements Serializable{
	
	private static final long serialVersionUID = 7135371189765182097L;
	private int tirosLibres;
	private int tirosTres;
	private int tirosCampo;
	private int puntoTotales;

	public Performance(int tirosLibres, int tirosTres, int tirosCampo) {
		super();
		this.tirosLibres = tirosLibres;
		this.tirosTres = tirosTres;
		this.tirosCampo = tirosCampo;
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
	public int getTirosCampo() {
		return tirosCampo;
	}
	public void setTirosCampo(int tirosCampo) {
		this.tirosCampo = tirosCampo;
	}
	public int getPuntoTotales() {
		return (tirosTres*3)+(tirosCampo*2)+(tirosLibres*1);
	}
	public void setPuntoTotales(int puntoTotales) {
		this.puntoTotales = puntoTotales;
	}
}
