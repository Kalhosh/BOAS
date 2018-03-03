package entities;

import resources.Coordinates;

/**
 * @author BIZOT Loïc
 */
public abstract class Creatures extends AbstractEntity{

	public Creatures(Coordinates coords, IMap area) {
		super(coords, area);
	}

}
