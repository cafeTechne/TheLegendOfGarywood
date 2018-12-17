
public class State_Sleep extends State {

		public void execute(NPC npc) {
			if(npc.isThreatened()) {
				npc.changeState(new State_RunAway());
			}
			else {
				npc.snore();
			}
		}
	//set the Orientation object of this to prone!
}
