package algorithms;

import resources.Coordinates;

/**
 * @author BIZOT Loïc
 */
public interface ColisionHandler {

	/**
	 * @param coord les coordonnees de la case
	 * @return true si la case est franchissable, false dans le cas contraire
	 * */
	boolean canPassThrough(Coordinates coord);
	
	/**
	 * @param coord les coordonnees de la case
	 * @return true si la case possede une valeur coherente avec la carte, false sinon
	 */
	boolean isInBounds(Coordinates coord);
	
	/**
	 * @return la largeur de la carte
	 */
	int getWidth();
	
	/**
	 * @return la largeur de la carte
	 */
	int getHeight();
	
}
