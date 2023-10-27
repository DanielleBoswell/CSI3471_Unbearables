package Cruiselink.maven.cruiselink.src.Controller;

import Cruiselink.maven.cruiselink.src.Domain.Guest;
import Cruiselink.maven.cruiselink.src.Domain.Reservation;
import Cruiselink.maven.cruiselink.src.Repository.ReservationDatabase;

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
