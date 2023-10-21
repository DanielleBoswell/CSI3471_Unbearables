package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Date startDate;
    private Date endDate;
    private boolean isCanceled;
    private Room room;

    public Reservation() {
        startDate = null;
        endDate = null;
        isCanceled = false;
        room = null;
    }

    public Reservation(Date start, Date end, boolean b, Room r) {
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
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
}