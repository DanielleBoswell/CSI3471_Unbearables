package Domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private Date startDate;
    private Date endDate;
    private boolean isCanceled;
    private Room room;
    private Long customerId;
    private Long reservationId;

    public Reservation() {
        startDate = null;
        endDate = null;
        isCanceled = false;
        room = null;
        customerId = null;
        reservationId = null;
    }

    public Reservation(Date start, Date end, boolean b, Room r) {
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
    }

    public Reservation(Date start, Date end, boolean b, Long rId, Long cId, Room r) {
        startDate = start;
        endDate = end;
        isCanceled = b;
        room = r;
        customerId = cId;
        reservationId = rId;
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

    public String[] toStringArray() {

        String[] strArr = {startDate.toString(), endDate.toString(), Boolean.toString(isCanceled), Integer.toString(room.getRoomNumber()),
            Boolean.toString(room.isSmoking()), room.getBedType().toString(), Integer.toString(room.getNumBeds()),
            room.getQualityLevel().toString()};

        return strArr;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}