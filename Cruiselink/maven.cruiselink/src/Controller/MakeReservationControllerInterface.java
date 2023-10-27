package Cruiselink.maven.cruiselink.src.Controller;

import java.sql.Date;

public interface MakeReservationControllerInterface {
    public String[] getRoomInfo();
    public boolean canReserve(String start, String end, int total);
    public void reserveRoom();
}
