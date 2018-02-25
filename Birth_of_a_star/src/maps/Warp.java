package maps;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import entities.IMap;
import entities.IWarp;

public class Warp implements IWarp{
	
	private Rectangle2D warpArea;
	
	// destination
	private AbstractMap dest;
	private Point2D coordDest;
	
	/**
	 * @see entities.IWarp#getDest()
	 */
	public IMap getDest() {

		return dest;
	}
	
	/**
	 * @see entities.IWarp#getCoord()
	 */
	public Point2D getCoord() {

		return coordDest;
	}
	
	/**
	 * @see entities.IWarp#getWarpArea()
	 */
	public Rectangle2D getWarpArea() {
		return this.warpArea;
	}
	
}
