package entities;

import resources.Coordinates;

/**
 * @author BIZOT Lo�c
 */
public abstract class Human extends AbstractEntity{

	public Human(Coordinates coords, IMap area) {
		super(coords, area);
	}
	
}
