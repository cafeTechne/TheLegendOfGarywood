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
	//a list of the monster's abilities
	private List<String> abilityList;
	//Monsters have loot
	private Treasure loot;
	//Monster region moderates the kinds of treasure they can have
	private String region;
	
	
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
		
	};
	
	
}
