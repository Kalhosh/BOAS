package map_exceptions;

/**
 * @author BIZOT Loïc
 */
public class InvalidMapDimensionException extends Exception {

	/**
	 * serivalVersion de la classe
	 */
	private static final long serialVersionUID = -6932827631626161045L;
	
	private int x;
	private int y;
	
	public InvalidMapDimensionException(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void printStackTrace() {
		
		// traitement specifique a cette erreur
		System.err.println("Taille de la carte invalide (" + x + ", " + y + ")");
		
		// appel de la methode de la super classe
		super.printStackTrace();
		
	}

}
