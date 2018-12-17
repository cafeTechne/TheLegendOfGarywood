
public class State {

	private State currentState;
	
	public void execute(NPC npc) {
		//does what the state does...
	}
	
	public void changeState(State newState) {
		//currentState.dispose()  in libGDX I think we will be able to manually dispose of these objects
		//instead of relying on the garbage collector
		
		currentState = newState;
	}
	
	public State getState() {
		return currentState;
	}

}
