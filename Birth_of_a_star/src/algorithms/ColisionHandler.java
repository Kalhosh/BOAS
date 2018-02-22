package algorithms;

import java.awt.geom.Point2D;

/**
 * @author BIZOT Loïc
 */
public interface ColisionHandler {

	/**
	 * @param coord les coordonnees de la case
	 * @return true si la case est franchissable, false dans le cas contraire
	 * */
	boolean canPassThrough(Point2D coord);
	
	/**
	 * @param coord les coordonnees de la case
	 * @return true si la case possede une valeur coherente avec la carte, false sinon
	 */
	boolean isInBounds(Point2D coord);
	
	int getWidth();
	int getHeight();
	
}
