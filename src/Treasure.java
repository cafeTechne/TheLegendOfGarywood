
public class Treasure{

	
	//treasure has items
	Item loot;
	
	public Treasure() {
		//generate random treasure
	};

	/**
	 * generate treasure based on the level of difficulty of the monster && the region they are in
	 * @param monsterLevel An integer of the monsters level.
	 * @param region A region that the monster is in, example: Black Mushrooms are only found on Gremlins that live in caves, etc.
	 */
	public Treasure(int monsterLevel, String region) {
		
		if(region =="desert") {
			//list based on the desert, etc.
			//use RNG and loot tables defined in JSON?
			//what is the best way to set this up for maintainability
			//by non-technically oriented designers?
		}
		if(region =="beach") {
			//list based on the desert, etc.
		}
		if(region =="mountains") {
			//list based on the desert, etc.
		}
		if(region =="ocean") {
			//list based on the desert, etc.
		}
		if(region =="forest") {
			//list based on the desert, etc.
		}
		if(region =="jungle") {
			//list based on the desert, etc.
		}
		if(region =="cave") {
			//list based on the desert, etc.
		}

	}
	
}
