
public class Location extends Room{

	private double xCoordinate = 1;
	private double yCoordinate = 1;

	public Location(double xCoord, double yCoord, int roomNumber) {
		super(roomNumber);
		this.xCoordinate = 1;
		this.yCoordinate = 1;
		
	}
	

	public void setLocation(double xCoord, double yCoord) {
		this.xCoordinate = xCoord;
		this.yCoordinate = yCoord;
	}
	
	public double[] getLocation() {
		double [] location ={this.xCoordinate, this.yCoordinate}; 
		return location;
	}
	
}
