package items;

import java.util.ArrayList;

import effects.Effect;

/**
 * @author BIZOT Lo�c
 */
public abstract class Item {

	public ArrayList<Effect> effects;
	public ArrayList<Uses> uses;
	public String description;
	
	public Item(String description) {
		
		initEffects();
		initUses();
		this.description = description; 
		
	}
	
	/**
	 * @param target l'entite sur laquelle est utilis�e l'objet
	 */
	public void use(ItemTarget target) {
		
		for(Effect e: effects)
			target.applyEffect(e);
		
	}

	/**
	 * <p> appell�e dans le constructeur, initialise les effets
	 */
	public abstract void initEffects();
	
	/**
	 * <p> appell�e dans le constructeur, initialise les utilit�es
	 */
	public abstract void initUses();
	
	/**
	 * @param e l'effet � ajouter
	 */
	public void addEffect(Effect e) {
		
		effects.add(e);
		
	}
	
}
