
public interface Orientation {

	public boolean tryToMove();
	public String getOrientation();
	public double getDirection();
	public void setDirection(double direction);
	
}
	//Orientation: prone, supine, kneeling, standing, 
	//sitting, && which direction they are facing (in radians or degrees).

class Supine implements Orientation{
	
	//direction is == 0 because Character is facing towards the sky.
	private double direction = 0;
	String orientationStatus;
	
	//cannot change direction or move because you are supine	
	public boolean tryToMove() {
		return false;
	}

	public String getOrientation() {

		return "supine";
	}

	public double getDirection() {
		return 0;
	}

	@Override
	public void setDirection(double direction) {
		this.direction = 0;
		
	}
}

class Prone implements Orientation{
	
	//direction is == 0 because Character is facing towards the ground.
	private double direction = 0;
	String orientationStatus;
	
	//cannot change direction or move because you are prone	
	public boolean tryToMove() {
		return false;
	}

	public String getOrientation() {

		return "prone";
	}

	public double getDirection() {
		return 0;
	}

	@Override
	public void setDirection(double direction) {
		this.direction = 0;
		
	}
}

class Kneeling implements Orientation{
	
	private double direction = 0;
	String orientationStatus;
	
	//can change direction, but can not move because you are kneeling	
	public boolean tryToMove() {
		return false;
	}

	public String getOrientation() {

		return "kneeling";
	}

	public double getDirection() {
		return this.direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
}

class Sitting implements Orientation{
	
	private double direction = 0;
	String orientationStatus;
	
	//can change direction, but can not move because you are sitting	
	public boolean tryToMove() {
		return false;
	}

	public String getOrientation() {

		return "sitting";
	}

	public double getDirection() {
		return this.direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
}

class Standing implements Orientation{
	
	private double direction = 0;
	String orientationStatus;
	
	//can change direction, and can move because you are standing	
	public boolean tryToMove() {
		return true;
	}

	public String getOrientation() {

		return "standing";
	}

	public double getDirection() {
		return this.direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
}



