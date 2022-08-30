package ui;
import model.Perro;
import model.Familia;
import controller.asignarFamilia;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Driver Program, clase principal para ejecutar el programa y mostrar los elementos de interfaz gráfica en la consola
 * El programa tiene como funcion asignar perros a familias con las que son compatibles. Solo hay 3 familias a 
 * las que se puede asignar perros y cada una de estas unicamente puede tener 4 perros.
 * No hay limite de perros, estos se guardan dentro de un arreglo dinámico, al igual que las 3 familias se guardan en otro.
 * Para saignar a lso perros, siempre se tomará la información del último perro ingresado por el usuario.
 * Cada vez que se logra asignar un perro, este se borra de la lista de perros y se añade a la lista de perros adoptados de la familia
 * a la que se le asignó. AL igual si un perro no es asignable a ninguna de las familias se descarta también.
 * @author Ricardo Andrés Chuy Morales
 *
 */
public class Driver_Program {
	/**
	 * Lisstas de familias y perros
	 */
	private static ArrayList<Perro> ListaPerros;
	private static ArrayList<Familia> ListaFamilias;
	
	public static void main(String[] args) {
		String opcion = "";
		Scanner escaner = new Scanner(System.in);
		
		ListaPerros = new ArrayList<Perro>();
		ListaFamilias = new ArrayList<Familia>();
		
		System.out.println("Gracias por usar el programa para dar refugio temporalmente a perros");
		System.out.println("Por favor ingresa la información de las familias");
		
		/**
		 * Ciclo para pedir los datos de 3 familias al iniciar el programa
		 */
		for (int i = 0; i <= 2; i++) {
			ListaFamilias.add(IngresarDataFamilias(escaner));
			System.out.println("\n");
		}
		
		/**
		 * Se crean 3 metodos, 1 para hacer comparaciones con cada familia
		 */
		asignarFamilia Familia_1 = new asignarFamilia(ListaFamilias.get(0));
		asignarFamilia Familia_2 = new asignarFamilia(ListaFamilias.get(1));
		asignarFamilia Familia_3 = new asignarFamilia(ListaFamilias.get(2));
		
		/**
		 * Ciclo para que el programa termine solo cuando se ingresa una opcion específica
		 */
		while (!opcion.equals("5")) {
			menu();
			opcion = escaner.nextLine();
			
			/**
			 * Si la opcion elegida es 1, se ingresan los datos de un nuevo perro a la lista
			 */
			if(opcion.equals("1")) {
				ListaPerros.add(IngresarDataPerros(escaner));
			}
			/**
			 * Si la opcion elegida es 2, se muestran los perros que se tienen guardados
			 */
			else if(opcion.equals("2")) {
				for (int i = 0; i < ListaPerros.size(); i++) {
					System.out.println(ListaPerros.get(i));
				}	
			}
			/**
			 * Si la opcion elegida es 3, se muestran las familias guardadasy sus datos (Incluyendo los perros adoptados)
			 */
			else if(opcion.equals("3")) {
				for (int i = 0; i < ListaFamilias.size(); i++) {
					System.out.println(ListaFamilias.get(i));
				}
			}
			/**
			 * Si la opcion elegida es 4, se intentará asignar a un perro a una de las 3 familias
			 * Luego de comparar la comptabilidad del ultimo perro ingresado, se evalua si la familia tiene
			 * espacio para adoptar, si hay espacio se asigna el perro a la familia y se elimina de la lista de perros
			 * sino, se manda un mensaje de error que no se pudo asignar a una familia en especifico debido al espacio.
			 * Ademas se le añade 1 a la cuenta de mascotas de cada familia
			 */
			else if(opcion.equals("4")) {
				System.out.println("4");
				
				if(Familia_1.CompatibilidadPerro(ListaPerros.get(ListaPerros.size()-1)) == 1){
					
					if(Familia_2.HayEspacio()) {

						System.out.println("La familia 1 es comptaible, se ha asignado el perro");
						ListaFamilias.get(0).getPerrosAdoptados().add(ListaPerros.get(ListaPerros.size()-1));
						ListaPerros.remove(ListaPerros.size()-1);
						ListaFamilias.get(0).setNumMascotasAsig(1);	
					}
					else{
						System.out.println(Familia_1.ErrorAsignarFam());
					}
					
				}
				
				else if(Familia_2.CompatibilidadPerro(ListaPerros.get(ListaPerros.size()-1)) == 2) {
					
					if(Familia_2.HayEspacio()) {
						System.out.println("La familia 2 es comptaible, se ha asignado el perro");
						ListaFamilias.get(1).getPerrosAdoptados().add(ListaPerros.get(ListaPerros.size()-1));
						ListaPerros.remove(ListaPerros.size()-1);
						ListaFamilias.get(1).setNumMascotasAsig(1);
					}
					
					else{
						System.out.println(Familia_2.ErrorAsignarFam());
					}
					
				}
				
				else if(Familia_3.CompatibilidadPerro(ListaPerros.get(ListaPerros.size()-1)) == 3) {
					
					if(Familia_3.HayEspacio()){
						System.out.println("La familia 3 es comptaible, se ha asignado el perro");
						
						ListaFamilias.get(2).getPerrosAdoptados().add(ListaPerros.get(ListaPerros.size()-1));
						ListaPerros.remove(ListaPerros.size()-1);
						ListaFamilias.get(2).setNumMascotasAsig(1);
						
					}
					
					else {
						System.out.println(Familia_3.ErrorAsignarFam());
					}
					
				}
				/**
				 * En el caso de que el perro no se pueda asignar a ninguna de las 3 familias, se elimina de la lista,
				 * ya que no puede ser asignado y se dejará de tomar en cuentra, pero no es asignado
				 */
				else{
					
					ListaPerros.remove(ListaPerros.size()-1);
					System.out.println("El perro no pudo asignarse a ninguna familia, no se tomará en cuenta por el momento");						
				}
			}
			/**
			 * Opcion para salir del programa
			 */
			else if(opcion.equals("5")) {
				System.out.println("Gracias por usar el programa, feliz día");
			
			}	
		}	
	}	
	
