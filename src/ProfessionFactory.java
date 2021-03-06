import java.io.Serializable;

public class ProfessionFactory implements Serializable {
	
	public Profession chooseProfession(Integer newProfessionType){

		Profession newProfession = null;
	
	    if (newProfessionType.equals(1)){
	        return new Accountant();
	    } else
	    if (newProfessionType.equals(2)){
	        return new Janitor();
	    } else
	    if (newProfessionType.equals(3)){
	        return new Artist();
	    } else 
    	if (newProfessionType.equals(4)){
	        return new Programmer();
	    }
	    return null;
	}

}
