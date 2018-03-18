package items;

import java.util.ArrayList;

/**
 * @author BIZOT Loïc
 */
public class Inventory {

	private ArrayList<Item> containt;
	private static final int threshold = 16;
	
	public Inventory() {
		containt = new ArrayList<>();
	}
	
	/**
	 * <p> pas de verification de la cohérence de index </p>
	 * @param index la position de l'objet dans le sac
	 * @return l'objet à la position index dans le sac
	 */
	public Item getItem(int index){
		return containt.get(index);
	}
	
	/**
	 * @return le nombre d'objet déjà présents dans le sac
	 */
	public int getNbOfItems() {
		return containt.size();
	}
	
	/**
	 * <p> pas de verifcation de dépassement du seuil </p>
	 * @param item l'objet à rajouter dans le sac
	 */
	public void addItem(Item item) {
		containt.add(item);
	}

	/**
	 * @return true si l'on peut rajouter un item dans le sac, false sinon
	 */
	public boolean canAddItem() {
		return containt.size() < threshold;
	}
	
}
