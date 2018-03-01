package algorithms;

import resources.Coordinates;

/**
 * @author BIZOT Loïc
 * <p> maillon contenant une case et 
 * une reference vers les cases 
 * precedentes du chemin </p>  
 */
public class Link{
	
	private Link previousCoord;
	private Coordinates currentCoord;
	private int index;
	
	/**
	 * @param previousCoord case precedente
	 * @param currentCoord case actuelle
	 */
	protected Link(Link previousCoord, Coordinates currentCoord) {
		
		this.previousCoord = previousCoord;
		this.currentCoord = currentCoord;
		this.index = -1;
		
	}
	
	/**
	 * @return une reference vers les coordonnees precedentes 
	 */
	public Link getPrevious() {
		return previousCoord;
	}
	
	/**
	 * @return la coordonnee courante
	 */
	public Coordinates getCurrent() {
		return currentCoord;
	}
	
	/**
	 * <p> a utiliser a la fin du traitement de ce lien,
	 * l'index permettra d'ordonner la pile de traitement
	 * @param index le nouvel index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * @return l'index de ce lien, un lien negatif correspond a un 
	 * lien non traite, un lien positif correspond a un lien traite a ne plus toucher
	 */
	public int getIndex() {
		return index;
	}
	
}
