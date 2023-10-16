package org.example;

public class Room {
    private boolean isSmoking;
    private String bedType;
    private int roomNumber;
    private int numBeds;

    public Room() {
        isSmoking = false;
        bedType = "NO BED";
        roomNumber = -1;
        numBeds = 0;
    }

    public Room(boolean b, String s, int rNum, int bNum) {
        isSmoking = b;
        bedType = s;
        roomNumber = rNum;
        numBeds = bNum;
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
}
