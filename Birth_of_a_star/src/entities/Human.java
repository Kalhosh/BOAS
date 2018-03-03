package entities;

import resources.Coordinates;

/**
 * @author BIZOT Loïc
 */
public abstract class Human extends AbstractEntity{

	public Human(Coordinates coords, IMap area) {
		super(coords, area);
	}
	
}
