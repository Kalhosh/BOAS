package items;

public class Chaos extends Effect{

	public int intensity;
	
	public Chaos(int duration, int intensity) {
		super(duration);
		this.intensity = intensity;
	}
	
	public void applyOnTarget(IEffectTarget target) {
		
		double scalar = Math.random()*3;
		int realIntensity = (int) (intensity*scalar);
		
		target.inflict(realIntensity, EffectType.CHAOS);
		
	}

}
