package maps;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;

import algorithms.ColisionHandler;
import entities.IMap;
import map_exceptions.InvalidMapDimensionException;
import resources.AbstractGround;
import resources.DisplayInfo;

/**
 * @author BIZOT Loïc
 */
public abstract class AbstractMap implements ColisionHandler,IMap{

	private AbstractGround ground[][];
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
		
		if(X > 0 && Y > 0)
			ground = new AbstractGround[X][Y];
		else
			throw new InvalidMapDimensionException(X,Y);
		
		fillMap();
		
	}
	
	/**
	 * @see algorithms.ColisionHandler#canPassThrough(Point2D)
	 * */
	public boolean canPassThrough(Point2D coord){
		
		int x = (int) coord.getX();
		int y = (int) coord.getY();
		
		if(isInBounds(coord))
			return ground[x][y].canPassThrough();
		else
			return false;
		
	}
	
	/**
	 * @see algorithms.ColisionHandler#isInBounds(Point2D)
	 */
	public boolean isInBounds(Point2D coord) {
		
		int x = (int)coord.getX();
		int y = (int)coord.getY();
		
		boolean res = x >= 0 && x < X;
		res = res &&  y >= 0 && y < Y;
		
		return res;
		
	}
	
	/**
	 * <p> Affiche une portion de la carte, en fonction de la vue </p>
	 * @param info centre et zoom de la camera
	 * @param g contexte graphique
	 * @param io panneau
	 */
	public void displayMap(DisplayInfo info, Graphics2D g, ImageObserver io) {
		
		// variable d'optimisation
		Point2D pos = new Point2D.Double();
		
		// calcul de la portion a afficher
		int debutX = 0;
		int debutY = 0;
		int finX = X;
		int finY = Y;
		
		// affichage du sol
		for(int i = debutX; i < finX; i ++) {
			for(int j = debutY; j < finY; j++) {
				pos.setLocation(i, j);
				ground[i][j].display(info, pos, g, io);
			}
		}
		
	}

	@Override
	public int getWidth() {
		return X;
	}

	@Override
	public int getHeight() {
		return Y;
	}
	
	public abstract void fillMap();
	
	// a enlever
	public void addGround(AbstractGround g, int x, int y) {
		
		this.ground[x][y] = g;
		
	}
	
}
