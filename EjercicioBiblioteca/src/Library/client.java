package Library;
import java.util.ArrayList;

public class client {
	private String IDClient;
	private String Name;
	private String Addres;
	private int BorrowedQty;
	private ArrayList<documents> BorrowedBooks;
	
	
	public client(String _id, String _name, String _addres, int _Borrqty) {
		this.setIDClient(_id);
		this.setName(_name);
		this.setAddres(_addres);
		this.setBorrowedQty(_Borrqty);
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
