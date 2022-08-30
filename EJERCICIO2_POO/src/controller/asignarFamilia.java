package controller;
import model.Perro;
import model.Familia;

/**
 * Clase asignarFamilia, esta clase ayuda a poder verificar la comptaibilidad de un perro con cualquier de las 3 familias
 * @author Ricardo Chuy 221007
 *
 */
public class asignarFamilia {
	/**
	 * Este controlador tiene una lista que contiene los nombres de razas perligrosas, 
	 * que tipo de familia es la familia con la que se usa, cantidad de familiares pequeños y grandes
	 * la cantidad de mascotas  que tiene la familia y una variable donde se guarda el error al no poder asignar el perro.
	 */
	private String[] RazasPeligrosas = new String[17];
	private int numFamTipo;
	private int FamiliaresPeq;
	private int FamiliaresMed;
	private int MascotasFam;
	private String ErrorAsig;
	
	/**
	 * El constrocutor del controlador, para poder obtener los datos necesarios para comparar a la familia con 1 perro
	 * Se crean 3 diferentes metodos, uno por cada familia en el driver program
	 * @param _familia La familia de la cual se desean obtener los datos
	 */
	public asignarFamilia(Familia _familia) {
		RazasPeligrosas[0] = "pit bull terrier";
		RazasPeligrosas[1] = "american staffordshire terrier";
		RazasPeligrosas[2] = "tosa inu";
		RazasPeligrosas[3] = "dogo argentino";
		RazasPeligrosas[4] = "dogo guatemalteco";
		RazasPeligrosas[5] = "fila brasileño";
		RazasPeligrosas[6] = "presa brasileño";
		RazasPeligrosas[7] = "doberman";
		RazasPeligrosas[8] = "gran perro japones";
		RazasPeligrosas[9] = "mastin napolitano";
		RazasPeligrosas[10] = "presa mallorqui";
		RazasPeligrosas[11] = "dogo de burdeos";
		RazasPeligrosas[12] = "bullmastiff";
		RazasPeligrosas[13] = "bul terrier ingles";
		RazasPeligrosas[14] = "bulldog americano";
		RazasPeligrosas[15] = "rhodesiano";
		RazasPeligrosas[16] = "rottweiler";
	
		FamiliaresPeq = _familia.getNumPequeniosFam();
		FamiliaresMed = _familia.getNumGrandesFam();
		MascotasFam = _familia.getNumMascotasAsig();
		
	}
	
	/**
	 * Metodo que indica si la familiaaun tiene espacio disponible para adoptar
	 * @return verdadero si hay menos de 4 perros adoptados, sino regresa falso
	 */
	public boolean HayEspacio() {
		if(MascotasFam <= 3) {
			return true;
		}
		ErrorAsig = "No pudo asignarse el perro debido a que la familia ya cuenta con 4 adopciones";
		return false;
	}
	
	/**
	 * Este metodo no asigna al perro, lo que hace es verificar con cual de las 3 familias (comenzando por la familia 1)
	 * , es compatible con el perro en base a condiciones especificas. Regresa un entero al programa principale, el
	 * cual indica a cual de las 3 familias se puede asignar el perro.
	 * Tambien se puede dar el caso de que no se pueda asignar al perro
	 * @param El perro el cual desea asignarse a una de las 3 familias
	 * @return numFamTipo, una variable que indica a cual familia de las 3 se puede asignar
	 */
	public int CompatibilidadPerro(Perro _chucho) {
		/**
		 * Condicion para la familia 1: Se tiene niños pequeños, perro es pequeño y el perro no es de raza peligrosa
		 */
		if (FamTienePeq(FamiliaresPeq) == true && _chucho.getTamanio().equals("pequeño") && PerroEsPeligro(_chucho.getRaza()) == false) {
			numFamTipo = 1;
		}
		/**
		 * Condicion para la familia 2: Se tiene niños grandes, perro no es grandey el perro no es de raza peligrosa
		 */
		else if (FamTieneMed(FamiliaresMed) == true && perroEsGrande(_chucho.getTamanio()) == false && PerroEsPeligro(_chucho.getRaza()) == false) {
			numFamTipo = 2;
		}
		/**
		 * No se tiene niños pequeños ni grandes (sin niños).
		 */
		else if (FamTienePeq(FamiliaresPeq) == false && FamTieneMed(FamiliaresMed) == true) {
			numFamTipo = 3;
		}
		ErrorAsig = "El perro no pudo asignarse a ninguna familia";
		return numFamTipo;
		
	}
	/**
	 * Metodo para determinar si hay niños peueños
	 * @param peques, la cantidad de niños pequeños en la familia
	 * @return verdadero su hay niños pequeños o falso si no hay
	 */
	public boolean FamTienePeq(int peques) {
		if(peques > 0) {
			return true;
		}
		else {
			return false;	
		}
	}
	
	/**
	 * Metodo para determinar si hay niños grandes
	 * @param Medianos, la cantidad de niños mayores de 10 años en la familia
	 * @return verdadero si hay niños pequeños o falso si no hay
	 */
	public boolean FamTieneMed(int Medianos) {
		if(Medianos > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Metodo para determinar si la raza del perro pertenece a una peligrosa
	 * @param _raza, la raza del perro que se desea asignar
	 * @return Verdadero si la raza es peligrosa, falso si no loes
	 */
	public boolean PerroEsPeligro(String _raza) {
		for (int i = 0; i <= RazasPeligrosas.length - 1; i++) {
			if (_raza.equals(RazasPeligrosas[i])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para saber si el perro es grande
	 * @param _proporcion, el tamaño del perro que se desea analizar
	 * @return verdadero si el tamaño es "grande" y falso si es cualquier otro tamaño
	 */
	public boolean perroEsGrande(String _proporcion) {
		if (_proporcion.equals("grande")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para guardar y obtener un mensaje de error
	 * @return El mensaje de error si falla la asignacion
	 */
	public String ErrorAsignarFam() {
		return ErrorAsig; 
	}
	
}
