import java.util.Objects;

public class Room {
    private boolean isSmoking;
    private String bedType;
    private int roomNumber;
    private int numBeds;

    // FIX ME: Add qualityLevel - enum
    // set maxBeds = 3
    // change bedType to enum

    public Room() {
        isSmoking = false;
        bedType = "NO BEDS";
        roomNumber = -1;
        numBeds = 0;
    }

    public Room(boolean isSmoking, String bedType, int roomNumber, int numBeds) {
        this.isSmoking = isSmoking;
        this.bedType = bedType;
        this.roomNumber = roomNumber;
        this.numBeds = numBeds;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isSmoking == room.isSmoking && roomNumber == room.roomNumber && numBeds == room.numBeds && Objects.equals(bedType, room.bedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSmoking, bedType, roomNumber, numBeds);
    }

    @Override
    public String toString() {
        return "Room: " +
                "isSmoking = " + isSmoking +
                ", bedType = '" + bedType + '\'' +
                ", roomNumber = " + roomNumber +
                ", numBeds = " + numBeds;
    }
}
