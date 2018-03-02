package resources;

/**
 * @author BIZOT Loïc
 */
public interface DisplayInfo {
	
	/**
	 * @return la coordonnée x du millieu de vision 
	 */
	int getViewX();
	
	/**
	 * @return la coordonnée y du millieu de vision
	 */
	int getViewY();
	
	/**
	 * @return la taille des éléments
	 */
	int getScale(); 
	
}
