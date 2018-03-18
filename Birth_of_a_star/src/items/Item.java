package items;

import java.util.ArrayList;

/**
 * @author BIZOT Lo�c
 */
public abstract class Item {

	public ArrayList<Effect> effects;
	
	public Item() {
		
		initEffects();
		
	}
	
	/**
	 * @param target l'entite sur laquelle est utilis�e l'objet
	 */
	public void use(IEffectTarget target) {
		
		for(Effect e: effects)
			target.applyEffect(e);
		
	}

	/**
	 * <p> appell�e dans le constructeur, initialise les effets
	 */
	public abstract void initEffects();
	
	/**
	 * @param e l'effet � ajouter
	 */
	public void addEffect(Effect e) {
		
		effects.add(e);
		
	}
	
}
