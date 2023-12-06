package Domain;

import Repository.ShipDatabase;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private Date startDate;

    private Date creationDate;
    private Date endDate;
    private boolean isCanceled;
    private Ship ship; // reservation should know about its ship
    public enum CheckInStatus{IS_CHECKED_IN,IS_NOT_CHECKED_IN,IS_CHECKED_OUT};
    private CheckInStatus isCheckedIn;
    private Room room;

    private Long customerId;
    private Long reservationId;

    public Reservation() {
        startDate = null;
        endDate = null;
        isCanceled = false;
        room = null;
        creationDate = null;
        isCheckedIn = CheckInStatus.IS_NOT_CHECKED_IN;
        customerId = null;
        reservationId = null;
        isCheckedIn = CheckInStatus.IS_NOT_CHECKED_IN;
        creationDate = Date.valueOf(LocalDate.now());
    }


    public Reservation(Date start, Date end, boolean b, Room r, Date made) {
        this();
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
        creationDate = made;
        ship = ShipDatabase.getById(1L);

    }

    public Reservation(Date start, Date end, boolean b, Room r) {
        this(start,end,b,r,Date.valueOf(LocalDate.now()));
    }

    public Reservation(Date start, Date end, boolean b, Long rId, Long cId, Room r) {
        this();
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
        customerId = cId;
        reservationId = rId;
        ship = ShipDatabase.getById(1L);
    }

    public Reservation(Date start, Date end, boolean b, Long rId, Long cId, Room r, Ship s) {
        this();
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
        customerId = cId;
        reservationId = rId;
        this.ship = s;
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

    public void setIsCheckedIn(CheckInStatus isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }

    public CheckInStatus getIsCheckedIn() {
        return isCheckedIn;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate){
            this.creationDate = creationDate;
    }
    public String[] toStringArray() {

        String[] strArr = {startDate.toString(), endDate.toString(), Boolean.toString(isCanceled), Integer.toString(room.getRoomNumber()),
            Boolean.toString(room.isSmoking()), room.getBedType().toString(), Integer.toString(room.getNumBeds()),
            room.getQualityLevel().toString(), this.ship.getName()};

        return strArr;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}