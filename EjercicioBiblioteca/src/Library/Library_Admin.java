package Library;

import java.util.ArrayList;
import Library.client;
import Library.documents;

public class Library_Admin {
	private ArrayList<client> ListOfClientes;
	private ArrayList<documents> AvailableDocuments;
	
	public Library_Admin(ArrayList<client> _clientList, ArrayList<documents> _AvailableDocuments) {
		 this.ListOfClientes = _clientList;
	 }
	
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
	
	public String getTitleFromID(ArrayList<documents> _availableDocuments, String _id) {
		for (documents aDocument : _availableDocuments) {
			if (aDocument.getID().equals(_id)) {
				return aDocument.getTitle();
			}
		}		
		return null;
	}
	
	public int QtyDocsByTopic(ArrayList<documents> _availableDocuments, String given_Topic) {
		int QtyOfDocuments = 0;
		for(documents aDocument : _availableDocuments) {
			if(aDocument.getTopic().equals(given_Topic)) {
				QtyOfDocuments++;
			}
		}
		return QtyOfDocuments;
	}
	
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
		
	public boolean BookExists(ArrayList<documents> _availableDocuments, String given_ID){
		for (documents aDocument : _availableDocuments) {
			if(aDocument.getID().equals(given_ID)) {
					return true;
			}
				
		}
		
		return false;
	}
	
	public client clientExists(ArrayList<client> _clientlist, String client_ID) {
		for (client aClient: _clientlist) {
			if(aClient.getIDClient().equals(client_ID)) {
				return aClient;
			}
		}
		return null;
	}
	
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
