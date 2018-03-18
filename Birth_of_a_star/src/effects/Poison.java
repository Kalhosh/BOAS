package effects;

/**
 * @author BIZOT Loïc
 */
public abstract class Poison extends Effect{

	private int intensity;
	
	public Poison(int duration, int intensity) {
		super(duration);
		this.intensity = intensity;
	}

	public void applyOnTarget(IEffectTarget target) {
		
		target.inflict(intensity, EffectType.POISON);
		this.reduceTimeLeft();
		
	}

}
