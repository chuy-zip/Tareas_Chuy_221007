package Library;

public class magazine extends documents{
	
	private int year;
	private int EditionNumber;
	public magazine(String _ID, String _title, String _Author, String _editorial, String _topic, int _qty, boolean _Available, int _year, int _EditionNum, String _borrowDate, String _returnDate) {
		super(_ID, _title, _Author, null , _topic,  _qty,  _Available, _borrowDate, _returnDate);
		this.Type = 3;
		this.setYear(_year);
		this.setEditionNumber(_EditionNum);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEditionNumber() {
		return EditionNumber;
	}
	public void setEditionNumber(int editionNumber) {
		EditionNumber = editionNumber;
	}
	
	
}

