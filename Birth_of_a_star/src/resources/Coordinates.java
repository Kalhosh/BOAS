package resources;

/**
 * @author BIZOT Lo�c
 */
public class Coordinates {

	private int x;
	private int y;
	
	/**
	 * <p> positionnement d'une case </p>
	 * @param x la valeur en abscisse
	 * @param y la valeur en ordonn�e
	 */
	public Coordinates(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	/**
	 * <p> constructeur par default, x = y = 0 </p>
	 */
	public Coordinates() {
		x = y = 0;
	}
	
	/**
	 * @return l'abscisse de la case
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return l'ordonn�e de la case
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * <p> change le positionnement de la case </p>
	 * @param x la position x
	 * @param y la position y
	 */
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param c une autre coordonn�e
	 * @return la distance euclidienne entre cette case et c 
	 */
	public double distance(Coordinates c) {
		
		double dX2 = Math.pow(x - c.x, 2);
		double dY2 = Math.pow(y - c.y, 2);
		
		return Math.sqrt(dX2 + dY2);
		
	}
	
	public boolean equals(Object other) {
		
		if( !(other instanceof Coordinates))
			return false;
		
		else {
			
			Coordinates c = (Coordinates)other;
			
			return x == c.x && y == c.y;
			
		}
		
	}
	
}