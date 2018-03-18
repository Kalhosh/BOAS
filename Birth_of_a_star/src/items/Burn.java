package items;

public class Burn extends Effect{

	private int intensity;
	
	public Burn(int duration, int intensity) {
		super(duration);
		this.intensity = intensity;
	}
	
	public void applyOnTarget(IEffectTarget target) {
		
		target.inflict(intensity, EffectType.FIRE);
		this.reduceTimeLeft();
		
	}

}
