import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster{
	
	//TODO: Use RNG to apply different adjectives to monster names on object creation
	private String name = "Drunken Goblin";
	

	private List<String> abilityList = new ArrayList<String>();
	
	public Goblin() {
		super(5, 5, .5, .5, 1, 2, 1, "forest");
		Application.currentRoom.addNpc(this);
	}
	
	public Goblin(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange,
			int sizeCategory, int level, String region) {
		super(hp, magicPoints, movementSpeed, attackSpeed, attackRange, sizeCategory, level, region);
		
		abilityList.add("taunt");
		System.out.println("A drunken goblin stumbles in.");
		Application.currentRoom.addNpc(this);
		

		this.engageTarget(Application.character);
	}
	
	public void engageTarget(Character c) {
		//1 turn towards target
		System.out.println("The goblin blinks it's eyes in disbelief, draws a dagger, and begins hobbling towards " + c.getName() + " .\n");
		
	};
	
	public String toString() {
		return name;
	}

}
