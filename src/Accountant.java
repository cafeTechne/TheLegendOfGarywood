import java.io.Serializable;

public class Accountant extends Profession implements Serializable{

	public Accountant() {
		//add abilities on creation
		super.addAbility(new Calculate());
	}
	
	
	public String toString() {
		return "Accountant";
	}
}
