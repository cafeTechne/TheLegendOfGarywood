import java.util.ArrayList;
import java.util.List;

public class Monster extends NPC implements MonsterInterface, AttackInterface{
	
	//set 10 hp to be the lowest a monster could possibly start off with
	private int level = 1;
	
	//TODO: Should monsters be allowed to level up if there are a finite number of them?
	private int currentExperience = 1;

	
	//TODO: set an enum type system for creature size where 3 is humanoid size, 2 is halfling size, 1 is tiny, 4 is giant size, 5 is gargantuan, etc.
	private int sizeCategory = 3;
		
	//holds the behavioral state object, since it has only one state at a time
	//example: running, fighting, sleeping, etc.
	//TODO: Should this be moved to the Entity class? Think about FEAR spells that make a character RUN AWAY... hmmm. Makes me think: yes.
	private State currentState;
	
	//a list of the monster's abilities,
	//should there be a hash of unique ability ID's
	//to make life easy for data-basing?
	private List<String> abilityList = new ArrayList<String>();
	
	//Monsters have loot
	private Treasure loot;
	
	//Monster region moderates the kinds of treasure they can have
	private String region;
	
	//target the monster is currently engaging
	private String currentTarget;
	
	
	public Monster(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange, int sizeCategory, int level, String region) {
		this.setHealth(hp);
		this.setMana(magicPoints);
		
		this.setAttackSpeed(attackSpeed);
		this.setSizeCategory(sizeCategory);
		this.setAbilityList(abilityList);
		
		this.setMovementSpeed(movementSpeed);
		this.setAttackRange(attackRange);
		this.loot = new Treasure(level, region);
		this.setOrientationStatus(new Standing());
	}


	public void update() {
		currentState.execute(this);
	}
	
	public int getSizeCategory() {
		return sizeCategory;
	}


	public void setSizeCategory(int sizeCategory) {
		this.sizeCategory = sizeCategory;
	}


	public List<String> getAbilityList() {
		return abilityList;
	}


	public void setAbilityList(List<String> abilityList) {
		this.abilityList = abilityList;
	}


	
	public void takeDamage(int hp) {
		this.setHealth(this.getHealth() - hp);
		
		if(this.getHealth() <= 0) {
			//Monster dies.
			//TODO: Monster death logic
			onMonsterDeath();
		}
	}
	
	/**
	 * Triggers the preset move animation.
	 */
	public void onMove() {
		
	};
	
	/**
	 * Triggers the attack animations
	 */
	
	public void onAttack() {
		
	};
	
	/**
	 * Triggers the death animations, possible item drops,
	 * "and other maintenance stuff"
	 */
	
	public void onMonsterDeath() {
		//TODO: unique monster death messaging/animation triggered
		//TODO: reward treasure method called
		Application.currentRoom.removeNpc(this);
	};
	
	
	/**
	 * Triggers consequent of actions
	 */
	
	public void onActionTrigger() {
		
	}


	public String getCurrentTarget() {
		return currentTarget;
	}


	public void setCurrentTarget(String currentTarget) {
		this.currentTarget = currentTarget;
	};
	
	
	/*
	 * Methods contained in the AttackInterface:
	 */
	
	//needs logic to decide on what target to attack
	//how will aggro work?
	//since this is single-player atm, should it just automatically target the PC?
	//or will we want NPCs to be able to be targeted?
	public void findTarget() {
		//1 generate list of potential targets
		
		//2 decision logic
		
		//3 call engageTarget();
	};
	
	//It needs to close the distance at a rate of its movements speed per round
	//and then check if its target is within attack range,
	//if so then it needs to check if the target is in range: rangeChecker();
	public void engageTarget() {
		//1 turn towards target 
		
	};
	
	//checks to see if currentRange is less than or equal to attackRange, if so then target can be attacked with the default attack that round
	public void rangeChecker() {
		
	};
	
	//uses the monster's default attack on the target
	public void attackTarget() {
		
	};
	
	//randomly selects a special ability from the monsters list of special abilities and uses it
	public void useSpecialAbility() {
		
	};
	
	//retreats from target if the monster fails a morale check, if a monster is below 25% health,
	//then it rolls for morale at the beginning of every turn
	//randomly chooses a direction from the available exits held in the Room object
	//once GUI is established, it can home in after an exit node after that logic
	public void retreat() {
		
	};
		
	/**
	 * Methods from the Orientation Interface:
	 */
	
	public boolean tryToMove(){
		
		return orientationStatus.tryToMove();
		        
	}

	
	
	
}
