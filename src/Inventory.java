
public class Inventory {

	private int numberOfItems = 1;
	
	
	//need an array of Items objects
	//need 3 basic classes of items, weapons, armor and utility items which
	//inherit from this base class
	public Inventory(int numberOfItems) {
		this.setNumberOfItems(numberOfItems);
	}
	
	public static void displayInventory() {
		
		
		
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
}
