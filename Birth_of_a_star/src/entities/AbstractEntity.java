package entities;

import java.awt.event.KeyEvent;

import controls.IControlled;
import display_engine.IFollowable;
import resources.Coordinates;
import resources.Displayable;

/**
 * @author BIZOT Loïc
 */
public abstract class AbstractEntity implements Displayable, IFollowable, IControlled{

	protected Coordinates coords;
	private IMap area;
	
	/**
	 * <p> Constructeur AbstractEntity </p>
	 * @param coords les coordonnées d'origine de l'entité
	 * @param area la carte d'origine de l'entité
	 */
	public AbstractEntity(Coordinates coords, IMap area) {
		
		this.coords = new Coordinates(coords.getX()*32,coords.getY()*32);
		this.area = area;
		
	}
	
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
		int nx = (int) (coords.getX() + Math.cos(theta)*32);
		int ny = (int) (coords.getY() + Math.sin(theta)*32);
		
		System.out.println("nx = " + nx);
		
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
	
	/**
	 * @see display_engine.IFollowable#getX()
	 */
	public int getX() {
		return coords.getX();
	}
	
	/**
	 * @see display_engine.IFollowable#getY()
	 */
	public int getY() {
		return coords.getY();
	}
	
	/**
	 * @see controls.IControlled#ActionKey(int)
	 */
	public void ActionKey(int key) {
		
		switch(key) {
		
		case KeyEvent.VK_Z:
			requestMove(Movement.MOVE_UP);
			break;
		case KeyEvent.VK_Q:
			requestMove(Movement.MOVE_LEFT);
			break;
		case KeyEvent.VK_S:
			requestMove(Movement.MOVE_DOWN);
			break;
		case KeyEvent.VK_D:
			requestMove(Movement.MOVE_RIGHT);
			break;
		
		}
		
	}
	
}
