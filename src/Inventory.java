import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {

	private int maximumNumberOfItems = 20;
	private int currentNumberOfItems = 1;
	private ArrayList<Item> itemList;
	private String bagName = "old backpack";
	private int bagWidth = 2;
	private int bagHeight = 2;
	private int bagDepth = 2;
	
	//need an array of Items objects
	//need 3 basic classes of items, weapons, armor and utility items which
	//inherit from this base class
	public Inventory(int maximumNumberOfItems) {
		this.setMaximumNumberOfItems(maximumNumberOfItems);
	}
	
	public void displayInventory() {
		
		for(int i=0; i<getCurrentNumberOfItems(); i++) {
			System.out.println("item " + i);
		}
		
	}

	public int getMaximumNumberOfItems() {
		return maximumNumberOfItems;
	}

	public void setMaximumNumberOfItems(int numberOfItems) {
		this.maximumNumberOfItems = numberOfItems;
	}

	public int getCurrentNumberOfItems() {
		return currentNumberOfItems;
	}

	public void setCurrentNumberOfItems(int currentNumberOfItems) {
		this.currentNumberOfItems = currentNumberOfItems;
	}
	
	public void getItem(Item itemToAdd) {
		if(this.currentNumberOfItems < this.maximumNumberOfItems) {
			itemList.add(itemToAdd);
			this.currentNumberOfItems++;
			System.out.println("You pick up a " + itemToAdd.toString());
		} else {
			System.out.println("You have no more room in your " + this.bagName);
		}
	}
	
	public void setBag(int bagIDNumber) {
		if(bagIDNumber == 0) {
			this.bagName = "old backpack";
			this.setBagWidth(2);
			this.setBagHeight(2);
			this.setBagDepth(2);
			this.maximumNumberOfItems = 20;
		}
		if(bagIDNumber == 1) {
			this.bagName = "leather satchel";
			this.setBagWidth(2);
			this.setBagHeight(3);
			this.setBagDepth(2);
			this.maximumNumberOfItems = 30;
				}
		if(bagIDNumber == 2) {
			this.bagName = "hempen haversack";
			this.setBagWidth(2);
			this.setBagHeight(3);
			this.setBagDepth(3);
			this.maximumNumberOfItems = 40;
		}
		if(bagIDNumber == 3) {
			this.bagName = "duffel bag";
			this.setBagWidth(3);
			this.setBagHeight(3);
			this.setBagDepth(3);
			this.maximumNumberOfItems = 50;
		}
		if(bagIDNumber == 4) {
			this.bagName = "ruck sack";
			this.setBagWidth(3);
			this.setBagHeight(4);
			this.setBagDepth(3);
			this.maximumNumberOfItems = 60;
		}
		if(bagIDNumber == 5) {
			this.bagName = "fancy briefcase";
			this.setBagWidth(1);
			this.setBagHeight(1);
			this.setBagDepth(1);
			this.maximumNumberOfItems = 10;
		}
	}

	public int getBagWidth() {
		return bagWidth;
	}

	public void setBagWidth(int bagWidth) {
		this.bagWidth = bagWidth;
	}

	public int getBagHeight() {
		return bagHeight;
	}

	public void setBagHeight(int bagHeight) {
		this.bagHeight = bagHeight;
	}

	public int getBagDepth() {
		return bagDepth;
	}

	public void setBagDepth(int bagDepth) {
		this.bagDepth = bagDepth;
	}
	
	public void dropItem(Item item) {
		if(this.currentNumberOfItems != 0) {
			if(this.itemList.contains(item)) {
				Application.currentRoom.addObject(item);
				itemList.remove(item);
				//TODO: grammar check the first letter of the item and make it 'a' or 'an' beforehand
				System.out.println("You place a " + item.toString() + " on the ground.");
			}
		}
		
	}
	
}
