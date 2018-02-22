package display_engine;

import javax.swing.JPanel;

/**
 * @author BIZOT Loïc
 */
public abstract class DisplayPanel extends JPanel{

	/**
	 * serivalVersion de la classe
	 */
	private static final long serialVersionUID = -7494809385887066112L;

	/**
	 * <p> affiche le contenu d'un panneau, decale celon la vue </p>
	 * @param x position en absisse du centre de la vue
	 * @param y position en ordonnee du centre de la vue
	 * @param scale echelle de la vue
	 * */
	public abstract void displayContent(int x, int y, int scale);
	
}
