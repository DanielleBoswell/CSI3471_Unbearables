package Domain;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Date startDate;

    private Date creationDate;
    private Date endDate;
    private boolean isCanceled;
    private Room room;
    private Ship ship; // reservation should know about its ship

    private long id;

    public Reservation() {
        startDate = null;
        endDate = null;
        isCanceled = false;
        room = null;
        creationDate = null;
        id = 0l;
    }

    public Reservation(Date start, Date end, boolean b, Room r, Date made) {
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
        creationDate = made;
    }

    public Reservation(Date start, Date end, boolean b, Room r) {
        this(start,end,b,r,new Date());
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setShip(Ship ship){ this.ship = ship;}
    public Ship getShip(){return ship;}

    public String getShipName(){return ship.getName();}

    public long getID(){return id;}

    public void setID(long id){this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return isCanceled == that.isCanceled && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, isCanceled, room);
    }

    @Override
    public String toString() {
        return "Reservation:" +
                "startDate = " + startDate +
                ", endDate = " + endDate +
                ", isCanceled = " + isCanceled +
                ", room = " + room;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}