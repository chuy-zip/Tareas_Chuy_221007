package model;

/**
 * Esta es la clase perro, esta clase es para crear objetos que representan a 
 * los perros que necesitan un hogar temporal, debido a el accidente con la perrera. 
 * @author Ricardo Chuy 221007
 */
public class Perro {
	private String Tamanio;
	private String Raza;
	private int Edad;
	private int EstadoSalud;
	private String Color;
	private String Nombre;
	
	/**
	 * Constructor del objeto perro que reicbe los valores de
	 * @param _proporcion Variable de tipo string que almacena el tamaño del perro, si es grande, mediano o pequeño.
	 * @param _nomRaza Variable tipo string para guardar la raza del perro.
	 * @param _edad Variable tipo entero para almacenar la edad en meses del perro.
	 * @param _salud Variable tipo entero que almacena el valor de la salud del perro.
	 * @param _color Variable de tipo string que guarda el color del perro.
	 * @param _nombre Variable que guarda el nombre del perro del que se están ingresando los datos.
	 */
	
	public Perro(String _proporcion, String _nomRaza, int _edad, int _salud, String _color, String _nombre){
		setTamanio(_proporcion);
		setRaza(_nomRaza);
		setEdad(_edad);
		setEstadoSalud(_salud);
		setColor(_color);
		setNombre(_nombre);
	}
	/**
	 * Metodo para obtener el tamaño del perro
	 * @return Tamaño del perro, valor de tipo String
	 */
	public String getTamanio() {
		return Tamanio;
	}
	
	/**
	 * Metodo para actualizar el tamaño del perro
	 * @param tamanio de tipo string, del perro 
	 */
	public void setTamanio(String tamanio) {
		Tamanio = tamanio;
	}
	
	/**
	 * Metodo para obtener la raza del perro
	 * @return raza, de tipo string, del perro 
	 */
	public String getRaza() {
		return Raza;
	}
	
	/**
	 * Metodo para cambiar la raza del perro
	 * @param raza del perro, de tipo string
	 */
	public void setRaza(String raza) {
		Raza = raza;
	}
	
	/**
	 * Metodo para obtener la edad del perro
	 * @return Edad del perro, de tipo int
	 */
	public int getEdad() {
		return Edad;
	}
	
	/**
	 * Metodo para cambiar la edad del perro
	 * @param edad a la que se quiere cambiar, tipo int
	 */
	public void setEdad(int edad) {
		Edad = edad;
	}

	/**
	 * Metodo para obtener la Salud del perro, de tipo entero
	 * @return EstadoSalud del perro, valor de tipo entero
	 */
	public int getEstadoSalud() {
		return EstadoSalud;
	}

	/**
	 * Metodo para cambiar el valor de la sauld del perro, tipo entero
	 * @param estadoSalud a la que se quiere cambiar, tipo entero
	 */
	public void setEstadoSalud(int estadoSalud) {
		EstadoSalud = estadoSalud;
	}
	
	/**
	 * Metodo para obtener el color el perro, tipo string
	 * @return Color del perro, de tipo string
	 */
	public String getColor() {
		return Color;
	}
	
	/**
	 * Metodo para cambiar el color del perro
	 * @param color al que se quiere cambiar al perro, de tipo int
	 */
	public void setColor(String color) {
		Color = color;
	}
	
	/**
	 * Metodo para obtener el nombre del perro
	 * @return Nombre del perro, tipo String
	 */
	public String getNombre() {
		return Nombre;
	}
	
	/**
	 * Metodo para cambiar el nombre del perro
	 * @param nombre al que se quiere cambiar, tipo string
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	/**
	 * Metodo para poder sobreescribir el metodo toString() y poder mostrar las caracteristicas del objeto dentro del arrayList
	 */
	public String toString() {
		return("\nNombre del Perro: " + getNombre() +
				"\nTamanio del Perro: "  + getTamanio() +
				"\nRaza del Perro: " + getRaza() +
				"\nEdad del Perro: " + getEdad() +
				"\nSalud del Perro: " + getEstadoSalud() +
				"\nColor del Perro: " + getColor());
	}
	
}
