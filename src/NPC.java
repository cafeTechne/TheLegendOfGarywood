import java.io.Serializable;

public class NPC extends Entity implements Serializable {

    private String name;

	public boolean isSafe() {
		//set to a default value for now
		return false;
	}

	public void changeState(State newState) {

	}

	public void moveAwayFromEnemy() {
		//this is just some default code to template out the state design pattern
		// TODO Auto-generated method stub

	}

	public boolean isThreatened() {
		// TODO Auto-generated method stub
		return false;
	}

	public void snore() {
		// TODO Auto-generated method stub
		System.out.println("ZzzZzZZZZZZ...");
	}
	
	//over-ridden so that 
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
}
