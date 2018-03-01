package triggers;

import java.util.ArrayList;

/**
 * <p> un élément déclencheur basique </p>
 * @author BIZOT Loïc
 */
public class TriggerSource {

	ArrayList<TriggerTarget> targets;
	
	public TriggerSource() {
		targets = new ArrayList<>();
	}
	
	/**
	 * <p> ajoute une cible a declencher </p> 
	 * @param t : une cible de declencheur a ajouter
	 * */
	void addTarget(TriggerTarget t) {
		targets.add(t);
	}
	
	/**
	 * <p> declenche toute les cibles </p>
	 * */
	void triggerTargets() {
		for(TriggerTarget t : targets)
			t.trigger();
	}
	
}
