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
		//How to best save and load a saved game?
		
		
		//for testing, we just begin with start();
		start();
		
		//TODO: Build out a GameEntity class and figure out a way to create UUIDs for all objects created,
		//there's a lot to unpack with implementing this though
		
		//TODO: structure a basic game loop and create input validation for basic text based commands!

	}

	public static void start() throws IOException {
		System.out.println("Adventurer, what is your name?");
		keyboard = new Scanner(System.in);
		
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
		Character character = new Character(name);
		
		character.displayInfo();
		
		
		//Need to figure out a way to create a monsterFactory 
		//that will make sense of how monsters should spawn
		//this detail is important IMO, this goblin is a test object just for
		//playing with behaviors and states TODO!
		Goblin gobsnatch = new Goblin(5, 5, .5, .5, 1, 2, 1, "forest");
		

		
	}
}
