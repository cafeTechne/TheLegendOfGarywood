import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Room implements Serializable{

    private int roomID;
	private String roomTitle;
	private String roomDescription;
    private List<String> exits;
    private Map<String, Room> exitRoomMap;
    private List<NPC> npcList;
    private List<Object> objectList;

    public int getRoomID() { return roomID; }

    public void setRoomID(int roomID) { this.roomID = roomID; }

    public String getRoomTitle() { return roomTitle; }

    public void setRoomTitle(String roomTitle) { this.roomTitle = roomTitle; }
    
    public String getRoomDescription() { return roomDescription; }

    public void setRoomDescription(String roomDescription) { this.roomDescription = roomDescription; }

    public Map<String, Room> getExitRoomMap() { return exitRoomMap; }

    public void setExitRoomMap(Map<String, Room> exitRoomMap) { this.exitRoomMap = exitRoomMap; }

    public List<String> getExits() { return exits; }

    public void setExits(List<String> exits) { this.exits = exits; }

    public List<NPC> getNpcList() { return npcList; }

    public void setObjectList(List<Object> objectList) { this.objectList = objectList; }

    public List<Object> getObjectList() { return objectList; }

    public void setNpcList(List<NPC> npcList) { this.npcList = npcList; }
    
    public void addNpc(NPC npc) {this.npcList.add(npc);}
    
    public void removeNpc(NPC npc) {this.npcList.remove(npc);}


}