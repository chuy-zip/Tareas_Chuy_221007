/**
 * 
 */
package Library;

public class Article extends documents{
	private String Arbitrator;
	
	public Article(String _ID, String _title, String _Author, String _editorial, String _topic, int _qty, boolean _Available, String _arbitrator, String _borrowDate, String _returnDate) {
		super(_ID, _title, _Author, null , _topic,  _qty,  _Available,  _borrowDate, _returnDate);
		this.Type = 2;
		this.setArbitrator(_arbitrator);
	}

	public String getArbitrator() {
		return Arbitrator;
	}

	public void setArbitrator(String Arbitrator) {
		this.Arbitrator = Arbitrator;
	}
	
	

}
