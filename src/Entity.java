
public class Entity {

	
	
	private int health = 100;
	int manaPoints = 100;
	
	
	Location currentLocation;

	private boolean thirsty = false;
	private boolean hungry = false;
	
	private double movementSpeed = 1;
	private double attackSpeed = 1;
	private double attackRange = 1;
	

	//TODO: Find a good way to meaningfully generate random emotional states
	private EmotionalState currentEmotion = new EmotionalStateHappiness();
	
	//Orientation: prone, supine, kneeling, standing, sitting, 
		//&& which direction they are facing (in radians or degrees).
		//Sets the default position at start to standing
	public Orientation orientationStatus = new Standing();
	
	
	public Entity(){
		
	}
	
	public boolean tryToMove(){
		
		return orientationStatus.tryToMove();
		        
	}

    public void setOrientationStatus(Orientation newOrientationStatus){

        orientationStatus = newOrientationStatus;

    }
    
    public Orientation getOrientationStatus() {
    	return orientationStatus;
    }
    

  	public String getOrientation() {
  		return orientationStatus.getOrientation();
  	}

  	public double getDirection() {
  		return orientationStatus.getDirection();
  	}

  	public void setDirection(double direction) {
  		orientationStatus.setDirection(direction);
  	}
    
    
    
    
	public void changeDirection(double directionTarget) {
		orientationStatus.setDirection(directionTarget);
	}
	
	
	public boolean isThirsty() {
		return thirsty;
	}

	protected void setThirsty(boolean thirsty) {
		this.thirsty = thirsty;
	}

	public boolean isHungry() {
		return hungry;
	}

	protected void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}
	
	protected void setMana(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	
	public int getMana() {
		return manaPoints;
	}

	public EmotionalState getCurrentEmotion() {
		return currentEmotion;
	}

	public void setCurrentEmotion(EmotionalState currentEmotion) {
		this.currentEmotion = currentEmotion;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	protected void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
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

	public double getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(double attackRange) {
		this.attackRange = attackRange;
	}
	
}
