package resources;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;

/**
 * @author BIZOT Loïc
 */
public abstract class AbstractGround implements Displayable{
	
	/**
	 * @see resources.Displayable#display(DisplayInfo, Point2D, Graphics2D, ImageObserver)
	 */
	public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {

	}
	
	/**
	 * @return true si l'on peut marcher sur ce sol, false sinon
	 */
	public abstract boolean canPassThrough();

}
