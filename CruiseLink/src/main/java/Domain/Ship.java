package Domain;

/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: Ship.java
 * Creation Date: 10/16/2023
 * Modified Date: 10/16/2023
 * Description: Contains the name of ship, the ships capacity,
 * and count of each room type
 *
 * Modified by Spencer Hammack on 10/21/23:
 *  -   added room hash map to implement ReserveRoom use case
 *  -   added ship constructor method
 */


import java.util.HashMap;
import java.util.Map;

public class Ship {

    //Attributes
    String name;
    int capacity;
    int twinRooms;
    int fullRooms;
    int queenRooms;
    int kingRooms;

    //added by Spencer Hammack
    public Map<Integer,Room> roomMap;
    public TravelPath path;

    //constructors added by Spencer Hammack
    public Ship(){
        name = "";
        capacity = -1;
        roomMap = new HashMap<>();
        path = new TravelPath();
    }
    public Ship(String name, int capacity, Map<Integer,Room> rooms){
        this.name = name;
        this.capacity = capacity;
        roomMap = rooms;
    }




    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTwinRooms() {
        return twinRooms;
    }

    public void setTwinRooms(int twinRooms) {
        this.twinRooms = twinRooms;
    }

    public int getFullRooms() {
        return fullRooms;
    }

    public void setFullRooms(int fullRooms) {
        this.fullRooms = fullRooms;
    }

    public int getQueenRooms() {
        return queenRooms;
    }

    public void setQueenRooms(int queenRooms) {
        this.queenRooms = queenRooms;
    }

    public int getKingRooms() {
        return kingRooms;
    }

    public void setKingRooms(int kingRooms) {
        this.kingRooms = kingRooms;
    }
}