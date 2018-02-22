package map_exceptions;

/**
 * @author BIZOT Loïc
 */
public class OutOfMapBoundsException extends Exception {

	/**
	 * serivalVersion de la classe
	 */
	private static final long serialVersionUID = 1612778893347778875L;

	private int x;
	private int y;
	
	public OutOfMapBoundsException(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void printStackTrace() {
		
		// traitement specifique a cette erreur
		System.err.println("Erreur aux coordonnees (" + x + ", " + y + ")");
		
		// appel de la methode de la super classe
		super.printStackTrace();
		
	}
	
}
