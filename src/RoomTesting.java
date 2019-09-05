
import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class RoomTesting implements Serializable {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
        	//need to find a way to dynamically read available exits from surrounding rooms
        	//considering a few different design solutions
        	File file = new File("room.yaml");
            Room room = mapper.readValue(file, Room.class);
            System.out.println(ReflectionToStringBuilder.toString(room,ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}