package entities;

import resources.Coordinates;

public interface IMap {

	/**
	 * @param e entitee a ajouter sur la carte
	 */
	public void addEntity(AbstractEntity e);
	
	/**
	 * @param e entitee a enlever sur la carte
	 */
	public void removeEntity(AbstractEntity e);

	/**
	 * @param to la position d'arrivée
	 * @param from la position de départ
	 * @param caller l'entité souhaitant se déplacer
	 * @return true si l'entité appelante peut se déplacer de from à to, false dans le cas contraire
	 */
	public boolean requestPassThrough(Coordinates to, Coordinates from, AbstractEntity caller);
	
}
