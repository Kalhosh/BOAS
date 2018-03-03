package display_engine;

import resources.DisplayInfo;

/**
 * @author BIZOT Loïc
 */
public class ObserverVue implements DisplayInfo{

	private int x;
	private int y;
	private int scale;
	
	private IFollowable followed;
	private IWindow windowAffectedView;
	
	/**
	 * @param w la fenetre sur laquelle s'établie la vue
	 */
	public ObserverVue(IWindow w) {
		
		x = -1;
		y = -1;
		scale = 32*4;
		followed = null;
		windowAffectedView = w;
		
	}
	
	/**
	 * <p> change les coordonnées de la vue </p>
	 * @param x la nouvelle valeur de la coordonnée x
	 * @param y la nouvelle valeur de la coordonnée y
	 */
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p> change l'échelle de la vue </p>
	 * @param scale la nouvelle échelle
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * <p> si la vue a un élément à suivre, la coordonnée retournée sera celle de l'entité suivie </p>
	 * @see resources.DisplayInfo#getViewX()
	 */
	public int getViewX() {
		
		if(followed != null)
			return followed.getX();
		else
			return x;
		
	}

	/**
	 * <p> si la vue a un élément à suivre, la coordonnée retournée sera celle de l'entité suivie </p>
	 * @see resources.DisplayInfo#getViewY()
	 */
	public int getViewY() {
		
		if(followed != null)
			return followed.getY();
		else
			return y;
		
	}
	
	/**
	 * @param f ajoute un followable à la vue, aura comme centre le followable
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
