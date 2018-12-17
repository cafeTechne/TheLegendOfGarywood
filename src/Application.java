import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Application implements Serializable {

	public static int characterCount = 0;
	private static Scanner keyboard;
	
	public static void main(String[] args) throws IOException {
		//run game opening animation
		//openingAnimation();
		
		//prompt user for newGame or to continue
		//prompt();
		
		//if user chooses new game, run start();
		
		//else load continue();  
		//How to save and load a saved game?
		
		
		//for testing, we just begin with start();
		start();

	}


	public static void start() throws IOException {
		//build game map
		Map<Integer, Room> roomMap = new RoomBuilder().buildRoomLayout();

		System.out.println("Adventurer, what is your name?");
		keyboard = new Scanner(System.in);
		
		//create method to validate input
		String name = keyboard.nextLine();
		
		//how would we dynamically create variables here according to
		//a database of existing characters?
		//for now, just using a global character counter 
		//and incrementing the name based on the counter?
		
		//or can we assume that each instance of the game will only
		//have one character object per game?
		Character character = new Character(name);

		character.displayInfo();
		
		
		
	}
}
