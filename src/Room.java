
import java.util.Map;

public class Room {
    
	private String roomTitle;
    private int roomNumber;
    //roomList is currently null, considering putting all of this info in one file
    //unsure how to call it and use it most efficiently
    private Map<String, String> roomList;
    private String[] exits;
    private String[] npcList;
    
    
    public Map<String, String> getAddress() {
        return roomList;
    }
    
    public void setAddress(Map<String, String> roomList) {
        this.roomList = roomList;
    }
    
    
    public String[] getNpcList() {
    	return npcList;
    }
    public void setNpcList(String[] npcList) {
    	this.npcList = npcList;
    }
    
    public String[] getExits() {
        return exits;
    }
    public void setExits(String[] exits) {
        this.exits = exits;
    }
	public String getRoomTitle() {
		return roomTitle;
	}
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}