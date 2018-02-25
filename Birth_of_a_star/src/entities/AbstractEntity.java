package entities;

import java.awt.geom.Point2D;

import resources.Displayable;

public abstract class AbstractEntity implements Displayable{

	private Point2D coords;
	private IMap area;
	
	/**
	 * <p> appelle lors du passage d'une entite dans un warp </p>
	 * <p> met l'entite sur la carte au bout du warp, aux coordonnees du bout du warp </p>
	 * @param warp le warp traverse
	 */
	public void warp(IWarp warp) {
	
		area.removeEntity(this);
		area = warp.getDest();
		coords.setLocation(warp.getCoord());
		area.addEntity(this);
		
	}
	
}
