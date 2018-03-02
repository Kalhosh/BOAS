package entities;

import resources.Coordinates;
import resources.Rectangle;

public interface IWarp {

	/**
	 * @return la carte en bout de warp
	 */
	IMap getDest();
	
	/**
	 * @return les coordonnees sur la carte en bout de warp
	 */
	Coordinates getCoord();
	
	/**
	 * @return la zone de la carte origine sur laquelle ss'effectue le warp
	 */
	Rectangle getWarpArea();
	
}
