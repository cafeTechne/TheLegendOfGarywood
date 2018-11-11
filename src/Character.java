import java.util.*;

public class Character {

	private int intelligence = 1;
	private int strength = 1; 
	private int dexterity = 1;
	private int health = 100;
	private String name;
	private Profession profession;
	Scanner keyboard = new Scanner(System.in);

	//Orientation: prone, supine, kneeling, standing, sitting, 
	//&& which direction they are facing (in radians or degrees).
	public Orientation orientationStatus;

	
	public Character(String name) {
		this.setIntelligence((int) (25 + ((Math.random()*25) +1)));
		this.setStrength((int) (25 + ((Math.random()*50) +1)));
		this.setDexterity((int) (25 + ((Math.random()*50) +1)));
		this.setName(name);
		this.setHealth(100);
		
		//sets the location to the starting location
		Location currentLocation = new Location(1.0, 1.0, 1);

		//choose profession
		chooseProfession();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	public boolean tryToMove(){
		
		        return orientationStatus.tryToMove();
		        
		    }

	
	    public void setOrientationStatus(Orientation newOrientationStatus){
	
	        orientationStatus = newOrientationStatus;
	
	    }

	public void displayInfo() {
		System.out.println("Your Character's name is: " + this.getName());
		System.out.println("Your Character's Strength is :" + this.getStrength());
		System.out.println("Your Character's Intelligence is :" + this.getIntelligence());
		System.out.println("Your Character's Dexterity is :" + this.getDexterity());
		System.out.println("Your Profession is: " + this.profession);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	    
	public void chooseProfession() {
		ProfessionFactory professionFactory = new ProfessionFactory();
		System.out.println("Choose a starting profession: 1 for Accountant");
		System.out.println("Choose a starting profession: 2 for Janitor");
		System.out.println("Choose a starting profession: 3 for Artist");
		int newProfessionType = keyboard.nextInt();
		profession = professionFactory.chooseProfession(newProfessionType);
	}
	
}
