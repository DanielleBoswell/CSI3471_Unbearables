package Cruiselink.maven.cruiselink.src.test.java.unBEARables.maven.cruiselink;



import Cruiselink.maven.cruiselink.src.Controller.ReserveRoomController;
import Cruiselink.maven.cruiselink.src.Domain.*;
import Cruiselink.maven.cruiselink.src.Repository.ReservationDatabase;

import java.util.*;

public class ReserveRoomTester {

    public static void main(String args[]) {
        ReservationDatabase d = new ReservationDatabase();
        Guest g = new Guest();
        Room room1 = new Room(Boolean.TRUE, Room.BedType.FULL, 123, 2, Room.QualityLevel.BUSINESS);
        Room room2 = new Room(Boolean.TRUE, Room.BedType.FULL, 123, 2, Room.QualityLevel.BUSINESS);
        Room room3 = new Room(Boolean.TRUE, Room.BedType.FULL, 123, 2, Room.QualityLevel.BUSINESS);
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        HashMap<Integer, Room> roomHashMap = new HashMap<>();

        for (Room i : roomList) {
            roomHashMap.put(i.getRoomNumber(), i);
        }

        Ship s = new Ship("Baylor Boat", 5, roomHashMap);
        s.path = new TravelPath();
        s.path.setDays(5);


        ReserveRoomController rrc = new ReserveRoomController();
        rrc.reserveRoom(d, g, s, room2);
        rrc.reserveRoom(d, g, s, room1);
        rrc.reserveRoom(d, g, s, room1);

        for (Reservation r : d.reservationMap.get(g)) {
            System.out.println(r.toString());
        }
    }


}