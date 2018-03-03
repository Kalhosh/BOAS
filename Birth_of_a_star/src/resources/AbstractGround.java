package resources;

/**
 * @author BIZOT Loïc
 */
public abstract class AbstractGround implements Displayable{
	
	/**
	 * @return true si l'on peut marcher sur ce sol, false sinon
	 */
	public abstract boolean canPassThrough();

}
