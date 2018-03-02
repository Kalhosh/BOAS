package resources;

/**
 * @author BIZOT Loïc
 */
public class Coordinates {

	private int x;
	private int y;
	
	/**
	 * <p> positionnement d'une case </p>
	 * @param x la valeur en abscisse
	 * @param y la valeur en ordonnée
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
	 * <p> constructeur par recopie </p>
	 * @param origine le point a copier
	 */
	public Coordinates(Coordinates origine) {
		x = origine.x;
		y = origine.y;
	}

	/**
	 * @return l'abscisse de la case
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return l'ordonnée de la case
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
	 * <p> change le positionnement de la case </p>
	 * @param c la nouvelle position
	 */
	public void setCoordinates(Coordinates c) {
		this.x = c.x;
		this.y = c.y;
	}
	
	/**
	 * @param c une autre coordonnée
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
