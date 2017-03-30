package logical;

import java.util.ArrayList;


public class nba {

	private ArrayList<team> misEquipos;
	private ArrayList<game> misJuegos;
	private ArrayList<player> misJugadores;
	private static nba enebea;
	//hola


	public nba() {
		// TODO Auto-generated constructor stub
	}
	public nba(ArrayList<team> misEquipos, ArrayList<game> misJuegos) {
		super();
		this.misEquipos = new ArrayList<team>();
		this.misJuegos = new ArrayList<game>();
		this.misJugadores = new ArrayList<>();
	}
	//metodo singleton.
	public static nba getInstances(){
		if(enebea == null){
			enebea = new nba();
		}
		return enebea;	
	}
	public ArrayList<team> getMisEquipos() {
		return misEquipos;
	}
	public void setMisEquipos(ArrayList<team> misEquipos) {
		this.misEquipos = misEquipos;
	}
	public ArrayList<game> getMisJuegos() {
		return misJuegos;
	}
	public void setMisJuegos(ArrayList<game> misJuegos) {
		this.misJuegos = misJuegos;
	}
	public ArrayList<player> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<player> misJugadores) {
		this.misJugadores = misJugadores;
	}
	//metodo insertar equipo.
	public void insertarEquipo(team equi){
		misEquipos.add(equi);
	}
	//metodo borrar equipo.
	public void eliminarEquipo (team equi){
		misEquipos.remove(equi);
	}
	//metodo insertar partido.
	public void insertarPartido(game jogo){
		misJuegos.add(jogo);
	}
	//metodo borrar partido.
	public void eliminarPartido(game jogo){
		misJuegos.remove(jogo);
	}
	//metodo buscar jugador.
	public player buscarJugador(String jugador){
		player juga = null;
		for(player var : misJugadores){
			if(var.getNombre().equalsIgnoreCase(jugador)){
				juga = var;
			}
		}
		return juga;
	}
	//metodo buscar equipo.
	public team buscarEquipo(String equi){
		team equipo = null;
		for(team var : misEquipos){
			if(var.getNombreEquipo().equalsIgnoreCase(equi)){
				equipo = var;
			}
		}
		return equipo;
	}
}
