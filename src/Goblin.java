import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster{
	
	//
	

	private List<String> abilityList = new ArrayList<String>();
	
	public Goblin() {
		super(5, 5, .5, .5, 1, 2, 1, "forest");
	}
	
	public Goblin(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange,
			int sizeCategory, int level, String region) {
		super(hp, magicPoints, movementSpeed, attackSpeed, attackRange, sizeCategory, level, region);
		
		abilityList.add("taunt");
		System.out.println("A drunken goblin stumbles in.");
		
		//how do we control this behavior with turn-based or event based logic?
		//how do we let the Goblin have access to the character object? 
		//It must pull it from the room somehow? Observer pattern?
		this.engageTarget();
	}
	
	public void engageTarget(Character c) {
		//1 turn towards target
		System.out.println("The goblin blinks it's eyes in disbelief, draws a dagger, and begins hobbling towards" + c.getName());
		
	};
	

}
