package maps;

import map_exceptions.InvalidMapDimensionException;
import resources.Grass;

public class TestMap extends AbstractMap{

	public TestMap(int X, int Y) throws InvalidMapDimensionException {
		super(X, Y);
	}

	@Override
	public void fillMap() {
		
		for(int i = 0 ; i < getWidth(); i++)
			for(int j = 0; j < getHeight(); j++)
				addGround(new Grass(), i, j);
		
	}

}
