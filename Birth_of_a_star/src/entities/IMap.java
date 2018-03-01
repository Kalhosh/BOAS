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
	 * @param to la position d'arriv�e
	 * @param from la position de d�part
	 * @param caller l'entit� souhaitant se d�placer
	 * @return true si l'entit� appelante peut se d�placer de from � to, false dans le cas contraire
	 */
	public boolean requestPassThrough(Coordinates to, Coordinates from, AbstractEntity caller);
	
}
