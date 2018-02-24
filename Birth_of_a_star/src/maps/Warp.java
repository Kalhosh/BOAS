package maps;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import entities.IMap;
import entities.IWarp;

public class Warp implements IWarp{

	// source
	private AbstractMap source;
	private Rectangle2D zone;
	
	// destination
	private AbstractMap dest;
	private Point2D coordDest;
	
	@Override
	public IMap getDest() {

		return dest;
	}
	
	@Override
	public Point2D getCoord() {

		return coordDest;
	}
	
}
