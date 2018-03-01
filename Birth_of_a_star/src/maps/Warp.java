package maps;

import java.awt.geom.Rectangle2D;

import entities.IMap;
import entities.IWarp;
import resources.Coordinates;

public class Warp implements IWarp{
	
	private Rectangle2D warpArea;
	
	// destination
	private AbstractMap dest;
	private Coordinates coordDest;
	
	/**
	 * @see entities.IWarp#getDest()
	 */
	public IMap getDest() {
		return dest;
	}
	
	/**
	 * @see entities.IWarp#getCoord()
	 */
	public Coordinates getCoord() {
		return coordDest;
	}
	
	/**
	 * @see entities.IWarp#getWarpArea()
	 */
	public Rectangle2D getWarpArea() {
		return this.warpArea;
	}
	
}
