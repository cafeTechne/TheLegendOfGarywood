import java.io.Serializable;

public class Armor extends Item implements Serializable{

	private boolean cloth = false;
	private boolean leather = false;
	private boolean scale = false;
	private boolean chain = false;
	private boolean brigandine = false;
	private boolean plate = false;
	
	private boolean magical = false;
	private int heatResistance = 0;
	private int coldResistance = 0;
	private int magicResistance = 0;
	private int holyResistance = 0;
	private int unholyResistance = 0;
	
	public Armor(int maxDurability, int currDurability, int length, int width, 
			     int height, int weight, boolean cloth, boolean leather, boolean scale, 
			     boolean chain, boolean brigandine, boolean plate, boolean magical, 
			     int heatResistance, int coldResistance, int magicResistance, 
			     int holyResistance, int unholyResistance, String itemName) {
		super(maxDurability, currDurability, length, width, height, unholyResistance, itemName);
		this.cloth =cloth;
		this.leather = leather;
		this.scale = scale;
		this.chain = chain;
		this.brigandine = brigandine;
		this.plate = plate;
		this.magical = magical;
		this.heatResistance = heatResistance;
		this.coldResistance = coldResistance;
		this.magicResistance = magicResistance;
		this.holyResistance = holyResistance;
		this.unholyResistance = unholyResistance;
	}

	public boolean isCloth() {
		return cloth;
	}

	public void setCloth(boolean cloth) {
		this.cloth = cloth;
	}

	public boolean isLeather() {
		return leather;
	}

	public void setLeather(boolean leather) {
		this.leather = leather;
	}

	public boolean isScale() {
		return scale;
	}

	public void setScale(boolean scale) {
		this.scale = scale;
	}

	public boolean isChain() {
		return chain;
	}

	public void setChain(boolean chain) {
		this.chain = chain;
	}

	public boolean isBrigandine() {
		return brigandine;
	}

	public void setBrigandine(boolean brigandine) {
		this.brigandine = brigandine;
	}

	public boolean isPlate() {
		return plate;
	}

	public void setPlate(boolean plate) {
		this.plate = plate;
	}

	public boolean isMagical() {
		return magical;
	}

	public void setMagical(boolean magical) {
		this.magical = magical;
	}

	public int getColdResistance() {
		return coldResistance;
	}

	public void setColdResistance(int coldResistance) {
		this.coldResistance = coldResistance;
	}

	public int getHeatResistance() {
		return heatResistance;
	}

	public void setHeatResistance(int heatResistance) {
		this.heatResistance = heatResistance;
	}

	public int getHolyResistance() {
		return holyResistance;
	}

	public void setHolyResistance(int holyResistance) {
		this.holyResistance = holyResistance;
	}

	public int getMagicResistance() {
		return magicResistance;
	}

	public void setMagicResistance(int magicResistance) {
		this.magicResistance = magicResistance;
	}

	public int getUnholyResistance() {
		return unholyResistance;
	}

	public void setUnholyResistance(int unholyResistance) {
		this.unholyResistance = unholyResistance;
	}

}
