import com.google.gson.*;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.io.Reader;



public class LocationManager implements Serializable{
	
	
	Gson gson = new Gson();
	
	//need to load an array of room objects from json
	//then, by convention, have them correspond to the index of the object
	
	public LocationManager() throws FileNotFoundException{
		//then set availableExits
		File file = new File("rooms.json");
		FileReader newFileReader = new FileReader(file);	
		RoomList roomList = gson.fromJson(newFileReader, RoomList.class);
	}
	
	
	
	
	
	

}
