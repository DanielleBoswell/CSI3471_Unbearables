package Repository;

import Domain.Guest;
import Domain.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
