package Repository;

import Domain.Guest;
import Domain.Reservation;

import java.util.*;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
