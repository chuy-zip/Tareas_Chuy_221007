package Library;

import java.util.ArrayList;
import java.util.Scanner;
import Library.documents;
import Library.Article;
import Library.book;
import Library.magazine;
import Library.Library_Admin;


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
				System.out.println("Op 1");
				getDocumentInfo(Strscaner, AvailableDocuments);
				Adminisitrator.ShowAvailableDocs(AvailableDocuments);
				
			}
			
			else if(option.equals("2")) {
				System.out.println("Op 2");
			}
			
			else if(option.equals("3")) {
				System.out.println("Op 3");
			}
			
			else if(option.equals("4")) {
				System.out.println("Op 4");
			}
			
			else if(option.equals("5")) {
				System.out.println("Op 5");
			}
			
			else if(option.equals("6")) {
				System.out.println("Op 6");
			}
			
			else if(option.equals("7")) {
				System.out.println("Op 7");
			}
			
			else if(option.equals("8")) {
				System.out.println("Op 8");
				
			}
			
		}
		
	}
	
	public static void showMenu(){
		System.out.println("Bienvenido al program de librería. Ingrese el numero de opcion a realizar\n");
		System.out.println("1.Agregar un Documento \n"+
							"2.Buscar nombre de un libro por medio de su ID \n" +
							"3.Cantidad de documentos por Materia/Tema \n"+
							"4.Tomar Un libro prestado (Con numero de ID)\n"+
							"5.Devolver Un libro\n"+
							"6.Ingresar Cliente y conocer la cantidad de cada Tipo de Documentos Prestados \n" +
							"7.Cantidad de revistas por Tema Disponibles\n"+
							"8.Ingresar un libro o artículo para revisar disponibilidad\n"+
							"9.Salir\n");
	}
	
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
		
		System.out.println("Que tipo de documento se desea añadir: \n"+
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
			
			System.out.println("Ingrese el año en que se publico");
			docYear = Integer.parseInt(_strScan.next());
			
			System.out.println("Ingrese el numero de version del documento");
			docVersion = Integer.parseInt(_strScan.next());
			
			docEditorial = null;
			
			revista = new magazine(docID, docTitle, docAuthor, docEditorial, docTopic, docQty, Available, docYear, docVersion, BorrowDate, ReturnDate);	
			_availableDocuments.add(revista);
		}
		
		
	}

}
