import java.util.ArrayList;

public class Profession {
	
	private ArrayList<Ability> abilityList = new ArrayList<Ability>();

	public ArrayList<Ability> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(ArrayList<Ability> abilityList) {
		this.abilityList = abilityList;
	}
	
	public void addAbility(Ability abilityObject) {
		abilityList.add(abilityObject);
	}
	
}
