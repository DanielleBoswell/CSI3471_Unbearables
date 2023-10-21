package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

import java.util.ArrayList;

public class ReservationDatabaseController {
    void addReservation(ReservationDatabase database, Person p, Reservation r){
        ArrayList<Reservation> tmp;
        if(database.reservationMap.containsKey(p)){
            tmp = database.reservationMap.get(p);
            tmp.add(r);
            database.reservationMap.put(p,tmp);
        }
    }
}
