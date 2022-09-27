package Library;

/**
 * Controlodaor logico de la biblioteca, con los metodos necesarios para guardar y pasar información al drier program
 */
import java.util.ArrayList;
import Library.client;
import Library.documents;

public class Library_Admin {
	private ArrayList<client> ListOfClientes;
	private ArrayList<documents> AvailableDocuments;
	
	/**
	 * 
	 * @param _clientList Lista de cliente ativos
	 * @param _AvailableDocuments Lista con todos los documentos que tiene disponibles la biblioteca
	 */
	public Library_Admin(ArrayList<client> _clientList, ArrayList<documents> _AvailableDocuments) {
		 this.ListOfClientes = _clientList;
	 }
	
	/**
	 * Este metodo imprime todos los documentos disponibles y sus caracteristicas dependiendo del tipo de documento
	 * @param _availableDocuments Obtiene una lista con los documentos disponibles en la biblioteca
	 */
	public void ShowAvailableDocs(ArrayList<documents> _availableDocuments) {
		
		for (documents aDocument : _availableDocuments) {
			if(aDocument.Type == 1) {
				System.out.println("ID: " + aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" Editorial: " + aDocument.getEditorial() + " Tema: " + aDocument.getTopic() + " Cantidad: " + aDocument.getQty() );
			}
			else if(aDocument.Type == 2) {
				System.out.println("ID: " +aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" Tema: " + aDocument.getTopic() + " Arbitro: " + ((Article)aDocument).getArbitrator() + " Cantidad: " + aDocument.getQty() ) ;
			}
			else if(aDocument.Type == 3) {
				System.out.println("ID: " +aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" Año de publicacion: " + ((magazine)aDocument).getYear() + " Numero de edicion: " + ((magazine)aDocument).getEditionNumber() + 
						" Tema: " + aDocument.getTopic() + " Cantidad: " + aDocument.getQty() );
			}
		}
	}
	
	/**
	 * 
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param _id id del documento que se esta buscando
	 * @return regresa el nombre del documento que se buscaba con el ID
	 */
	public String getTitleFromID(ArrayList<documents> _availableDocuments, String _id) {
		for (documents aDocument : _availableDocuments) {
			if (aDocument.getID().equals(_id)) {
				return aDocument.getTitle();
			}
		}		
		return null;
	}
	
	/**
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param given_Topic tema del cual se buscan documentos
	 * @return la suma de todos los documentos, diferentes, con un tema en especifico
	 */
	public int QtyDocsByTopic(ArrayList<documents> _availableDocuments, String given_Topic) {
		int QtyOfDocuments = 0;
		for(documents aDocument : _availableDocuments) {
			if(aDocument.getTopic().equals(given_Topic)) {
				QtyOfDocuments++;
			}
		}
		return QtyOfDocuments;
	}
	
