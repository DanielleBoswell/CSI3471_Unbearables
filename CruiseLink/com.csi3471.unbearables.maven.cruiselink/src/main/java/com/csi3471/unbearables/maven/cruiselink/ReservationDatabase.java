package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

import person.Guest;

import java.util.*;

public class ReservationDatabase {
    Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
