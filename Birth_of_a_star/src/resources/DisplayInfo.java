package resources;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * @author BIZOT Lo�c
 */
public interface DisplayInfo {
	
	/**
	 * @return la coordonn�e x du millieu de vision 
	 */
	int getViewX();
	
	/**
	 * @return la coordonn�e y du millieu de vision
	 */
	int getViewY();
	
	/**
	 * @return la taille des �l�ments
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
	 * <p> affichage d'une image avec d�calage du la la vue </p>
	 * @param image l'image a afficher
	 * @param position l'endroit ou doit �tre affich�e l'image
	 * @param g le contexte graphique du panneau sur lequel l'image est affich�
	 * @param selection la portion de l'image � afficher
	 * @param io le panneau sur lequel afficher
	 */
	default void displayImage(BufferedImage image, Coordinates position, Graphics2D g, Rectangle selection, ImageObserver io) {
		
		if(image != null){		
			
			int left_top_corner_posX = position.getX()*getScale()/32;
			int left_top_corner_posY = position.getY()*getScale()/32;

			//decalage de la postion due � la cam�ra
			left_top_corner_posX += getWindowWidth()/2 - getViewX()*getScale()/32 - getScale()/2;
			left_top_corner_posY += getWindowHeight()/2 - getViewY()*getScale()/32 - getScale()/2;
			
			g.drawImage(image, left_top_corner_posX, left_top_corner_posY, left_top_corner_posX + getScale(), left_top_corner_posY + getScale(), 
					selection.getX(), selection.getY(), selection.getX() + selection.getWidth(), selection.getY() + selection.getHeight(), io);
			
		}
		
	}
	
}
