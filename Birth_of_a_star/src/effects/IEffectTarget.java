package effects;

/**
 * @author BIZOT Lo�c
 */
public interface IEffectTarget {

	/**
	 * @param e l'effet � appliquer sur l'entit� 
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
