package maps;

import entities.IMap;
import entities.IWarp;
import resources.Coordinates;
import resources.Rectangle;

public class Warp implements IWarp{
	
	private Rectangle warpArea;
	
	// destination
	private AbstractMap dest;
	private Coordinates coordDest;
	
	/**
	 * <p> le warp null </p>
	 */
	public Warp() {
		warpArea = new Rectangle();
		dest = null;
		coordDest = new Coordinates();
	}
	
	/**
	 * <p> initialise les attributs du warp, recopie de références </p>
	 * @param warpArea la zone de collision du warp
	 * @param dest la carte au bout du warp
	 * @param coordDest les coordonnées de destination du warp
	 */
	public void set(Rectangle warpArea, AbstractMap dest, Coordinates coordDest) {
		
		this.warpArea = warpArea;
		this.dest = dest;
		this.coordDest = coordDest;
		
	}
	
	/**
	 * <p> initialise les attributs du warp pas recopie </p>
	 * @param warpArea la zone de collision du warp
	 * @param dest la carte au bout du warp
	 * @param coordDest les coordonnées de destination du warp
	 */
	public void copy(Rectangle warpArea, AbstractMap dest, Coordinates coordDest) {
		
		this.warpArea = new Rectangle(warpArea);
		this.dest = dest;
		this.coordDest = new Coordinates(coordDest);
		
	}
	
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
	public Rectangle getWarpArea() {
		return this.warpArea;
	}
	
}
