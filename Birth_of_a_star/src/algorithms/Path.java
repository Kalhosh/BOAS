package algorithms;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import path_exceptions.PathIndexOutOfBoundsException;

/**
 * @author BIZOT Loïc
 */
public class Path {

	private ArrayList<Point2D> coordinates;
	private int iterator;
	
	public Path() {
		coordinates = new ArrayList<>();
		iterator = 0;
	}
	
	/**
	 * @return true si l'on peu encore parcourir la liste, false sinon
	 */
	public boolean hastNext() {
		return iterator < coordinates.size();
	}
	
	/**
	 * @return le point a l'index iterator
	 * @throws PathIndexOutOfBoundsException
	 */
	private Point2D current() throws PathIndexOutOfBoundsException {
		
		if(iterator >= coordinates.size())
			throw new PathIndexOutOfBoundsException(); 
		else
			return coordinates.get(iterator);
		
	}
	
	/**
	 * @return le point a l'index iterator, incremente ensuite l'iterateur
	 * @throws PathIndexOutOfBoundsException appel de next en fin de liste
	 */
	public Point2D next() throws PathIndexOutOfBoundsException {
		
		Point2D res = current();
		iterator ++;
		
		return res;
		
	}
	
	/**
	 * @return la longueur du chemin
	 */
	public int size() {
		return coordinates.size();
	}
	
	/**
	 * <p> accessible qu'au package </p>
	 * @param point point a ajouter a la collection
	 */
	protected void add(Point2D point) {
		coordinates.add(0,point);
	}
	
}
