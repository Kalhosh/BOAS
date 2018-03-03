package display_engine;

import resources.DisplayInfo;

/**
 * @author BIZOT Lo�c
 */
public class ObserverVue implements DisplayInfo{

	private int x;
	private int y;
	private int scale;
	
	private IFollowable followed;
	private IWindow windowAffectedView;
	
	/**
	 * @param w la fenetre sur laquelle s'�tablie la vue
	 */
	public ObserverVue(IWindow w) {
		
		x = -1;
		y = -1;
		scale = 32*4;
		followed = null;
		windowAffectedView = w;
		
	}
	
	/**
	 * <p> change les coordonn�es de la vue </p>
	 * @param x la nouvelle valeur de la coordonn�e x
	 * @param y la nouvelle valeur de la coordonn�e y
	 */
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p> change l'�chelle de la vue </p>
	 * @param scale la nouvelle �chelle
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * <p> si la vue a un �l�ment � suivre, la coordonn�e retourn�e sera celle de l'entit� suivie </p>
	 * @see resources.DisplayInfo#getViewX()
	 */
	public int getViewX() {
		
		if(followed != null)
			return followed.getX();
		else
			return x;
		
	}

	/**
	 * <p> si la vue a un �l�ment � suivre, la coordonn�e retourn�e sera celle de l'entit� suivie </p>
	 * @see resources.DisplayInfo#getViewY()
	 */
	public int getViewY() {
		
		if(followed != null)
			return followed.getY();
		else
			return y;
		
	}
	
	/**
	 * @param f ajoute un followable � la vue, aura comme centre le followable
	 */
	public void follow(IFollowable f) {
		this.followed = f;
	}

	/**
	 * @see resources.DisplayInfo#getScale()
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @see resources.DisplayInfo#getWindowWidth()
	 */
	public int getWindowWidth() {
		return windowAffectedView.getWindowWidth();
	}

	/**
	 * @see resources.DisplayInfo#getWindowHeight()
	 */
	public int getWindowHeight() {
		return windowAffectedView.getWindowHeight();
	}
	
}
