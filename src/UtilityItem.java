
public class UtilityItem extends Item{

	private boolean climbingItem = false;
	private boolean swimmingItem = false;
	private boolean caveItem = false;
	private boolean healingItem = false;
	private boolean poisonItem = false;
	private boolean giftItem = false;
	private boolean buildingItem = false;
	private boolean thieveryItem = false;
	private boolean hidingItem = false;
	private boolean teleportItem = false;
	private boolean wandItem = false;
	private boolean magicRingItem = false;
	
	public UtilityItem(int maxDurability, int currDurability, int length, int width, int height,
			           int weight, boolean climbingItem, boolean swimmingItem, boolean caveItem,
			           boolean healingItem, boolean giftItem, boolean poisonItem, boolean buildingItem, 
			           boolean thieveryItem, boolean hidingItem, boolean teleportItem, boolean wandItem, 
			           boolean magicRingItem) {
		super(maxDurability, currDurability, length, width, height, weight);
		this.climbingItem = climbingItem;
		this.swimmingItem = swimmingItem;
		this.caveItem = caveItem;
		this.healingItem = healingItem;
		this.poisonItem = poisonItem;
		this.giftItem = giftItem;
		this.buildingItem = buildingItem;
		this.thieveryItem = thieveryItem;
		this.hidingItem = hidingItem;
		this.teleportItem = teleportItem;
		this.wandItem = wandItem;
		this.magicRingItem = magicRingItem;
	}

	public boolean isClimbingItem() {
		return climbingItem;
	}

	public void setClimbingItem(boolean climbingItem) {
		this.climbingItem = climbingItem;
	}

	public boolean isSwimmingItem() {
		return swimmingItem;
	}

	public void setSwimmingItem(boolean swimmingItem) {
		this.swimmingItem = swimmingItem;
	}

	public boolean isCaveItem() {
		return caveItem;
	}

	public void setCaveItem(boolean caveItem) {
		this.caveItem = caveItem;
	}

	public boolean isHealingItem() {
		return healingItem;
	}

	public void setHealingItem(boolean healingItem) {
		this.healingItem = healingItem;
	}

	public boolean isPoisonItem() {
		return poisonItem;
	}

	public void setPoisonItem(boolean poisonItem) {
		this.poisonItem = poisonItem;
	}

	public boolean isGiftItem() {
		return giftItem;
	}

	public void setGiftItem(boolean giftItem) {
		this.giftItem = giftItem;
	}

	public boolean isBuildingItem() {
		return buildingItem;
	}

	public void setBuildingItem(boolean buildingItem) {
		this.buildingItem = buildingItem;
	}

	public boolean isThieveryItem() {
		return thieveryItem;
	}

	public void setThieveryItem(boolean thieveryItem) {
		this.thieveryItem = thieveryItem;
	}

	public boolean isHidingItem() {
		return hidingItem;
	}

	public void setHidingItem(boolean hidingItem) {
		this.hidingItem = hidingItem;
	}

	public boolean isTeleportItem() {
		return teleportItem;
	}

	public void setTeleportItem(boolean teleportItem) {
		this.teleportItem = teleportItem;
	}

	public boolean isWandItem() {
		return wandItem;
	}

	public void setWandItem(boolean wandItem) {
		this.wandItem = wandItem;
	}

	public boolean isMagicRingItem() {
		return magicRingItem;
	}

	public void setMagicRingItem(boolean magicRingItem) {
		this.magicRingItem = magicRingItem;
	}

	
}
