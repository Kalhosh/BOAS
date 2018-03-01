package entities;

import resources.Coordinates;
import resources.Displayable;

/**
 * @author BIZOT Loïc
 */
public abstract class AbstractEntity implements Displayable{

	private Coordinates coords;
	private IMap area;
	
	/**
	 * <p> appelle lors du passage d'une entite dans un warp </p>
	 * <p> met l'entite sur la carte au bout du warp, aux coordonnees du bout du warp </p>
	 * @param warp le warp traverse
	 */
	public void warp(IWarp warp) {
	
		area.removeEntity(this);
		area = warp.getDest();
		coords.setCoordinates(warp.getCoord());
		area.addEntity(this);
		
	}
	
	/**
	 * <p> demande la permission a la carte pour se déplacer, lance le déplacement si ok
	 * @param direction la direction dans laquelle se déplacer
	 */
	public void requestMove(Movement direction) {
		
		// calcul des nouvelles coordonnées
		double theta = Math.PI*direction.ordinal()/2;
		int nx = (int) (coords.getX() + Math.cos(theta));
		int ny = (int) (coords.getY() + Math.sin(theta));
		Coordinates newC = new Coordinates(nx,ny);
		
		// requette a la carte
		boolean request = area.requestPassThrough(newC, coords, this);
		
		// deplacement si le resultat de la requete est positive
		if(request)
			move(direction);
		
	}
	
	/**
	 * <p> déplacement de l'entite </p>
	 * @param direction la direction dans laquelle se déplacer
	 */
	protected abstract void move(Movement direction);
	
}
