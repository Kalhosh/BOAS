package items;

import java.util.ArrayList;

import effects.Effect;

/**
 * @author BIZOT Loïc
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
	 * @param target l'entite sur laquelle est utilisée l'objet
	 */
	public void use(ItemTarget target) {
		
		for(Effect e: effects)
			target.applyEffect(e);
		
	}

	/**
	 * <p> appellée dans le constructeur, initialise les effets
	 */
	public abstract void initEffects();
	
	/**
	 * <p> appellée dans le constructeur, initialise les utilitées
	 */
	public abstract void initUses();
	
	/**
	 * @param e l'effet à ajouter
	 */
	public void addEffect(Effect e) {
		
		effects.add(e);
		
	}
	
}
