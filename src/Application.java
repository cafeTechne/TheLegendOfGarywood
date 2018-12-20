import java.io.*;
import java.util.*;

public class Application implements Serializable {

	public static int characterCount = 0;
	private static Scanner keyboard;
	static boolean exitFlag = false;
	public static Character character;
	//I moved the roomMap declaration to global scope so that it could be accessed outside of the scope of start()
	static Map<Integer, Room> roomMap;
	
	public static Room currentRoom;
	
	
	
	public static void main(String[] args) throws IOException {
		
		keyboard = new Scanner(System.in);
		//run game opening animation
		//openingAnimation();
		
		
		//prompt user for newGame or to continue
		//prompt();
		
		//if user chooses new game, run start();
		
		//else load continue();  
		//How to best save and load a saved game?
		
		//for testing, we just begin with start();
		start();
		
		//main game loop
		while(!exitFlag)
	    {
	        input();
	       // update();
	       // render();
	    }
		//TODO: Build out a GameEntity class and figure out a way to create UUIDs for all objects created,
		//there's a lot to unpack with implementing this though
		
		//TODO: structure a basic game loop and create input validation for basic text based commands!

	}

	//TODO: How to modularize input parsing for efficiency?
	public static void input() {
		System.out.println("\nUser, what would you like to do?");
		String input = keyboard.nextLine();
		
		//TODO: logic for "look at goblin", or "look in hole in tree", for example... what is the best approach for this?
		
		if(input.equalsIgnoreCase("look")) {
						
			System.out.println("You are at: " + currentRoom.getRoomTitle());
			
			//TODO: roomDescription needs to be defined in the object
			//System.out.println(currentRoom.getRoomDescription());
			
			//TODO: a list of objects that can be interacted with? ex: System.out.println("Objects on the ground: + currentRoom.getObjectsInTheRoom()");
			System.out.println("Also here: " + currentRoom.getNpcList());
			
			System.out.println("Available exits: " + currentRoom.getExits());
			
		}
		else if(input.equalsIgnoreCase("info")) {
			System.out.println("Your character has the following stats:\n");
			character.displayInfo();
		}
		else if(input.equalsIgnoreCase("help")) {
			System.out.println("The following are valid commands:\n");
			System.out.println("look\ninfo\n");
		}
		else if(input.equalsIgnoreCase("go Wooden Door")) {
			move("Wooden Door");
		}
		//TODO: parsing logic for movement and compound statements
		else {
			System.out.println("That is not a valid command.");
		}
	}

	public static void move(String movementDirection) {
		
		//checks to see if the character can move based on his Orientation state
		if(character.tryToMove()) {

			//checks for direction in currentRoom.getExits();
			System.out.println(currentRoom.getExits());
			ArrayList<String> possibleExits = (ArrayList) currentRoom.getExits();
			if(possibleExits.contains(movementDirection)) {
				System.out.println("Movement successful!");
				System.out.println("You head towards the " + movementDirection + ".");
				System.out.println("Unfortunately, I haven't figured out how to actually make this work with the room object yet...");

				System.out.println("This is the exit room map: ");
				System.out.println(currentRoom.getExitRoomMap());
				
				System.out.println("Does this exit map contain the current room? ");
				System.out.println(currentRoom.getExitRoomMap().containsKey(currentRoom.getRoomID()));
				
				
				//calls the character onMove() method for consequent actions, etc.
				character.onMove();
			}
		}
		else {
			System.out.println("You can not currently move.");
			System.out.println("You are " + character.orientationStatus);
		}
	}
	
	public static void start() throws IOException {
		//build game map
		roomMap = new RoomBuilder().buildRoomLayout();

		System.out.println("Adventurer, what is your name?");
		
		
		//TODO: create method to validate input
		String name = keyboard.nextLine();
		
		//how would we dynamically create variables here according to
		//a database of existing characters?
		//for now, just using a global character counter 
		//and incrementing the name based on the counter?
		
		//or can we assume that each instance of the game will only
		//have one character object per game?
		
		//should the character object be static since it is a first person game right now?
		//why or why not?
		character = new Character(name);

		character.displayInfo();
		
		//playing with Othman's Room object
		currentRoom = new Room();
		currentRoom = roomMap.get(1);

		
		//Need to figure out a way to create a monsterFactory 
		//that will make sense of how monsters should spawn
		//this detail is important IMO, this goblin is a test object just for
		//playing with behaviors and states TODO!

		//TODO: Dynamically add monsters and the treasure they drop into the NPC list and a list of objects in a room 
		Goblin gobsnatch = new Goblin(5, 5, .5, .5, 1, 2, 1, "forest");
		
		System.out.println("Type 'help' (without the quotation marks) for more info on possible commands!");
		
	}
}
