package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

import person.Guest;

import java.util.ArrayList;

public class ReservationDatabaseController {
    void addReservation(ReservationDatabase database, Guest p, Reservation r){
        ArrayList<Reservation> tmp = new ArrayList<>();
        if(database.reservationMap.containsKey(p)){
            tmp = database.reservationMap.get(p);
            tmp.add(r);
            database.reservationMap.put(p,tmp);
        }else {
            tmp.add(r);
            database.reservationMap.put(p,tmp);
        }
    }
}
