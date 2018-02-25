package entities;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public interface IWarp {

	/**
	 * @return la carte en bout de warp
	 */
	IMap getDest();
	
	/**
	 * @return les coordonnees sur la carte en bout de warp
	 */
	Point2D getCoord();
	
	/**
	 * @return la zone de la carte origine sur laquelle ss'effectue le warp
	 */
	Rectangle2D getWarpArea();
	
}
