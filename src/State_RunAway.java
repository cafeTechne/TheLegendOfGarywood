
public class State_RunAway extends State {

	//since monster extends NPC, this state logic is extended to Monster class objects via polymorphism
	public void Execute(NPC npc) {
		if(npc.isSafe()) {
			npc.changeState(new State_Sleep());
		}
		else {
			npc.moveAwayFromEnemy();
		}
	}
}
