package triggers;

import java.util.ArrayList;

/**
 * <p> un �l�ment d�clencheur basique </p>
 * @author BIZOT Lo�c
 */
public class TriggerSource {

	ArrayList<TriggerTarget> targets;
	
	public TriggerSource() {
		targets = new ArrayList<>();
	}
	
	/**
	 * <p> ajoute une cible a declencher </p> 
	 * @param t une cible de declencheur a ajouter
	 * */
	void addTarget(TriggerTarget t) {
		targets.add(t);
	}
	
	/**
	 * <p> enl�ve une cible a declencher </p> 
	 * @param t une cible de declencheur a enlever
	 * */
	void removeTarget(TriggerTarget t) {
		targets.remove(t);
	}
	
	/**
	 * <p> declenche toute les cibles </p>
	 * */
	void triggerTargets() {
		for(TriggerTarget t : targets)
			t.trigger();
	}
	
}
