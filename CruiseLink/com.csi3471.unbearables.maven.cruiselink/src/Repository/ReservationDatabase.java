package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Repository;

import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink.Reservation;
import person.Guest;

import java.util.*;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
