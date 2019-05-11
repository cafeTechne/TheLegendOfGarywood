import java.io.*;
import java.util.*;

public class Application implements Serializable {

	public static int characterCount = 0;
	private static transient Scanner keyboard;
	static boolean exitFlag = false;
	public static Character character;
	public static Map<Integer, Room> roomMap;
	public static Room currentRoom;
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		keyboard = new Scanner(System.in);
		//TODO: run game opening animation
		//openingAnimation();
		
		
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

	}

	
	//TODO: How to modularize input parsing for efficiency?
	public static void input() throws IOException {
		System.out.println("\nUser, what would you like to do?");
		String input = keyboard.nextLine();
		
		//TODO: logic for "look at goblin", or "look in hole in tree", for example... what is the best approach for this?
		
		if(input.equals("") || input.length() <=1) {
			System.out.println("That is an invalid command.");
		}
		else if(input.equalsIgnoreCase("look")) {
			lookAtCurrentRoom();		
		}
		else if(input.equalsIgnoreCase("info")) {
			System.out.println("Your character has the following stats:\n");
			character.displayInfo();
		}
		else if(input.equalsIgnoreCase("sit")) {
			if(character.getOrientationStatus() instanceof Sitting) {
				System.out.println("You are already sitting.");
			}
			else {
				System.out.println("You sit down.");
				character.setOrientationStatus(new Sitting());	
			}
			
		}
		else if(input.equalsIgnoreCase("stand")) {
			if(character.getOrientationStatus() instanceof Standing) {
				System.out.println("You are already standing.");
			}
			else {
				System.out.println("You stand up.");
				character.setOrientationStatus(new Standing());	
			}
		}
		else if(input.equalsIgnoreCase("lie")) {
			if(character.getOrientationStatus() instanceof Supine || character.getOrientationStatus() instanceof Prone ) {
				System.out.println("You are already lieing down.");
			}
			else {
				System.out.println("You lie down into the supine position.");
				character.setOrientationStatus(new Supine());	
			}
		}
		else if(input.equalsIgnoreCase("kneel")) {
			if(character.getOrientationStatus() instanceof Kneeling ) {
				System.out.println("You are already kneeling.");
			}
			else {
				System.out.println("You take a knee and kneel upon the ground.");
				character.setOrientationStatus(new Kneeling());	
			}
		}
		else if(input.equalsIgnoreCase("help")) {
			System.out.println("The following are valid commands:\n");
			System.out.println("look\ninfo\ngo\nsit\nstand\nlie\nkneel\nexit\nsave\n");
		}
		else if(input.equalsIgnoreCase("exit")) {
			exit();
		}
		else if(input.equalsIgnoreCase("save")) {
			saveGame();
		}
		else if((input.substring(0, 2).equalsIgnoreCase("go") && input.length() == 2)) {
			System.out.println("Where do you want to go?");
		}
		//TODO: Can we improve the generalization of the parsing for the go command here?
		else if(input.substring(0, 2).equalsIgnoreCase("go")) {
			String secondInputString = input.substring(3, input.length());
			move(secondInputString);
		}
		else if(input.substring(0, 6).equalsIgnoreCase("attack") && input.length() > 6){
			String secondInputString = input.substring(7, input.length());
			
				attack(secondInputString);
			
		}else {
			System.out.println("That is not a valid command. Type 'help' for a list of commands.");
		}
	}

	public static void move(String movementDirection) {
		
		//checks to see if the character can move based on his Orientation state
		if(character.tryToMove()) {
			
			
			ArrayList<String> possibleExits = (ArrayList) currentRoom.getExits();
			
			//checks for direction in currentRoom.getExits();
			if(possibleExits.contains(movementDirection)) {
				
				
				//TODO: sanitize input to ignore case sensitivity
				//this post suggests using a TreeMap (Source: https://stackoverflow.com/questions/11929542/how-to-ignore-the-case-sensitive-when-we-look-for-a-key-in-the-map )
				if(currentRoom.getExitRoomMap().containsKey(movementDirection)) {
				
					currentRoom = roomMap.get(currentRoom.getExitRoomMap().get(movementDirection).getRoomID());
					System.out.println("\nYou head towards the " + movementDirection + ".\n");
					lookAtCurrentRoom();		
				}
				
				//TODO: calls the character onMove() method for consequent actions, etc. call the render() loop from this?
				character.onMove();
			}
			else {
				System.out.println(movementDirection + " is an invalid option.");
				System.out.println("Available exits: " + currentRoom.getExits());
			}
		}
		else {
			System.out.println("\nYou can not currently move.");
			System.out.println("You are " + character.orientationStatus);
		}
	}
	
