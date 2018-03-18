package algorithms;

import resources.Coordinates;

/**
 * @author BIZOT Loïc
 */
public class DistanceOptimiser implements PathOptimiser{

	private Coordinates end;
	
	/**
	 * @param end point final du pathfinding
	 */
	public DistanceOptimiser(Coordinates end) {
		
		this.end = end;
		
	}

	/**
	 * <p> compare en fonction de la distance a la fin </p>
	 */
	public int compare(Link o1, Link o2) {
		
		int indexP1 = o1.getIndex();
		int indexP2 = o2.getIndex();
		
		int result;
		
		if(indexP1 == -1) { // P1 non traite
			
			if(indexP2 == -1) { // P1 et P2 non traites
				
				// on priorise les distances faibles
				double distanceP1End = o1.getCurrent().distance(end);
				double distanceP2End = o2.getCurrent().distance(end);
				
				// comparaison en fonction de la distance a end
				if(distanceP1End < distanceP2End)
					result = -1;
				else if(distanceP1End > distanceP2End)
					result = 1;
				else
					result = (int)Math.random()*3 - 1;
				
			}
			else { // P2 seulement traite
				
				result = 1;
				
			}
			
		}
		else {
			
			if(indexP2 == -1) { // P1 seulement traite
				
				result = -1;
				
			}
			else { // P1 et P2 traites
				
				// comparaison en fonction de l'index
				if(indexP1 < indexP2)
					result = -1;
				else if(indexP1 > indexP2)
					result = 1;
				else
					result = 0;
				
			}
			
		}
		
		return result;
	}

}
