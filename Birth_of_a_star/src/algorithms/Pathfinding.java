package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import map_exceptions.OutOfMapBoundsException;
import resources.Coordinates;

/**
 * @author BIZOT Loïc
 */
public class Pathfinding {

	ColisionHandler colisisonHandler;
	
	/**
	 * @param colisisonHandler la carte sur laquelle s'effectue la recherche de chemin
	 */
	public Pathfinding(ColisionHandler colisisonHandler) {
		this.colisisonHandler = colisisonHandler;
	}
	
	/**
	 * <p> Dans ce pathfinding, on traite les cases proches de la case d'arrivee en premier, 
	 * on prend pour hypothese qu'il y a peu d'obstacles entres les cases de debut 
	 * et d'arrivee </p> 
	 * @param begin depart du chemin
	 * @param end fin du chemin
	 * @param tag option de pathfinding
	 * @return le chemin le plus court entre begin et end
	 * @throws OutOfMapBoundsException l'une des cases begin ou end est en dehors de la carte 
	 */
	public Path findShortestPath(Coordinates begin, Coordinates end, OptimiserTag tag) throws OutOfMapBoundsException {
		
		// arret brutal lors de l'invalidite de la coordonnee de depart
		if(!colisisonHandler.isInBounds(begin)) {
			int x = (int)begin.getX();
			int y = (int)begin.getY();
			throw new OutOfMapBoundsException(x, y);
		}
		
		// arret brutal lors de l'invalidite de la coordonne d'arrivee 
		if(!colisisonHandler.isInBounds(end)) {
			int x = (int)end.getX();
			int y = (int)end.getY();
			throw new OutOfMapBoundsException(x, y);
		}
		
		// initialisation du parcour
		
		// point de depart
		Coordinates currentPointResearch = begin;
		
		// tableau de cases deja atteintes
		int width = colisisonHandler.getWidth();
		int height = colisisonHandler.getHeight();
		boolean foundCoords[][] = new boolean[width][height];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++)
				foundCoords[i][j] = false;
		
		// iterateur de pile
		int iteratorOrderPile = 0;
		
		// pile de traitement
		
		ArrayList<Link> orderPile = new ArrayList<>(); 
		
		Link firstLink = new Link(null,begin);
		orderPile.add(firstLink);
		
		// indicateur de cible trouvee
		boolean found = false;
		
		// lien final
		Link finalLink = null;
		
		// parcour en largeur
		while(iteratorOrderPile < orderPile.size() && !found) {
			
			// obtention du point a traiter
			Link currentLink = orderPile.get(iteratorOrderPile);
			currentPointResearch = currentLink.getCurrent();
			double currentX = currentPointResearch.getX();
			double currentY = currentPointResearch.getY();
			
			// recherche des points adjacents
			for(int i = 0; i < 4; i++) {
				
				// obtention d'un voisin (trigonometrie)
				double angle = Math.PI*i/2;
				int newX = (int) (currentX + Math.cos(angle));
				int newY = (int) (currentY + Math.sin(angle));
				Coordinates neighbour = new Coordinates(newX, newY); 
				
				// coordonees entieres 
				int x = (int)neighbour.getX();
				int y = (int)neighbour.getY();
				
				// verification de la validite du point
				if(colisisonHandler.isInBounds(neighbour) && !foundCoords[x][y]){
					
					if(neighbour.equals(end)) {
					
						// on est arrive au point final
						found = true;
						finalLink = new Link(currentLink, neighbour);
						
					}
					else if(colisisonHandler.canPassThrough(neighbour)) {
					
						// ajouter le voisin a la pile de traitement
						Link newLink = new Link(currentLink,neighbour);
						orderPile.add(newLink);
					
					} 
					
					// dans tout les cas la case a ete atteinte
					foundCoords[x][y] = true;
				
				}
				
			}
			
			// fin de traitement, on indexe le lien courant
			currentLink.setIndex(iteratorOrderPile);
			
			// tri afin d'optimiser la recherche de chemin
			if(tag == OptimiserTag.DISTANCE_OPTIMISER)
				Collections.sort(orderPile, new DistanceOptimiser(end));
			
			// passage au nouveau point a traiter
			iteratorOrderPile ++;
			
		}
		
		// path trouve
		if(found) {
			
			// obtention du path
			Path res = new Path();
			Link linkedPath = finalLink;
			
			// on remonte la chaine
			while(linkedPath != null) {
				
				res.add(linkedPath.getCurrent());
				linkedPath = linkedPath.getPrevious();
				
			}

			return res;
			
		}
		// path non trouve
		else {
			return null;
		}
		
	}
	
}
