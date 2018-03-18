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
	
	/**
	 * <p> appelée à chaque pas, regarde si l'entitée est sur un warp </p>
	 * @param coords la coordonnée de l'entité appelante
	 * @param caller l'entité appelante
	 */
	public void requestWarp(Coordinates coords, AbstractEntity caller);
	
}
