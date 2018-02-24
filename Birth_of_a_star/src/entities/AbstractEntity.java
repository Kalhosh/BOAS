package entities;

import java.awt.geom.Point2D;

import resources.Displayable;

public abstract class AbstractEntity implements Displayable{

	private Point2D coords;
	private IMap area;
	
	
	
	
	
	
	
	
	
	
	
	
	public void warp(IWarp warp) {
	
		area.removeEntity(this);
		area = warp.getDest();
		coords.setLocation(warp.getCoord());
		area.addEntity(this);
		
	}
	
}
