package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.test.java.com.csi3471.unbearables.maven.cruiselink;

import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.ReservationDatabase;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.Room;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.Ship;
import person.Guest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReserveRoomTester {

    public static void main(String args[])
    {
        ReservationDatabase d = new ReservationDatabase();
        Guest g = new Guest();
        Room room1 = new Room(Boolean.TRUE, "Queen", 123, 2);
        Room room2 = new Room(Boolean.FALSE, "King", 124, 1);
        Room room3 = new Room(Boolean.TRUE, "Twin", 125, 2);
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        HashMap<Integer,Room> roomHashMap = new HashMap<>();

        for(Room i : roomList){
            roomHashMap.put(i.getRoomNumber(),i);
        }

        Ship s = new Ship("Baylor Boat",5,roomHashMap);
    }


}
