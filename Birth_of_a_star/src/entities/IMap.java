package entities;

public interface IMap {

	/**
	 * @param e entitee a ajouter sur la carte
	 */
	public void addEntity(AbstractEntity e);
	
	/**
	 * @param e entitee a enlever sur la carte
	 */
	public void removeEntity(AbstractEntity e);
	
}
