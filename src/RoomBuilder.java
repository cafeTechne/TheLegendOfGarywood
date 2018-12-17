import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RoomBuilder {

    private static final String ROOM_DIRECTORY = "rooms/";
    private static final String ROOM_JSON_FILE = "rooms.json";
    private static final String LAYOUT_FILE = "layout.txt";

    //take room objects and use layout.txt to build the layout of the rooms
    public Map<Integer, Room> buildRoomLayout() {
        Map<Integer, Room> roomMap = buildRoomsFromFile();

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(ROOM_DIRECTORY + LAYOUT_FILE));

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String line: lines) {
            String first = line.substring(0, line.indexOf(' '));
            String second = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
            String third = line.substring(line.lastIndexOf(' ') + 1, line.length());

            Room curr = roomMap.get(Integer.parseInt(first));
            String exit = second;
            Room cnctng = roomMap.get(Integer.parseInt(third));

            if (curr.getExitRoomMap() == null) {
                curr.setExitRoomMap(new HashMap<>());
            }

            curr.getExitRoomMap().put(exit, cnctng);
        }

        return roomMap;
    }


    //build room objects from rooms.json and build map from roomID to room objects for quick access
    private Map<Integer, Room> buildRoomsFromFile() {
        Map<Integer, Room> roomMap = new HashMap<>();
        try {
            JsonReader reader = new JsonReader(new FileReader(ROOM_DIRECTORY + ROOM_JSON_FILE));
            JsonObject jsonObject = new Gson().fromJson(reader, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("Rooms");
            Room[] roomsArr = new Gson().fromJson(jsonArray, Room[].class);
            List<Room> rooms = Arrays.asList(roomsArr);
            for (Room room : rooms) {
                roomMap.put(room.getRoomID(), room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomMap;
    }
}
