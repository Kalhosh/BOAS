package items;

public class Bleed extends Effect{

	int intensity;
	
	public Bleed(int duration, int intensity) {
		super(duration);
		this.intensity = intensity;
	}

	public void applyOnTarget(IEffectTarget target) {
		
		target.inflict(intensity, EffectType.RAW);
		this.reduceTimeLeft();
		
	}

}