	/**
	 * Metodo para ingresar datos y crear perros
	 * @param escaner, para poder leer datos del usuario
	 * @return regresa a un nuevo perro que sera añadido a la lista
	 */
	public static Perro IngresarDataPerros(Scanner escaner) {
		Perro perro;
		System.out.println("Ingrese el Nombre del perro");
		String nombrePerro = escaner.nextLine();
		
		System.out.println("¿El perro es pequeño, mediano o grande?");
		String tamanioPerro = escaner.nextLine();
		
		System.out.println("¿Cual es la raza del perro?");
		String razaPerro = escaner.nextLine();
		
		System.out.println("¿Cual es el color del perro?");
		String colorPerro = escaner.nextLine();
		
		System.out.println("¿Cual es la edad (en meses) del perro?");
		int edadPerro = Integer.parseInt(escaner.nextLine());
		
		System.out.println("Del 0 al 100, ¿Como considera la salud del perro?");
		int saludPerro = Integer.parseInt(escaner.nextLine());
		
		perro = new Perro(tamanioPerro, razaPerro, edadPerro, saludPerro, colorPerro, nombrePerro);
		return perro;
	}
	/**
	 * Metodo para ingresar informacion de 1 familia y añadirla a la lista de familias
	 * @param escaner para poder leer los datos del usuario
	 * @return Familia que se añadira a la lista
	 */
	public static Familia IngresarDataFamilias(Scanner escaner) {
		Familia Familia;
		System.out.println("¿Cual es apellido de la familia?");
		String apellidoFam = escaner.nextLine();
		
		System.out.println("¿Cuantas personas son en la familia?");
		int integrantesFam = Integer.parseInt(escaner.nextLine());
		
		System.out.println("¿Cuantas personas dentro de la familia son menores de 10 años?");
		int pequesFam = Integer.parseInt(escaner.nextLine());
		
		System.out.println("¿Cuantas personas dentro de la familia son mayores de 10 años?");
		int grandesFam = Integer.parseInt(escaner.nextLine());
		
		System.out.println("¿Cuantas perros ya tienen adoptados temporalmente?");
		int adopcionesFam = Integer.parseInt(escaner.nextLine());
		
		Familia = new Familia(apellidoFam, integrantesFam, pequesFam, grandesFam, adopcionesFam);
		
		return Familia;
	}
	
	/**
	 * Menu que muestra las opciones al usuario
	 */
	public static void menu() {
		System.out.println("Escribe el numero de la acción que deseas realizar");
		System.out.println("1. Ingresar datos de un nuevo perro");
		System.out.println("2. Mostrar datos de los perros dentro de la perrera");
		System.out.println("3. Mostrar datos de las familias y sus adpociones");
		System.out.println("4. Asignar el ultimo perro ingresado a una familia");
		System.out.println("5. Salir del programa");
	}
	
}
