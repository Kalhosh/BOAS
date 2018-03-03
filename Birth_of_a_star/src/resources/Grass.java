package resources;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author BIZOT Loïc
 */
public class Grass extends AbstractGround{

	static boolean charged = false;
	static BufferedImage sprite = null;
	
	/**
	 * @see resources.Displayable#display(DisplayInfo, Point2D, Graphics2D, ImageObserver)
	 */
	public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {

		System.out.println("Affichage");
		
		if(!charged) {
			
			try {
				sprite = ImageIO.read(new File("Images/TileSets/grass_dirt_borders.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(sprite != null)
				charged = true;
			
		}
		
		if(sprite != null)
			info.displayImage(sprite, position, g, new Rectangle(0,0,32,32), io);
		else
			System.err.println("Erreur image");
		
	}
	
	@Override
	public boolean canPassThrough() {

		return true;
		
	}
	
}
