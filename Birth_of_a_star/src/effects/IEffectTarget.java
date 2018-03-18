package effects;

/**
 * @author BIZOT Loïc
 */
public interface IEffectTarget {

	/**
	 * @param e l'effet à appliquer sur l'entité 
	 */
	void applyEffect(Effect e);
	
	/**
	 * @param intensity puissance du sort
	 * @param type type du sort parmi l'enumeration EffectType
	 */
	void inflict(int intensity, EffectType type);
	
	/**
	 * @param intensity puissance du sort de soin
	 */
	void cure(int intensity);
	
}
