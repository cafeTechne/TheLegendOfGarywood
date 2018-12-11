import com.google.gson.*;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;



public class RoomList {

	Gson gson = new Gson();
	
	private Room roomList[]; 
	
	public RoomList() throws IOException, FileNotFoundException {
		File file = new File("rooms.json");
		FileReader newFileReader = new FileReader(file);	
		RoomList roomList = gson.fromJson(newFileReader, RoomList.class);
	}
	
}
