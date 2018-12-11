import java.io.Serializable;

public class Item implements Serializable {
	
	private int maximumDurability = 100;
	private int currentDurability = 100;
	private int length = 1;
	private int width = 1;
	private int height = 1;
	private int weight = 1;
	
	public Item(int maxDurability, int currDurability, int length, int width, int height, int weight) {
		this.setMaximumDurability(maxDurability);
		this.setCurrentDurability(currDurability);
		this.setLength(length);
		this.setWidth(width);
		this.setHeight(height);
		this.setWeight(weight);
	}

	public int getMaximumDurability() {
		return maximumDurability;
	}

	public void setMaximumDurability(int maximumDurability) {
		this.maximumDurability = maximumDurability;
	}

	public int getCurrentDurability() {
		return currentDurability;
	}

	public void setCurrentDurability(int currentDurability) {
		this.currentDurability = currentDurability;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	

}
