package resources;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

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
	
	/**
	 * @return la largeur de la fenetre sur laquelle s'appuie la vue
	 */
	int getWindowWidth();
	
	/**
	 * @return la hauteur de la fenetre sur laquelle s'appuie la vue
	 */
	int getWindowHeight();
	
	/**
	 * <p> affichage d'une image avec décalage du la la vue </p>
	 */
	default void displayImage(BufferedImage image, Coordinates position, Graphics2D g, Rectangle selection, ImageObserver io) {
		
		if(image != null){		
			
			int left_top_corner_posX = position.getX()*getScale()/32;
			int left_top_corner_posY = position.getY()*getScale()/32;

			//decalage de la postion due à la caméra
			left_top_corner_posX += getWindowWidth()/2 - getViewX()*getScale()/32 - getScale()/2;
			left_top_corner_posY += getWindowHeight()/2 - getViewY()*getScale()/32 - getScale()/2;
			
			g.drawImage(image, left_top_corner_posX, left_top_corner_posY, left_top_corner_posX + getScale(), left_top_corner_posY + getScale(), 
					selection.getX(), selection.getY(), selection.getX() + selection.getWidth(), selection.getY() + selection.getHeight(), io);
			
			Rectangle2D r = new Rectangle2D.Double(left_top_corner_posX,left_top_corner_posY,getScale(),getScale());
			g.draw(r);
			
		}
		
	}
	
}
