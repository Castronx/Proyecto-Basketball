package logical;

public class Player {
	
	private String nombre;
	private String pais;
	private int edad;
	private float altura;
	private float peso;
	private int numero;
	private String posicion;
	private String equipo;
	private boolean lesion;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String nombre, String pais, int edad, float altura, float peso, int numero, String posicion,
			String equipo, boolean lesion) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
		this.numero = numero;
		this.posicion = posicion;
		this.equipo = equipo;
		this.lesion = lesion;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public boolean isLesion() {
		return lesion;
	}

	public void setLesion(boolean lesion) {
		this.lesion = lesion;
	}


}
