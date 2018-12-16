import java.util.List;

public class Monster extends NPC implements MonsterInterface{
	
	//set 10 hp to be the lowest a monster could possibly start off with
	private int level = 1;
	private int hitPoints = 10;
	private int magicPoints = 0;
	private double movementSpeed = 1;
	private double attackSpeed = 1;
	private double attackRange = 1;
	//set an enum type system for creature size where 3 is humanoid size, 2 is halfling size, 1 is tiny, 4 is giant size, 5 is gargantuan, etc.
	private int sizeCategory = 3;
	
	//the monster's orientation in space
	private Orientation monsterOrientationStatus;
	
	//a list of the monster's abilities,
	//should there be a hash of unique ability ID's
	//to make life easy for data-basing?
	private List<String> abilityList;
	
	//Monsters have loot
	private Treasure loot;
	
	//Monster region moderates the kinds of treasure they can have
	private String region;
	
	//target the monster is currently engaging
	private String currentTarget;
	
	
	public Monster(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange, int sizeCategory, List<String> abilityList) {
		this.setHitPoints(hp);
		this.setAttackSpeed(attackSpeed);
		this.setSizeCategory(sizeCategory);
		this.setAbilityList(abilityList);
		this.setMagicPoints(magicPoints);
		this.setMovementSpeed(movementSpeed);
		this.setAttackRange(attackRange);
		this.loot = new Treasure(level, region);
	}


	public int getHitPoints() {
		return hitPoints;
	}


	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}


	public int getMagicPoints() {
		return magicPoints;
	}


	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}


	public double getMovementSpeed() {
		return movementSpeed;
	}


	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}


	public double getAttackSpeed() {
		return attackSpeed;
	}


	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
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


	public double getAttackRange() {
		return attackRange;
	}


	public void setAttackRange(double attackRange) {
		this.attackRange = attackRange;
	}

	
	public void takeDamage(int hp) {
		this.hitPoints = this.hitPoints-hp;
		
		if(this.hitPoints <= 0) {
			//Monster dies.
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
		
		return monsterOrientationStatus.tryToMove();
		        
	}

	//this allows us to establish the orientation of a monster... i.e. is it kneeling,
	//sitting, prone, supine, etc.
    public void setOrientationStatus(Orientation newOrientationStatus){

        monsterOrientationStatus = newOrientationStatus;

    }

	public String getOrientation() {
		return monsterOrientationStatus.getOrientation();
	}
	public double getDirection() {
		return monsterOrientationStatus.getDirection();
	}

	public void setDirection(double direction) {
		monsterOrientationStatus.setDirection(direction);
	}
	
	
}
