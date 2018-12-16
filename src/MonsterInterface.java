
public interface MonsterInterface {


	/**
	 * Triggers the preset move animation.
	 */
	public void onMove();
	
	/**
	 * Triggers the attack animations
	 */
	
	public void onAttack();
	
	/**
	 * Triggers the death animations, possible item drops,
	 * "and other maintenance stuff"
	 */
	
	public void onMonsterDeath();
	
	
	/**
	 * Triggers consequent of actions
	 */
	
	public void onActionTrigger();
	
}
