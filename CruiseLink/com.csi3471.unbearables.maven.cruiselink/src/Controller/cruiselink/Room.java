package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink;

import java.util.Objects;

public class Room {
    private boolean isSmoking;
    public enum BedType {NONE, TWIN, FULL, QUEEN, KING};
    private BedType bedType;
    private int roomNumber;
    private int numBeds;
    private boolean isReserved;
    public enum QualityLevel {EXECUTIVE, BUSINESS, COMFORT, ECONOMOY};
    private QualityLevel qualityLevel;


    // FIX ME: 10/20/2023
    // set maxBeds = 3
    // change bedType to enum
    // FIXED: 10/21/2023 Kyle Hoang

    public Room() {
        isSmoking = false;
        bedType = BedType.NONE;
        roomNumber = -1;
        numBeds = 0;
        isReserved = false;
        qualityLevel = QualityLevel.ECONOMOY;
    }

    public Room(boolean isSmoking, BedType bedType, int roomNumber, int numBeds, QualityLevel qualityLevel) {
        this.isSmoking = isSmoking;
        this.bedType = bedType;
        this.roomNumber = roomNumber;
        this.numBeds = numBeds;
        this.isReserved = false;
        this.qualityLevel = qualityLevel;
    }

    //added by Spencer Hammack
    public void setReserved(boolean TF){this.isReserved = TF;}
    public Boolean getIsReserved(){return isReserved;}

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
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
        return "Room{" +
                "isSmoking=" + isSmoking +
                ", bedType=" + bedType +
                ", roomNumber=" + roomNumber +
                ", numBeds=" + numBeds +
                ", isReserved=" + isReserved +
                ", qualityLevel=" + qualityLevel +
                '}';
    }
}
