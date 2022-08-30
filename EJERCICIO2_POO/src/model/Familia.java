package model;
import java.util.ArrayList;
import model.Perro;
import java.util.ArrayList;
/**
 * Clase familia, hecha para poder asignar hasta un maximo de 4 perros por familia
 * @author Ricardo CHuy 221007andre
 *
 */
public class Familia {
	private String ApellidoFamilia;
	private int NumFamiliares;
	private int NumPequeniosFam;
	private int NumGrandesFam;
	private int NumMascotasAsig;
	private ArrayList<Perro> perrosAdoptados;
	/**
	 * Valores que recibe el constructor de familia
	 * @param _apellido, el apellido de la familia
	 * @param _integrantes, el numero de personas que conforman la familia
	 * @param _numPeq, numero de personas menores a 10 años
	 * @param _numGran, numero de personas mayores a 10 años
	 * @param _adoptados, cantidad de perros adoptados
	 */
	
	public Familia(String _apellido, int _integrantes, int _numPeq, int _numGran, int _adoptados){
		setApellidoFamilia(_apellido);
		setNumFamiliares(_integrantes);
		setNumPequeniosFam(_numPeq);
		setNumGrandesFam(_numGran);
		setNumMascotasAsig(_adoptados);
		perrosAdoptados = new ArrayList<Perro>();
	}
	
	/**
	 * Metodo para obtener el apellido de la familia
	 * @return apellido, de la familia
	 */
	public String getApellidoFamilia() {
		return ApellidoFamilia;
	}
	
	/**
	 * Metodo para cambiar el apellido de la familia
	 * @param apellidoFamilia, de tipo string
	 */
	public void setApellidoFamilia(String apellidoFamilia) {
		ApellidoFamilia = apellidoFamilia;
	}
	/**
	 * Metodo para cambiar el numero de integrantes de la familia
	 * @return NumFamiliares, cantidad de integrantes
	 */
	public int getNumFamiliares() {
		return NumFamiliares;
	}
	/**
	 * Metodo para cambiar la cantidad de integrantes
	 * @param numFamiliares, cantidad de integrantes a la que se quiere cambiar
	 */
	public void setNumFamiliares(int numFamiliares) {
		NumFamiliares = numFamiliares;
	}
	
	/**
	 * Obtener el numero de personas menores de 10 años dentro de la familia
	 * @return NumPequenios, personas pequeñas de la familia
	 */
	public int getNumPequeniosFam() {
		return NumPequeniosFam;
	}
	/**
	 * Metodo para cambiar el numoer de integrantes pequeños de la familia
	 * @param numPequeniosFam
	 */
	public void setNumPequeniosFam(int numPequeniosFam) {
		NumPequeniosFam = numPequeniosFam;
	}

	/**
	 * Metodo para obtener el numero de integrantes de la familia mayores de 10 años
	 * @return NumGrandesFam, personas mayores de 10 años
	 */
	public int getNumGrandesFam() {
		return NumGrandesFam;
	}

	/**
	 * Cambiar el numero de personas mayores de 10 años de la familia
	 * @param numGrandesFam, la cantidad nueva de personas mayores a 10 años
	 */
	public void setNumGrandesFam(int numGrandesFam) {
		NumGrandesFam = numGrandesFam;
	}
	
	/**
	 * Obtener el numero de perros adoptados que tiene la familia
	 * @return NumMascotasAsig, cantidad de perros adoptados, tipo int
	 */
	public int getNumMascotasAsig() {
		return NumMascotasAsig;
	}

	/**
	 * Metodo para cambiar la cantidad de mascotas, sumandole 1
	 * @param numMascotasAsig, este esun valor entero, que se seume a la cantidad previa de numero de mascotas
	 */
	public void setNumMascotasAsig(int numMascotasAsig) {
		NumMascotasAsig += numMascotasAsig;
	}
	
	/**
	 * Metodo para obtener la lista de perros adoptados por la familia
	 * @return
	 */
	public ArrayList<Perro> getPerrosAdoptados() {
		return perrosAdoptados;
	}

	/**
	 * Metodo para cambiar la lista de perros adoptados por la familia
	 * @param perrosAdoptados
	 */
	public void setPerrosAdoptados(ArrayList<Perro> perrosAdoptados) {
		this.perrosAdoptados = perrosAdoptados;
	}
	
	/**
	 * Metodo para poder sobreescribir el metodo toString() y poder mostrar las caracteristicas del objeto dentro del arrayList
	 */
	public String toString() {
		return("\nApellido de la Famila: " + getApellidoFamilia() +
				"\nCantidad de integrantes: "  + getNumFamiliares() +
				"\nMenores de 10 años en la familia: " + getNumPequeniosFam() +
				"\nMayores de 10 años en la familia " + getNumGrandesFam() +
				"\nCantidad de perros: " + getNumMascotasAsig() +
				"\nPerros Adoptados: " + getPerrosAdoptados()
				);
	}

}
