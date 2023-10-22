package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Repository;

import CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink.Reservation;
import CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person.Guest;

import java.util.*;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
