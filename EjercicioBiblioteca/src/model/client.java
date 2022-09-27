package model;
import java.util.ArrayList;

/**
 * Esta clase es el constructor para los clientes que tendra la libreria. Es necesario para el control de prestamo y devolucion de libros
 * Una persona solo puede ser cliente si renta un libro
 * @author Ricardo Chuy
 */
public class client {
	private String IDClient;
	private String Name;
	private String Addres;
	private int BorrowedQty;
	private ArrayList<documents> BorrowedBooks;
	
	/**
	 * @param _id Es el id que se le asiganara a cada cliente
	 * @param _name El nombre del cliente
	 * @param _addres La direccion del cliente
	 * @param _Borrqty Cantidad de documentos que posee en prestamo
	 */
	public client(String _id, String _name, String _addres, int _Borrqty) {
		this.setIDClient(_id);
		this.setName(_name);
		this.setAddres(_addres);
		this.setBorrowedQty(_Borrqty);
		BorrowedBooks = new ArrayList<documents>();
	}


	public String getIDClient() {
		return IDClient;
	}


	public void setIDClient(String iDClient) {
		IDClient = iDClient;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddres() {
		return Addres;
	}


	public void setAddres(String addres) {
		Addres = addres;
	}


	public int getBorrowedQty() {
		return BorrowedQty;
	}


	public void setBorrowedQty(int borrowedQty) {
		BorrowedQty = borrowedQty;
	}


	public ArrayList<documents> getBorrowedBooks() {
		return BorrowedBooks;
	}


	public void setBorrowedBooks(ArrayList<documents> _BorrowedBooks) {
		BorrowedBooks = _BorrowedBooks;
	}
	
	
}
