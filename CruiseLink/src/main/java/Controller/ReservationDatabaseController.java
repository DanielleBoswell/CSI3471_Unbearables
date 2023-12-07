package Controller;

import Domain.Guest;
import Domain.Reservation;
import Repository.ReservationDatabase;

import java.util.ArrayList;

/**
 * @author Spencer Hammack
 * This class provides the methods to change and add to the reservation database
 */

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
