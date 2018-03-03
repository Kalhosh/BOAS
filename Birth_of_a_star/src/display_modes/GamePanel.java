package display_modes;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import display_engine.IWindow;
import display_engine.ObserverVue;
import map_exceptions.InvalidMapDimensionException;
import maps.AbstractMap;
import maps.TestMap;

/**
 * @author BIZOT Loïc
 */
public class GamePanel extends JPanel implements IWindow{

	private AbstractMap observedMap;
	private ObserverVue observerVue;
	
	public GamePanel() throws InvalidMapDimensionException {
		
		observerVue = new ObserverVue(this);
		observedMap = new TestMap(20, 20);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8246084805909038066L;
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		observedMap.displayMap(observerVue, g2d, this);
		
	}

	@Override
	public int getWindowWidth() {
		return this.getWidth();
	}

	@Override
	public int getWindowHeight() {
		return this.getHeight();
	}
	
}
