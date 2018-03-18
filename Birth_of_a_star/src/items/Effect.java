package items;

/**
 * @author BIZOT Lo�c
 */
public abstract class Effect {

	protected int duration;
	protected int timeLeft;
	
	public Effect(int duration) {
		
		this.duration = duration;
		this.timeLeft = duration;
		
	}
	
	/**
	 * @param target la cible sur laquelle appliquer les effets
	 */
	public abstract void applyOnTarget(IEffectTarget target);
	
	/**
	 * <p> timeLeft -- </p>
	 */
	public void reduceTimeLeft() {
		timeLeft --;
	}
	
	/**
	 * @return true si le sort est encore applicable � l'entit�, false sinon
	 */
	public boolean isActive() {
		return timeLeft > 0;
	}
	
}
