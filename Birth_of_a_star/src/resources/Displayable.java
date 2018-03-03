package resources;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

/**
 * @author BIZOT Loïc
 */
public interface Displayable {

	/**
	 * <p> affiche un element affichable, decale en fonction de la vue </p>
	 * @param info information sur la vue
	 * @param position position du displayable
	 * @param g contexte graphique
	 * @param io panneau observant
	 */
	void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io);
	
}
