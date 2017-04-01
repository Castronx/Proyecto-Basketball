package logical;

import java.util.ArrayList;


public class Nba {

	private ArrayList<Team> misEquipos;
	private ArrayList<Game> misJuegos;
	private ArrayList<Player> misJugadores;
	private ArrayList<Injury> misLesiones;
	private static Nba enebea;

	public Nba() {
		// TODO Auto-generated constructor stub
	}
	public Nba(ArrayList<Team> misEquipos, ArrayList<Game> misJuegos, ArrayList<Player> misJugadores, ArrayList<Injury> misLesiones) {
		super();
		this.misEquipos = new ArrayList<Team>();
		this.misJuegos = new ArrayList<Game>();
		this.misJugadores = new ArrayList<>();
		this.misLesiones = new ArrayList<>();
	}
	//metodo singleton.
	public static Nba getInstances(){
		if(enebea == null){
			enebea = new Nba();
		}
		return enebea;	
	}
	public ArrayList<Team> getMisEquipos() {
		return misEquipos;
	}
	public void setMisEquipos(ArrayList<Team> misEquipos) {
		this.misEquipos = misEquipos;
	}
	public ArrayList<Game> getMisJuegos() {
		return misJuegos;
	}
	public void setMisJuegos(ArrayList<Game> misJuegos) {
		this.misJuegos = misJuegos;
	}
	public ArrayList<Player> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Player> misJugadores) {
		this.misJugadores = misJugadores;
	}
	//metodo insertar equipo.
	public void insertarEquipo(Team equi){
		misEquipos.add(equi);
	}
	//metodo borrar equipo.
	public void eliminarEquipo (Team equi){
		misEquipos.remove(equi);
	}
	//metodo insertar partido.
	public void insertarPartido(Game jogo){
		misJuegos.add(jogo);
	}
	//metodo borrar partido.
	public void eliminarPartido(Game jogo){
		misJuegos.remove(jogo);
	}
	//metodo insertar lesion
	public void insertarLesion(Injury inju){
		misLesiones.add(inju);
	}
	//metodo borrar lesion
	public void eliminarLesion(Injury inju){
		misLesiones.remove(inju);
	}
	//metodo buscar jugador.
	public Player buscarJugador(String jugador){
		Player juga = null;
		for(Player var : misJugadores){
			if(var.getNombre().equalsIgnoreCase(jugador)){
				juga = var;
			}
		}
		return juga;
	}
	//metodo buscar equipo.
	public Team buscarEquipo(String equi){
		Team equipo = null;
		for(Team var : misEquipos){
			if(var.getNombreEquipo().equalsIgnoreCase(equi)){
				equipo = var;
			}
		}
		return equipo;
	}
}

