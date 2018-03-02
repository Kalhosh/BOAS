package display_engine;

import java.awt.image.BufferedImage;
import java.util.TreeMap;

public interface ImageInit {

	boolean init = false;
	TreeMap<ImageIndic,BufferedImage> loadedImages = null;
	
	/**
	 * <p> initialise toutes les images du jeu </p>
	 */
	static void init() {
		
		
		
	}
	
}
