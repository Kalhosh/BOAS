package maps;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import algorithms.ColisionHandler;
import entities.AbstractEntity;
import entities.IMap;
import map_exceptions.InvalidMapDimensionException;
import resources.AbstractGround;
import resources.Coordinates;
import resources.DisplayInfo;

/**
 * @author BIZOT Lo�c
 */
public abstract class AbstractMap implements ColisionHandler,IMap{

	private AbstractGround ground[][];
	private ArrayList<Warp> warps;
	private ArrayList<AbstractEntity> entities;
	private int X;
	private int Y;
	
	/**
	 * @param X nombre de valeurs en absisse de la carte
	 * @param Y nombre de valeurs en ordonnee de la carte
	 * @throws InvalidMapDimensionException une des valeurs X ou Y est nulle ou negative
	 */
	public AbstractMap(int X, int Y) throws InvalidMapDimensionException {
		
		ground = null;
		
		this.X = X;
		this.Y = Y;
		
		this.warps = new ArrayList<>();
		this.entities = new ArrayList<>();
		
		if(X > 0 && Y > 0)
			ground = new AbstractGround[X][Y];
		else
			throw new InvalidMapDimensionException(X,Y);
		
		fillMap();
		
	}
	
	/**
	 * @see algorithms.ColisionHandler#canPassThrough(Coordinates)
	 * */
	public boolean canPassThrough(Coordinates coord){
		
		int x = coord.getX()/32;
		int y = coord.getY()/32;
		
		if(isInBounds(coord))
			return ground[x][y].canPassThrough();
		else
			return false;
		
	}
	
	/**
	 * @see algorithms.ColisionHandler#isInBounds(Coordinates)
	 */
	public boolean isInBounds(Coordinates coord) {
		
		int x = coord.getX()/32;
		int y = coord.getY()/32;
		
		boolean res = x >= 0 && x < X;
		res = res &&  y >= 0 && y < Y;
		
		return res;
		
	}
	
	/**
	 * @see algorithms.ColisionHandler#getWidth()
	 */
	public int getWidth() {
		return X;
	}

	/**
	 * @see algorithms.ColisionHandler#getHeight()
	 */
	public int getHeight() {
		return Y;
	}
	
	/**
	 * <p> Affiche une portion de la carte, en fonction de la vue </p>
	 * @param info centre et zoom de la camera
	 * @param g contexte graphique
	 * @param io panneau
	 */
	public void displayMap(DisplayInfo info, Graphics2D g, ImageObserver io) {
		
		// variable d'optimisation
		Coordinates pos = new Coordinates();
		
		// calcul de la portion a afficher
		int beginX = Math.max(info.getViewX()/32 - (info.getWindowWidth()/2)/info.getScale() - 1,0);
		int beginY = Math.max(info.getViewY()/32 - (info.getWindowHeight()/2)/info.getScale() - 1,0);
		int endX = Math.min(beginX + info.getWindowWidth()/info.getScale() + 3,X);
		int endY = Math.min(beginY + info.getWindowHeight()/info.getScale() + 3,Y);
		
		// affichage du sol
		for(int i = beginX; i < endX; i ++) {
			for(int j = beginY; j < endY; j++) {
				pos.setCoordinates(i*32, j*32);
				ground[i][j].display(info, pos, g, io);
			}
		}
		
		// affichage entit�es
		for(AbstractEntity e : entities)
			e.display(info, null, g, io);
		
	}
	
	/**
	 * <p> remplissage de la map, a redefinir dans les classes filles </p>
	 */
	public abstract void fillMap();
	
	/**
	 * <p> ajout d'un sol g aux coordonnees (x, y) </p>
	 * @param g le type de sol
	 * @param x la coordonnee x
	 * @param y la coordonnee y
	 */
	public void addGround(AbstractGround g, int x, int y) {
		this.ground[x][y] = g;
	}
	
	/**
	 * @see entities.IMap#addEntity(AbstractEntity)
	 */
	public void addEntity(AbstractEntity e) {
		this.entities.add(e);
	}

	/**
	 * @see entities.IMap#removeEntity(AbstractEntity)
	 */
	public void removeEntity(AbstractEntity e) {
		this.entities.remove(e);
	}
	
	/**
	 * @see entities.IMap#requestPassThrough(Coordinates, Coordinates, AbstractEntity)
	 */
	public boolean requestPassThrough(Coordinates to, Coordinates from, AbstractEntity caller) {
		return this.canPassThrough(to);
	}

	/**
	 * @see entities.IMap#requestWarp(Coordinates, AbstractEntity)
	 */
	public void requestWarp(Coordinates coords, AbstractEntity caller) {
		
		boolean found = false;
		int i = 0; 
		Warp p = null;
		
		// recherche d'un warp
		while(i < warps.size() && !found) {
			
			p = warps.get(i);
			
			if(p.getWarpArea().contains(coords)) 
				found = true;
			
			i++;
		}
		
		// si warp trouv�, warp !
		if(found) 
			caller.warp(p);
		
	}
	
}
