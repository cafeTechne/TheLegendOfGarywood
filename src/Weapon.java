
public class Weapon extends Item {

	private int pierce = 1;
	private int slash = 1;
	private int bash = 1;
	private boolean flammable = false;
	private boolean magical = false;
	private boolean silver = false;
	private boolean wooden = false;

	public Weapon(int maxDurability, int currDurability,int length, int width, int height, int weight, 
			int pierce, int slash, int bash, boolean flammable, boolean silver, boolean magical, boolean wooden) {
		super(maxDurability, currDurability, length, width, height, weight);
		this.setPierce(pierce);
		this.setSlash(slash);
		this.setBash(bash);
		this.flammable = flammable;
		this.magical = magical;
		this.silver = silver;
		this.wooden = wooden;
	}

	public boolean isFlammable() {
		return flammable;
	}

	public void setFlammable(boolean flammable) {
		this.flammable = flammable;
	}

	public boolean isMagical() {
		return magical;
	}

	public void setMagical(boolean magical) {
		this.magical = magical;
	}

	public boolean isSilver() {
		return silver;
	}

	public void setSilver(boolean silver) {
		this.silver = silver;
	}

	public boolean isWooden() {
		return wooden;
	}

	public void setWooden(boolean wooden) {
		this.wooden = wooden;
	}

	public int getPierce() {
		return pierce;
	}

	public void setPierce(int pierce) {
		this.pierce = pierce;
	}

	public int getSlash() {
		return slash;
	}

	public void setSlash(int slash) {
		this.slash = slash;
	}

	public int getBash() {
		return bash;
	}

	public void setBash(int bash) {
		this.bash = bash;
	}
	
	

	
}
