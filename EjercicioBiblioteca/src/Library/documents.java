package Library;

public abstract class documents {
	protected int Type;
	protected String ID;
	protected String Title;
	protected String Author;
	protected String Editorial;
	protected String Topic;
	protected int Qty;
	protected boolean StatusAvailable;
	protected String BorrowDate;
	protected String ReturnDate;
	
	public documents (String _ID, String _title, String _Author, String _editorial, String _topic, int _qty, boolean _Available, String _borrowDate, String _returnDate) {
		this.Type = 0;
		this.setID(_ID);
		this.setTitle(_title);
		this.setAuthor(_Author);
		this.setEditorial(_editorial);
		this.setTopic(_topic);
		this.setQty(_qty);
		this.setStatusAvailable(_Available);
		this.setBorrowDate(_borrowDate);
		this.setReturnDate(_returnDate);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String autor) {
		Author = autor;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public boolean isStatusAvailable() {
		return StatusAvailable;
	}

	public void setStatusAvailable(boolean statusAvailable) {
		StatusAvailable = statusAvailable;
	}

	public String getBorrowDate() {
		return BorrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		BorrowDate = borrowDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}
	
	
	
}
