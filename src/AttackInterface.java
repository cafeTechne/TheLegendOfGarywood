
public interface AttackInterface  {

	//needs logic to decide on what target to attack
	//how will aggro work?
	//since this is single-player, should it just automatically target the PC?
	//or will we want NPCs to be able to be targeted
	public void findTarget();
	
	//It needs to close the distance at a rate of its movements speed per round
	//and then check if its target is within attack range,
	//if so then it needs to check if the target is in range: rangeChecker();
	public void engageTarget();
	
	//checks to see if currentRange is less than or equal to attackRange, if so then target can be attacked with the default attack that round
	public void rangeChecker();
	
	//uses the monster's default attack on the target
	public void attackTarget();
	
	//randomly selects a special ability from the monsters list of special abilities and uses it
	public void useSpecialAbility();
	
	//retreats from target if the monster fails a morale check, if a monster is below 25% health,
	//then it rolls for morale at the beginning of every turn
	//randomly chooses a direction from the available exits held in the Room object
	//once GUI is established, it can home in after an exit node after that logic
	public void retreat();
	
	
	
}
