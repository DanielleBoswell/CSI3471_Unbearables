package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

import java.util.*;

public class ReservationDatabase {
    Map<Person, ArrayList<Reservation>> reservationMap;

    ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
