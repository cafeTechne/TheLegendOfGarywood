
public class Character {

	private int intelligence = 1;
	private int strength = 1; 
	private int dexterity = 1;
	private String name;
	
	public Character(String name) {
		this.setIntelligence((int) (25 + ((Math.random()*25) +1)));
		this.setStrength((int) (25 + ((Math.random()*50) +1)));
		this.setDexterity((int) (25 + ((Math.random()*50) +1)));
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	
	
}
