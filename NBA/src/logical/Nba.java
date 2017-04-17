package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Nba implements Serializable {
	
	private static final long serialVersionUID = 7492466070158751832L;
	private ArrayList<Team> misEquipos = new ArrayList<>();
	private ArrayList<Game> misJuegos = new ArrayList<>();
	private ArrayList<Player> misJugadores = new ArrayList<>();
	private ArrayList<Injury> misLesiones = new ArrayList<>();
	private static Nba enebea;

	public Nba() {
	}
	public Nba(ArrayList<Team> misEquipos, ArrayList<Game> misJuegos, ArrayList<Player> misJugadores, ArrayList<Injury> misLesiones) {
		super();
		this.misEquipos = new ArrayList<Team>();
		this.misJuegos = new ArrayList<Game>();
		this.misJugadores = new ArrayList<Player>();
		this.misLesiones = new ArrayList<Injury>();
	}
	//metodo singleton.
	public static Nba getInstances(){
		if(enebea == null){
			enebea = new Nba();
		}
		return enebea;	
	}
	public static void setLiga(Nba enbiei){
		Nba.enebea = enbiei;
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
	
	public ArrayList<Injury> getMisLesiones() {
		return misLesiones;
	}
	public void setMisLesiones(ArrayList<Injury> misLesiones) {
		this.misLesiones = misLesiones;
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
	//metodo de set partido.
	public void setPartido(int index, String equipoLocal, String equipoVisitante, String localizacion, String estadio, String hora, int marcadorLocal, int marcadorVisitante, String fecha, boolean jugado){
		misJuegos.set(index, new Game(equipoLocal, equipoVisitante, localizacion, estadio, hora, marcadorLocal, marcadorVisitante, fecha, jugado));
	}
	//fichero de cargar.
	public void cargarNba(Nba nba) {
		 try {
				 	FileInputStream f = new FileInputStream("Datoscargados.dat");
					ObjectInputStream ob = new ObjectInputStream(f);
					Nba nb = (Nba) ob.readObject();
					Nba.setLiga(nb);
					ob.close();
		 
			 } catch (Exception e) {	
				e.printStackTrace();
			}
		
}
	//fichero de guardar.
	public void guardarNba(Nba nba){
	 	 File f = new File("Datoscargados.dat");
		 FileOutputStream fo = null;
		 ObjectOutputStream ob = null;
		try {
			 fo = new FileOutputStream(f);
			 ob = new  ObjectOutputStream (fo);
			 ob.writeObject(nba);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(ob!= null){
					ob.close();
				}
					
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}

