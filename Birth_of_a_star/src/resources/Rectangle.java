package resources;

/**
 * @author BIZOT Loïc
 */
public class Rectangle {

	private Coordinates origine;
	private int width;
	private int height;
	
	/**
	 * <p> constructeur atomique </p>
	 * @param x position x du bord haud gauche du rectangle
	 * @param y position y du bord haud gauche du rectangle
	 * @param width largeur du rectangle
	 * @param height hauteur du rectangle
	 */
	public Rectangle(int x, int y, int width, int height) {
		
		origine = new Coordinates(x,y);
		this.width = width;
		this.height = height;
		
	}
	
	/**
	 * <p> constructeur par défault </p>
	 */
	public Rectangle() {
		origine = new Coordinates();
		width = 0;
		height = 0;
	}
	
	/**
	 * <p> constructeur par points, définissant un rectangle </p< 
	 * @param coord1 le premier point
	 * @param coord2 le second point
	 */
	public Rectangle(Coordinates coord1, Coordinates coord2) {
		
		int x1 = Math.min(coord1.getX(), coord2.getX());
		int y1 = Math.min(coord1.getY(), coord2.getY());
		int x2 = Math.max(coord1.getX(), coord2.getX());
		int y2 = Math.max(coord1.getY(), coord2.getY());
		
		origine = new Coordinates(x1,y1);
		width = x2 - x1;
		height = y2 - y1;
		
	}
	
	/**
	 * <p> constructeur atomique </p>
	 * @param origine point du bord haut gauche du rectangle
	 * @param width largeur du rectangle
	 * @param height hauteur du rectangle
	 */
	public Rectangle(Coordinates origine, int width, int height) {
		
		this.origine = new Coordinates(origine);
		this.width = width;
		this.height = height;
		
	}
	
	/**
	 * <p> constructeur par recopie </p>
	 * @param other rectangle a copier
	 */
	public Rectangle(Rectangle other) {

		this.origine = new Coordinates(other.origine);
		this.width = other.width;
		this.height = other.height;
		
	}

	/**
	 * @param coord la coordonnée potentiellement contenu dans le rectangle
	 * @return true si coord est dans le rectangle, false sinon
	 */
	public boolean contains(Coordinates coord) {
		
		if( 0 <= coord.getX() - origine.getX() && coord.getX() - origine.getX() < width && 0 <= coord.getY() - origine.getY() && coord.getY() - origine.getY() < height)
			return true;
		else
			return false;
		
	}
	
}
