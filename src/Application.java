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
		// TODO: run game opening animation
		// openingAnimation();

		// for testing, we just begin with start();
		start();

		// main game loop
		while (!exitFlag) {
			input();
			// update();
			// render();
		}
		// TODO: Build out a GameEntity class and figure out a way to create UUIDs for
		// all objects created,
		// there's a lot to unpack with implementing this though

	}

//	TODO: Question: Should I place all of the input into its own class?
	//Reason I haven't yet is because as of now Application is mainly just
	//an input class... but as the view gets developed I imagine this will change.
	
	public static void input() throws IOException {
		System.out.println("\nUser, what would you like to do?");
		String input = keyboard.nextLine();

		// TODO: logic for "look at goblin", or "look in hole in tree", for example...
		// what is the best approach for this?

		if (input.equals("") || input.length() <= 1) {
			System.out.println("That is an invalid command.");
		} else if (input.equalsIgnoreCase("look")) {
			lookAtCurrentRoom();
		} else if (input.equalsIgnoreCase("look at") && input.length() == 7) {
			System.out.println("What do you want to look at?");
		} else if (input.equalsIgnoreCase("roll d4")) {
			System.out.println("You roll a 4 sided die and the result is: " + roll("d4"));
		} else if (input.equalsIgnoreCase("roll d6")) {
			System.out.println("You roll a 6 sided die and the result is: " + roll("d6"));
		} else if (input.equalsIgnoreCase("roll d8")) {
			System.out.println("You roll a 8 sided die and the result is: " + roll("d8"));
		} else if (input.equalsIgnoreCase("roll d10")) {
			System.out.println("You roll a 10 sided die and the result is: " + roll("d10"));
		} else if (input.equalsIgnoreCase("roll d12")) {
			System.out.println("You roll a 12 sided die and the result is: " + roll("d12"));
		} else if (input.equalsIgnoreCase("roll d20")) {
			System.out.println("You roll a 20 sided die and the result is: " + roll("d20"));
		} else if (input.equalsIgnoreCase("roll d100")) {
			System.out.println("You roll a 100 sided die and the result is: " + roll("d100"));
		} 

		
		//TODO: This is broken, fix it and extend "look at"
		else if (input.substring(0,6).equalsIgnoreCase("look at") && input.length() > 7) {
			String secondInputString = input.substring(8, input.length());
			lookAt(secondInputString);
		}
		/*
		*/
		//TODO: Write a lookAt function that accesses the DESCRIPTION attribute of an object and
		//prints the output to the console.
		
		//TODO: mirror the 'at' function with an 'in', 'under', etc. w/ correspondingly 
		//appropriate messaging and a system for relational item positioning--a data attribute of 
		//WHAT object? Can this change relationally or am I over-thinking this?
		
		
		else if (input.equalsIgnoreCase("info")) {
			System.out.println("Your character has the following stats:\n");
			character.displayInfo();
		} else if (input.equalsIgnoreCase("sit")) {
			if (character.getOrientationStatus() instanceof Sitting) {
				System.out.println("You are already sitting.");
			} else {
				System.out.println("You sit down.");
				character.setOrientationStatus(new Sitting());
			}

		} else if (input.equalsIgnoreCase("stand")) {
			if (character.getOrientationStatus() instanceof Standing) {
				System.out.println("You are already standing.");
			} else {
				System.out.println("You stand up.");
				character.setOrientationStatus(new Standing());
			}
		} else if (input.equalsIgnoreCase("lie")) {
			if (character.getOrientationStatus() instanceof Supine
					|| character.getOrientationStatus() instanceof Prone) {
				System.out.println("You are already lieing down.");
			} else {
				System.out.println("You lie down into the supine position.");
				character.setOrientationStatus(new Supine());
			}
		} else if (input.equalsIgnoreCase("kneel")) {
			if (character.getOrientationStatus() instanceof Kneeling) {
				System.out.println("You are already kneeling.");
			} else {
				System.out.println("You take a knee and kneel upon the ground.");
				character.setOrientationStatus(new Kneeling());
			}
		} else if (input.equalsIgnoreCase("help")) {
			System.out.println("The following are valid commands:\n");
			System.out.println("look\ninfo\ngo\nsit\nstand\nlie\nkneel\nexit\nsave\n");
		} else if (input.equalsIgnoreCase("exit")) {
			exit();
		} else if (input.equalsIgnoreCase("save")) {
			saveGame();
		} else if ((input.substring(0, 2).equalsIgnoreCase("go") && input.length() == 2)) {
			System.out.println("Where do you want to go?");
		}
		// TODO: Can we improve the generalization of the parsing for the go command
		// here?
		else if (input.substring(0, 2).equalsIgnoreCase("go")) {
			String secondInputString = input.substring(3, input.length());
			move(secondInputString);
		} else if (input.substring(0, 6).equalsIgnoreCase("attack") && input.length() > 6) {
			String secondInputString = input.substring(7, input.length());
			attack(secondInputString);
		} else if (input.substring(0, 3).equalsIgnoreCase("get") && input.length() > 3) {
			String secondInputString = input.substring(4, input.length());
			get(secondInputString);
		} 		
		else {
			System.out.println("That is not a valid command. Type 'help' for a list of commands.");
		}
	}

	public static void move(String movementDirection) {

		// checks to see if the character can move based on his Orientation state
		if (character.tryToMove()) {

			ArrayList<String> possibleExits = (ArrayList<String>) currentRoom.getExits();

			// checks for direction in currentRoom.getExits();
			if (possibleExits.contains(movementDirection)) {

				// TODO: sanitize input to ignore case sensitivity
				// this post suggests using a TreeMap (Source:
				// https://stackoverflow.com/questions/11929542/how-to-ignore-the-case-sensitive-when-we-look-for-a-key-in-the-map
				// )
				if (currentRoom.getExitRoomMap().containsKey(movementDirection)) {

					currentRoom = roomMap.get(currentRoom.getExitRoomMap().get(movementDirection).getRoomID());
					System.out.println("\nYou head towards the " + movementDirection + ".\n");
					lookAtCurrentRoom();
				}

				// TODO: calls the character onMove() method for consequent actions, etc. call
				// the render() loop from this?
				character.onMove();
			} else {
				System.out.println(movementDirection + " is an invalid option.");
				System.out.println("Available exits: " + currentRoom.getExits());
			}
		} else {
			System.out.println("\nYou can not currently move.");
			System.out.println("You are " + character.orientationStatus);
		}
	}

	//TODO: Complete this method once you figure out how to store an object's description,
	//will this require SQL or a JSON database with object descriptions? If so, should I write
	//a tool to make databasing this easy?
	public static void lookAt(String objectToLookAt) {
		
		
	}
	
	public static boolean findNPC(String NPCtoBeFound) {
		List<NPC> possibleTargets = currentRoom.getNpcList();
		
		for (NPC target : possibleTargets) {
			if (target.getName().matches(NPCtoBeFound)) {
				return true;
			}
		}
		return false;
	}

	public static Item findObject(String ObjectToFind) {
		List<Item> possibleItems = currentRoom.getObjectList();
		
		for (Item targetItem : possibleItems) {
			if (targetItem.getItemName().matches(ObjectToFind)) {
				return targetItem;
			}
		}
		return null;
	}
	
	//TODO: I started rewriting this to apply a general logic using findObject, to
	//eliminate code reuse for finding descriptions using 'look at'--FINISH THIS!
	//then, TODO: apply the above technique to the attack() method using the findNPC logic
	
	public static void get(String getTarget) {
		List<Item> possibleGetTargets = currentRoom.getObjectList();
		boolean itemFound = false;
		Item foundItem = null;
		
		for (Item getItemTarget : possibleGetTargets) {
			if (getItemTarget.getItemName().matches(getTarget)) {
				itemFound = true;
				foundItem = getItemTarget;
			}
		}
		
		if (findObject(getTarget) != null) {
			character.getInventory().getItem(foundItem);
			itemFound = false;
		} else {
			System.out.println(getTarget + " is an invalid selection.");
			System.out.println("possible items lying nearby are: " + possibleGetTargets);
		} 
}

	public static void attack(String attackTarget) {

		// checks to see if the character can move based on his Orientation state
		if (character.tryToMove()) {

			List<NPC> possibleTargets = currentRoom.getNpcList();
			boolean targetFound = false;

			for (NPC target : possibleTargets) {
				if (target.getName().matches(attackTarget)) {
					targetFound = true;
				}
			}
			if (targetFound == true) {
				// TODO: implement attack logic...THOUGHTS: to-hit? armor score?
				System.out.println("You attack a " + attackTarget + ".");
				targetFound = false;
			} else {
				System.out.println(attackTarget + " is an invalid attack target.");
				System.out.println("possible targets are: " + possibleTargets);
			}
		} else {
			System.out.println("\nYou can not currently attack.");
			System.out.println("You are " + character.orientationStatus);
		}
	}

	public static void newGame() {
		// build game map
		roomMap = new RoomBuilder().buildRoomLayout();

		System.out.println("Adventurer, what is your name?");

		// clears the end of line character from the previous nextInt() call
		keyboard.nextLine();
		String name = keyboard.nextLine();
		// TODO: create method to validate input when creating a name

		// how would we dynamically create variables here according to
		// a database of existing characters?

		character = new Character(name);

		character.displayInfo();

		currentRoom = new Room();
		currentRoom = roomMap.get(1);

		// Need to figure out a way to create a monsterFactory
		// that will make sense of how monsters should spawn
		// or... should there be only a finite number of monsters in this world? Because
		// grinding is boring.
		// this detail is important IMO, this goblin is a test object just for
		// playing with behaviors and states TODO!

		// TODO: Dynamically add monsters and the treasure they drop into the NPC list
		// and a list of objects in a room
		// TODO: Figure out a way for these objects to be persistent by either writing
		// to the JSON file or serializing them.
		Goblin gobsnatch = new Goblin(5, 5, .5, .5, 1, 2, 1, 0, 0, 0, "forest", "Crazed Goblin", "The goblin doesn't look happy.");

		System.out.println("Type 'help' (without the quotation marks) for more info on possible commands!");

	}

	public static void start() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("User, would you like to start a new game or continue?");
		System.out.println("Press 1 for a New Game");
		System.out.println("Press 2 to Continue");
		int choice = keyboard.nextInt();
		// TODO: validation loop versus just exiting
		if (choice == 1) {
			newGame();
		} else if (choice == 2) {
			loadGame();
		} else {
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

	public static void exit() throws IOException {
		// Gives user the option to save data?
		System.out.println("User, would you like to save before exiting?");
		
		String input = keyboard.nextLine();
 
		if (input.equalsIgnoreCase("yes")){
			saveGame();
		}
		System.exit(0);
	}

	static File fileName = new File("saveData");

	public static void saveGame() throws IOException {

		// TODO: need to set the data before writing to a file

		Character characterSave = character;
		Map<Integer, Room> roomMapSave = roomMap;
		Room currentRoomSave = currentRoom;

		// store these references in an array of Objects
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
		// what is this error about safety eclipse is giving me all about?
		roomMap = (Map<Integer, Room>) savedObjectsArray[1];
		currentRoom = (Room) savedObjectsArray[2];

		// how do we make use of this application object now?

		in.close();
		fileIn.close();

	}


	public static int roll(String diceIdentifier) {
		Random randomNumber = new Random();
		int d4 = randomNumber.nextInt(4) + 1;
		int d6 = randomNumber.nextInt(6) + 1;
		int d8 = randomNumber.nextInt(8) + 1;
		int d10 = randomNumber.nextInt(10) + 1;
		int d12 = randomNumber.nextInt(12) + 1;
		int d20 = randomNumber.nextInt(20) + 1;
		int d100 = randomNumber.nextInt(100) + 1;
		
		if(diceIdentifier == "d4") {
			return d4;
		}
		if(diceIdentifier == "d6") {
			return d6;
		}
		if(diceIdentifier == "d8") {
			return d8;
		}
		if(diceIdentifier == "d10") {
			return d10;
		}
		if(diceIdentifier == "d12") {
			return d12;
		}
		if(diceIdentifier == "d20") {
			return d20;
		}
		if(diceIdentifier == "d100") {
			return d100;
		}	
		return 0;
	}
	
	
	
}
