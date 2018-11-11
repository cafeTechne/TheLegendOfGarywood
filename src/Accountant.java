

public class Accountant extends Profession{

	public Accountant() {
		//add abilities on creation
		super.addAbility(new Calculate());
	}
	
	
	public String toString() {
		return "Accountant";
	}
}
