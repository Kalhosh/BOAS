package controls;

public abstract class NPController {

	private IControlled controlled;
	
	public NPController(IControlled c) {
		controlled = c;
	}
	
	public abstract void requestAction(BattleState state);
	
	public abstract void routine(State state);
	
	public IControlled getControlled() {
		return this.controlled;
	}
	
}
