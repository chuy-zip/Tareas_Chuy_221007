package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controler.Library_Admin;
import model.Article;
import model.book;
import model.client;
import model.documents;
import model.magazine;

/**
 * Clase driver program para mostrar todos los resultados procesados y recibir informacion
 * @author Ricardo Chuy
 *
 */
public class DriverProgram {
	
	private static ArrayList<client> ListOfClientes;
	private static ArrayList<documents> AvailableDocuments;
	
	public static void main(String[] args) {
		
		ListOfClientes = new ArrayList<client>();
		AvailableDocuments = new ArrayList<documents>();
		
		Library_Admin Adminisitrator= new Library_Admin(ListOfClientes, AvailableDocuments);
		
		Scanner Strscaner = new Scanner(System.in);
		String option = "";
		
		
		while(!option.equals("9")) {
			showMenu();
			option = "" + Strscaner.nextInt();
			
			if(option.equals("1")) {
				getDocumentInfo(Strscaner, AvailableDocuments);
				
			}
			
			else if(option.equals("2")) {
				System.out.println("Por favor ingrese el ID del documento");
				String givenID = Strscaner.next();
				
				String DocumentName = Adminisitrator.getTitleFromID(AvailableDocuments, givenID);
				
				if (DocumentName != null) {
					System.out.println("El titulo del documento es: " + DocumentName);
				}
				else {
					System.out.println("El ID ingresado no se encuentra en la biblioteca\n");
				}
				
			}
			
			else if(option.equals("3")) {
				System.out.println("Por favor ingrese el Tema del que desea saber la cantidad");
				String givenTitle = Strscaner.next();
				
				int QtyOfSpecificTitle = Adminisitrator.QtyDocsByTopic(AvailableDocuments, givenTitle);
				
				System.out.println("Hay: " + QtyOfSpecificTitle + " documentos para el Tema/Materia: " + givenTitle);
				
			}
			
			else if(option.equals("4")) {
				System.out.println("Op 4");
				client cliente;
				
				System.out.println("Por favor ingrese el ID del cliente");
				String clientID = Strscaner.next(); 
				
				client ExistingClient = Adminisitrator.clientExists(ListOfClientes, clientID);
				
				if(ExistingClient == null) {
					System.out.println("No se encontro un usuario con ese ID, se agregara un nuevo cliente");
					ExistingClient = addNewClient(ListOfClientes, Strscaner, clientID);
					
				}
				
				System.out.println("Por favor ingrese el ID del documento que desea tomar prestado");
				String requiredbookID = Strscaner.next();
					
				boolean availability = Adminisitrator.BookIsAvailable(AvailableDocuments, requiredbookID);
				System.out.println(availability);
				
				if (availability == true && ExistingClient.getBorrowedQty() <= 5) {
					Adminisitrator.borrowBook(AvailableDocuments, ExistingClient, requiredbookID);
					ListOfClientes.add(ExistingClient);
						
				}
				else if(ExistingClient.getBorrowedQty() == 5){
					System.out.println("No se puede rentar el libro");
				}
				
				else if(availability == false) {
					System.out.println("Ese libro no esta disponible o no existe");
				}
				
			}
			
			else if(option.equals("5")) {
				System.out.println("Ingrese el ID del cliente");
				String clientID = Strscaner.next();
				
				System.out.println("Ingrese el ID del libro a regresar");
				String ReturnDocID = Strscaner.next();
				
				client cliente = Adminisitrator.clientExists(ListOfClientes, clientID);
				boolean bookExists = Adminisitrator.BookExists(AvailableDocuments, ReturnDocID);
				
				if(cliente != null && bookExists == true) {
					for (client aClient:ListOfClientes) {
						if(aClient.getIDClient().equals(cliente.getIDClient()) ) {
							Adminisitrator.returnBook(AvailableDocuments, aClient, ReturnDocID);
							System.out.println("Se ha regresado el libro");
						}
					}
				}
				
				else {
					System.out.println("No se ha podido regresar el libro el ID del cliente y/o el del libro es incorrecto");
				}
				
				
			}
			
			else if(option.equals("6")) {
				System.out.println("Ingrese el ID del cliente");
				String clientID = Strscaner.next();
				
				client cliente = Adminisitrator.clientExists(ListOfClientes, clientID);
				Adminisitrator.showQtyOfEachDoc(cliente);
			}
			
			else if(option.equals("7")) {
				System.out.println("Escriba el tema del cual se quiere buscar");
				String requestedTopic = Strscaner.next();
				
				int QtyForTopic = Adminisitrator.MagazineQtyBySpecificTopic(AvailableDocuments, requestedTopic);
				System.out.println("En total hay: " + QtyForTopic + " documentos para el tema de revista: " + requestedTopic);
			}
			
			else if(option.equals("8")) {
				System.out.println("Escribe el ID del libro o articulo");
				String DocID = Strscaner.next();
				
				boolean availability = Adminisitrator.IsBookOrMAgazineAvailable(AvailableDocuments, DocID);
				
				if(availability == true) {
					System.out.println("El Documento con la ID: " + DocID + ", Se encunetra Disponible");
				} 
				
				else {
					System.out.println("No se encontro un libro o articulo con ese ID");
				}
			}
			
			Adminisitrator.ShowAvailableDocs(AvailableDocuments);
		}
		
	}
	/**
	 * Mostrar el menu con todas las opciones del programa
	 */
	public static void showMenu(){
		System.out.println("Bienvenido al program de librer?a. Ingrese el numero de opcion a realizar\n");
		System.out.println("1.Agregar un Documento \n"+
							"2.Buscar nombre de un libro por medio de su ID \n" +
							"3.Cantidad de documentos por Materia/Tema \n"+
							"4.Tomar Un libro prestado (Con numero de ID)\n"+
							"5.Devolver Un libro\n"+
							"6.Ingresar ID de un Cliente y conocer la cantidad de cada Tipo de Documentos Prestados \n" +
							"7.Cantidad de revistas por Tema Disponibles\n"+
							"8.Ingresar un libro o art?culo para revisar disponibilidad\n"+
							"9.Salir\n");
	}
	/*
	 * Obtener la informacion para crear un nuevo documento (se pide informacion un tanto diferente en funcino del tipo del documento)
	 */
	public static void getDocumentInfo(Scanner _strScan, ArrayList<documents> _availableDocuments) {
		
		book libro;
		Article articulo;
		magazine revista;
		String docID;
		String docTitle;
		String docAuthor;
		String docEditorial;
		String docTopic;
		String docArbit;
		int docQty;
		int docYear;
		int docVersion;
		boolean Available = true;
		String BorrowDate = "-";
		String ReturnDate = "-";
		
		System.out.println("Que tipo de documento se desea aniadir: \n"+
							"1.Libro\n" +
							"2.Articulo\n" +
							"3.Revista");
		String docType = _strScan.next();
		
		if (docType.equals("1")) {
			System.out.println("Ingrese el ID del documento ");
			docID = _strScan.next();
			
			System.out.println("Ingrese el titulo del documento");
			docTitle = _strScan.next();
			
			System.out.println("Ingrese el autor del documento");
			docAuthor = _strScan.next();
			
			System.out.println("Ingrese la editorial del documento");
			docEditorial = _strScan.next();
		
			System.out.println("Ingrese el Tema/Materia del libro");
			docTopic = _strScan.next();
			
			System.out.println("Ingrese la cantidad de documentos");
			docQty = Integer.parseInt(_strScan.next());
			
			libro = new book(docID, docTitle, docAuthor, docEditorial, docTopic, docQty, Available, BorrowDate, ReturnDate);
			_availableDocuments.add(libro);
				
		}
		
		else if(docType.equals("2")) {
			System.out.println("Ingrese el ID del documento ");
			docID = _strScan.next();
			
			System.out.println("Ingrese el titulo del documento");
			docTitle = _strScan.next();
			
			System.out.println("Ingrese el autor del documento");
			docAuthor = _strScan.next();
			
			System.out.println("Ingrese el Tema/Materia del libro");
			docTopic = _strScan.next();
			
			System.out.println("Ingrese la cantidad de documentos");
			docQty = Integer.parseInt(_strScan.next());
			
			System.out.println("Ingrese el nombre del Arbitro");
			docArbit = _strScan.next();
			
			docEditorial = null;
			
			articulo = new Article(docID, docTitle, docAuthor, docEditorial, docTopic, docQty, Available, docArbit, BorrowDate, ReturnDate);
			_availableDocuments.add(articulo);
		}
		
		else if(docType.equals("3")) {
			System.out.println("Ingrese el ID del documento ");
			docID = _strScan.next();
			
			System.out.println("Ingrese el titulo del documento");
			docTitle = _strScan.next();
			
			System.out.println("Ingrese el autor del documento");
			docAuthor = _strScan.next();
			
			System.out.println("Ingrese el Tema/Materia del libro");
			docTopic = _strScan.next();
			
			System.out.println("Ingrese la cantidad de documentos");
			docQty = Integer.parseInt(_strScan.next());
			
			System.out.println("Ingrese el anio en que se publico");
			docYear = Integer.parseInt(_strScan.next());
			
			System.out.println("Ingrese el numero de version del documento");
			docVersion = Integer.parseInt(_strScan.next());
			
			docEditorial = null;
			
			revista = new magazine(docID, docTitle, docAuthor, docEditorial, docTopic, docQty, Available, docYear, docVersion, BorrowDate, ReturnDate);	
			_availableDocuments.add(revista);
		}
		
		
	}
	/**
	 * Metod para crear un nuevo cliente
	 * @param ClientList Lista de clientes de la bilbioteca
	 * @param strScanner Scanner para leer input
	 * @param IDclient ID del cliente (se pide antes para verificar si existe , sino existe el cliente se crea uno nuevo)
	 * @return regresar un nuevo cliente que puede ser aniadido a la lista
	 */
	public static client addNewClient(ArrayList<client> ClientList,Scanner strScanner, String IDclient) {
		;
		String clientName;
		String Addres;
		int BorrowedQty;
		
		client cliente;
		
		
		System.out.println("Ingrese el nombre del Cliente");
		clientName = strScanner.next();
		
		System.out.println("Ingrese la direccion del cliente");
		Addres = strScanner.next();
		
		BorrowedQty = 0;
		
		cliente = new client(IDclient, clientName, Addres, BorrowedQty);
		
		return cliente;
	}

}
