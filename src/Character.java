import java.io.Serializable;
import java.util.*;

public class Character implements CharacterInterface, Serializable{

	private int intelligence = 1;
	private int strength = 1; 
	private int dexterity = 1;
	private int guile = 1;
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
		this.setGuile((int) (25 + ((Math.random()*50) +1)));
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
		System.out.println("Your Character's Guile is :" + this.getGuile());
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
		System.out.println("Choose a starting profession: 4 for Programmer");
		int newProfessionType = keyboard.nextInt();
		modifyStartingStats(newProfessionType);
		profession = professionFactory.chooseProfession(newProfessionType);
	}
	
	public void modifyStartingStats(int newProfessionType) {
		if(newProfessionType == 1) {
			int oldGuileValue = this.getGuile();
			this.setGuile(oldGuileValue + 10);
		} else if(newProfessionType == 2) {
			int oldStrengthValue = this.getStrength();
			this.setGuile(oldStrengthValue + 10);
		} else if(newProfessionType == 3) {
			int oldDexterityValue = this.getDexterity();
			this.setGuile(oldDexterityValue + 10);
		}else if(newProfessionType == 4) {
			int oldIntelligenceValue = this.getIntelligence();
			this.setIntelligence((oldIntelligenceValue + 10));
		}
	}

	public int getGuile() {
		return guile;
	}

	public void setGuile(int guile) {
		this.guile = guile;
	}

	
	/**
	 *  In this method we are going to handle the character's movement patterns.
	 *  We will also trigger the movement animation.
	 */
	@Override
	public void onMove() {
		// TODO Auto-generated method stub		
	}

	/**
	 * since each of the character classes has a specific attack type, 
	 * the only thing we will do here is handle the animation trigger 
	 * and also make sure (in terms of game design, this step may vary) 
	 * that we have the needed setup for the attack to commence. 
	 * Calculate the damage to the target as well.
	 */
	
	@Override
	public void onAttack() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * this will trigger the death animation, save statistics or whatever 
	 * is needed to be saved in order for the game to go further with its logic.
	 */
	
	@Override
	public void onCharacterDeath() {
		// TODO Auto-generated method stub
		
	}

	/**
	 *  this should basically just trigger an animation whenever we want 
	 *  to interact with something. 
	 *  
	 *  However, the four character types may have a different way in 
	 *  interacting with objects.
	 */
	@Override
	public void onActionTrigger() {
		// TODO Auto-generated method stub
		
	}
	
	public void changeDirection(double directionTarget) {
		orientationStatus.setDirection(directionTarget);
	}
	
	
}
