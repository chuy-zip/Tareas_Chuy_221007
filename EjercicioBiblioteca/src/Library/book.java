package Library;

/**
 * Clase que se extiende de documents, unicamente utiliza el constructor de la clase padre para heredar sus atributos
 * @author Ricardo Chuy
 *
 */
public class book extends documents{
	
	/**
	 * Esta clase utiliza todos los atributos de la clase padre y representan lo mismo
	 */
	public book(String _ID, String _title, String _Author, String _editorial, String _topic, int _qty, boolean _Available, String _borrowDate, String _returnDate) {
		super(_ID, _title, _Author, _editorial, _topic,  _qty,  _Available,  _borrowDate, _returnDate);
		this.Type = 1;
	}
	
}
