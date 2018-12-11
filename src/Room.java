import java.io.Serializable;

public class Room implements Serializable{
	private int roomNumber = 1;
	private NPC npcList[];
	private String availableExits[];
	
	public Room(int roomNumber) {
		setRoomNumber(roomNumber);
		setAvailableExits(this.getRoomNumber());
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public void setAvailableExits(int roomNumber){
		
		
	}
	
	public void setRoomDescription(int roomNumber) {
		
	}

}