public static void attack(String attackTarget) {
		
		//checks to see if the character can move based on his Orientation state
		if(character.tryToMove()) {
			
			
			ArrayList<String> possibleTargets = (ArrayList) currentRoom.getNpcList();
			
			//TODO: This IF statement is not resolving to true when it should be, why not?
			if(possibleTargets.contains(attackTarget)) {
				
				
				//TODO: implement attack logic
				System.out.println("You attack " + attackTarget + ".");
			}
			else {
				System.out.println(attackTarget + " is an invalid attack target.");
				System.out.println("possible targets are: " + possibleTargets);
			}
		}
		else {
			System.out.println("\nYou can not currently attack.");
			System.out.println("You are " + character.orientationStatus);
		}
	}
	
	
	
	public static void newGame() {
		//build game map
		roomMap = new RoomBuilder().buildRoomLayout();

		System.out.println("Adventurer, what is your name?");
		
		//clears the end of line character from the previous nextInt() call
		keyboard.nextLine();
		String name = keyboard.nextLine();
		//TODO: create method to validate input when creating a name
		
		
		//how would we dynamically create variables here according to
		//a database of existing characters?
		
		character = new Character(name);
		
		character.displayInfo();
		
		currentRoom = new Room();
		currentRoom = roomMap.get(1);

		
		//Need to figure out a way to create a monsterFactory 
		//that will make sense of how monsters should spawn
		//or... should there be only a finite number of monsters in this world? Because grinding is boring.
		//this detail is important IMO, this goblin is a test object just for
		//playing with behaviors and states TODO!

		//TODO: Dynamically add monsters and the treasure they drop into the NPC list and a list of objects in a room
		//TODO: Figure out a way for these objects to be persistent by either writing to the JSON file or serializing them.
		Goblin gobsnatch = new Goblin(5, 5, .5, .5, 1, 2, 1, "forest");
		
		System.out.println("Type 'help' (without the quotation marks) for more info on possible commands!");
		
	}
	
	
	public static void start() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("User, would you like to start a new game or continue?");
		System.out.println("Press 1 for a New Game");
		System.out.println("Press 2 to Continue");
		int choice = keyboard.nextInt();
		//TODO: validation loop versus just exiting
		if(choice == 1) {
			newGame();
		}
		else if(choice == 2) {
			loadGame();
		}
		else {
			System.out.println("Neither of those choices is valid. Exiting");
			System.exit(0);
		}
	}
	
	public static void lookAtCurrentRoom() {
		System.out.println("You are at: " + currentRoom.getRoomTitle());
		
		System.out.println("Description: " + currentRoom.getRoomDescription());
		
		System.out.println("Objects here: " + currentRoom.getObjectList());
		
		System.out.println("Also here: " + currentRoom.getNpcList());
		
		System.out.println("Obvious exits: " + currentRoom.getExits());
	}
	
	public static void exit() {
		//Gives user the option to save data?
		System.out.println("User, would you like to save before exiting?");
		keyboard.nextLine();
		
		System.exit(0);
	}

	 static File fileName = new File("saveData");
	 
	 
	 public static void saveGame() throws IOException {
		    
		    //TODO: need to set the data before writing to a file
		    
		    Character characterSave = character;
			Map<Integer, Room> roomMapSave = roomMap;
			Room currentRoomSave =currentRoom;
			
			//store these references in an array of Objects
			Object[] savedObjectsArray = new Object[3];
			
			savedObjectsArray[0] = characterSave;
			savedObjectsArray[1] = roomMapSave;
			savedObjectsArray[2] = currentRoomSave;
					
			
		    FileOutputStream fileOut = new FileOutputStream(fileName);
		    ObjectOutputStream out = new ObjectOutputStream(fileOut);
		    
		    out.writeObject(savedObjectsArray);
		    
		    out.close();
		}

		public static void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException {

		    character = null;
		    roomMap = null;
			currentRoom = null;
			
		    FileInputStream fileIn = new FileInputStream(fileName);
		    ObjectInputStream in = new ObjectInputStream(fileIn);

		    Object[] savedObjectsArray = new Object[3];
		    
		    savedObjectsArray = (Object[]) in.readObject();
		    
		    character = (Character) savedObjectsArray[0];
		    //what is this error about safety eclipse is giving me all about?
			roomMap = (Map<Integer, Room>) savedObjectsArray[1];
			currentRoom = (Room) savedObjectsArray[2];

		    //how do we make use of this application object now?

		    in.close();
		    fileIn.close();

		}
	
	
}
