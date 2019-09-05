import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster implements Serializable{
	
	//TODO: Use RNG to apply different adjectives to monster names on object creation
	private String name = "Drunken Goblin";
	

	private List<String> abilityList = new ArrayList<String>();
	
	public Goblin() {
		super(5, 5, .5, .5, 1, 2, 1, 0, 0, 0, "forest", "goblin");
		Application.currentRoom.addNpc(this);
	}
	
	public Goblin(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange,
			int sizeCategory, int level,int slashDefense, int pierceDefense, int bashDefense, String region, String name) {
		super(hp, magicPoints, movementSpeed, attackSpeed, attackRange, sizeCategory, level, slashDefense, pierceDefense, bashDefense, region, name);
		this.name = name;
		abilityList.add("taunt");
		System.out.println("\nA " +  this.getName()+ " stumbles in.");
		Application.currentRoom.addNpc(this);
		

		this.engageTarget(Application.character);
	}
	
	public void engageTarget(Character c) {
		//1 turn towards target
		System.out.println("\nThe goblin blinks it's eyes in disbelief, draws a dagger, and begins hobbling towards " + c.getName() + " .\n");
		
	};
	
	public String toString() {
		return this.getName();
	}

}
