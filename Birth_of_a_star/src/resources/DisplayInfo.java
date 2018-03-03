package resources;

import java.awt.Graphics2D;
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
	
	int getWindowWidth();
	
	int getWindowHeight();
	
	/**
	 * 
	 */
	default void displayImage(BufferedImage image, Coordinates position, Graphics2D g, Rectangle selection, ImageObserver io) {
		
		if(image != null){		
			int left_top_corner_posX = position.getX()*getScale()/32;
			int left_top_corner_posY = position.getY()*getScale()/32;

			//decalage de la postion due à la caméra
			left_top_corner_posX += getWindowWidth()/2 - getViewX()*getScale()/32;
			left_top_corner_posY += getWindowHeight()/2 - getViewY()*getScale()/32;
			
			g.drawImage(image, left_top_corner_posX, left_top_corner_posY, left_top_corner_posX + getScale(), left_top_corner_posY + getScale(), 
					selection.getX(), selection.getY(), selection.getX() + selection.getWidth(), selection.getY() + selection.getHeight(), io);
		}
		
	}
	
}
