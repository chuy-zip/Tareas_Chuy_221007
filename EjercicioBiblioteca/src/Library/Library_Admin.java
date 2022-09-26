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
				System.out.println("ID: " +aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" Editorial: " + aDocument.getEditorial() + " Tema: " + aDocument.getTopic() + " Cantidad: " + aDocument.getQty() );
			}
			else if(aDocument.Type == 2) {
				System.out.println("ID: " +aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" Tema: " + aDocument.getTopic() + " Arbitro: " + ((Article)aDocument).getArbitrator() + " Cantidad: " + aDocument.getQty() ) ;
			}
			else if(aDocument.Type == 3) {
				System.out.println("ID: " +aDocument.getID() + " Titulo: " + aDocument.getTitle() + " Autor: " + aDocument.getAuthor() + 
						" A�o de publicacion: " + ((magazine)aDocument).getYear() + " Numero de edicion: " + ((magazine)aDocument).getEditionNumber() + 
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