	/**
	 * 
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param given_ID Id del libro del que se quiere ver la disponibilidad
	 * @return true si el libro esta disponible y false si no lo esta
	 */
	public boolean BookIsAvailable(ArrayList<documents> _availableDocuments, String given_ID){
		for (documents aDocument : _availableDocuments) {
			if(aDocument.getID().equals(given_ID)) {
				if(aDocument.isStatusAvailable()) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * Verificar si el libro existe
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param given_ID Id del libro a analizar
	 * @return verdadero si el libro existe
	 */
	public boolean BookExists(ArrayList<documents> _availableDocuments, String given_ID){
		for (documents aDocument : _availableDocuments) {
			if(aDocument.getID().equals(given_ID)) {
					return true;
			}
				
		}
		
		return false;
	}
	
	/**
	 * Verificar si un cliente existe
	 * @param _clientlist clients activos en la biblioteca
	 * @param client_ID Id del cliente analizado
	 * @return un cliente con el cual luego se hacen comparaciones y que se sabe que se encuentra en la lista de clientes
	 */
	public client clientExists(ArrayList<client> _clientlist, String client_ID) {
		for (client aClient: _clientlist) {
			if(aClient.getIDClient().equals(client_ID)) {
				return aClient;
			}
		}
		return null;
	}
	
	/**
	 * Metodo para prestar un libro
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param _aClient cliente al que se le prestara el libro
	 * @param requiredBookID El Id del libro que se desea prestar
	 */
	public void borrowBook(ArrayList<documents> _availableDocuments, client _aClient, String requiredBookID) {
		for (documents aDocument: _availableDocuments) {
			if(aDocument.getID().equals(requiredBookID)) {
				aDocument.setQty(aDocument.getQty() - 1);
				_aClient.getBorrowedBooks().add(aDocument);
				_aClient.setBorrowedQty(_aClient.getBorrowedQty() + 1) ;
				
				if(aDocument.getQty() == 0) {
					aDocument.setStatusAvailable(false);
				}
			}
		}
		
		System.out.println("Prestado con exito");
		
	} 
	/**
	 * Metodo para regresar un libro a la biblioteca
	 * @param _availableDocs Documentos disponibles en la biblioteca
	 * @param _aclient cliente que regresa un libro
	 * @param ReturnDoc El ID del documento que se regresara
	 */
	public void returnBook(ArrayList<documents> _availableDocs, client _aclient, String ReturnDoc) {
		for (documents aDocument: _availableDocs) {
			if(aDocument.getID().equals(ReturnDoc)) {
				aDocument.setQty(aDocument.getQty() + 1);
				_aclient.getBorrowedBooks().add(aDocument);
				_aclient.setBorrowedQty(_aclient.getBorrowedQty() - 1);
				_aclient.getBorrowedBooks().remove(aDocument);
				
			}
		}
	}
	/**
	 * Metodo para contar por tipo de documento, los documentos que tiene prestados un cliente
	 * @param cliente Cliente del cual se contaran los documentos
	 */
	public void showQtyOfEachDoc(client cliente) {
		int qtybooks = 0;
		
		int qtymagazine = 0;
		
		int qtyarticle = 0;
	
		for(documents aDocument: cliente.getBorrowedBooks()) {
			if (aDocument.getType() == 1) {
				qtybooks += 1;
			}
			
			else if (aDocument.getType() == 2) {
				qtyarticle += 1;
			}
			else if (aDocument.getType() == 3) {
				qtymagazine += 1;
			}
		}
		
		System.out.println("El cliente tiene: \n Libros: " + qtybooks + "\nArticulos: " + qtyarticle + "\nRevistas: " + qtymagazine);
		
	}
	
	/**
	 * Sumar cuantas revistas hay disponibles en total por un tema especifico 
	 * @param _availableDocuments Documentos disponibles en la biblioteca
	 * @param requestedTopic Tema de la revista que se busca
	 * @return cantidad de revistas disponibles con el tema solicitado
	 */
	public int MagazineQtyBySpecificTopic(ArrayList<documents> _availableDocuments, String requestedTopic) {
		int qty = 0;
		for(documents aDocument: _availableDocuments) {
			if(aDocument.getTopic().equals(requestedTopic)) {
				
				if(aDocument.getType() == 3) {
					qty = qty + aDocument.getQty();
				}
				
			}
		}
		return qty;
	}
	/**
	 * Revisar si una libro o articulo esta disponible (no aplica para revistas)
	 * @param availableDocumentss Documentos disponibles en la biblioteca
	 * @param docID Documento al cual se le analizara la disponibilidad
	 * @return Verdadero si el documento esta existe, esta disponible y es libro o articulo
	 */
	public boolean IsBookOrMAgazineAvailable(ArrayList<documents> availableDocumentss, String docID) {
		for (documents aDocument : availableDocumentss) {
			if(aDocument.getID().equals(docID)) {
				if(aDocument.getType() == 1 || aDocument.getType() == 2) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public ArrayList<client> getListOfClientes() {
		return ListOfClientes;
	}

	public void setListOfClientes(ArrayList<client> listOfClientes) {
		ListOfClientes = listOfClientes;
	}


	public ArrayList<documents> getAvailableDocuments() {
		return AvailableDocuments;
	}

	public void setAvailableDocuments(ArrayList<documents> availableDocumentes) {
		AvailableDocuments = availableDocumentes;
	}

	
}
