import java.io.Serializable;
import java.util.ArrayList;

public class Profession implements Serializable {
	
	private ArrayList<AbilityInterface> abilityList = new ArrayList<AbilityInterface>();

	public ArrayList<AbilityInterface> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(ArrayList<AbilityInterface> abilityList) {
		this.abilityList = abilityList;
	}
	
	public void addAbility(AbilityInterface abilityObject) {
		abilityList.add(abilityObject);
	}
	
}
