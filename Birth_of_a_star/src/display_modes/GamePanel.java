package display_modes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import display_engine.IFollowable;
import display_engine.IWindow;
import display_engine.ObserverVue;
import map_exceptions.InvalidMapDimensionException;
import maps.AbstractMap;

/**
 * @author BIZOT Loïc
 */
public class GamePanel extends JPanel implements IWindow{

	private AbstractMap observedMap;
	private ObserverVue observerVue;
	
	// test luminosité
	private int time ;
	
	/**
	 * <p> constructeur de GamePanel </p>
	 * @param m la map qu'affiche le GamePanel
	 * @throws InvalidMapDimensionException une map a été créée avec des dimensions invalides 
	 */
	public GamePanel(AbstractMap m) throws InvalidMapDimensionException {
		
		observerVue = new ObserverVue(this);
		observedMap = m;
		time = 0;
		
	}
	
	/**
	 * serialVersion de la classe
	 */
	private static final long serialVersionUID = 8246084805909038066L;
	
	/**
	 * <p> affiche la carte </p>
	 */
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		// affichage de la carte
		observedMap.displayMap(observerVue, g2d, this);
		
		// affichage d'un claque semi-transparent pour la luminosité
		double t = 1 - Math.pow(Math.cos(Math.PI*time/3600),2);
		
		int red = (int) (t*200);
		int green = (int) (30*(1-t) + 120*t);
		int blue = (int) (50*(1-t) + 80*t);
		int alpha = (int) (200*(1-t) + 60*t);
		
		g2d.setPaint(new Color(red,green,blue,alpha));
		g2d.fill(new Rectangle2D.Float(0, 0, this.getWidth(), this.getHeight()));
		
		time ++;
		
	}

	/**
	 * @see display_engine.IWindow#getWindowWidth()
	 */
	public int getWindowWidth() {
		return this.getWidth();
	}

	/**
	 * @see display_engine.IWindow#getWindowHeight()
	 */
	public int getWindowHeight() {
		return this.getHeight();
	}
	
	/**
	 * <p> deffinit l'élément au millieu du panneau </p>
	 * @param f l'élément qui doit être suivi par la vue
	 */
	public void setViewOn(IFollowable f) {
		observerVue.follow(f);
	}
	
}
