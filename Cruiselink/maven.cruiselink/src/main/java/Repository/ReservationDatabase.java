package Cruiselink.maven.cruiselink.src.Repository;

import Cruiselink.maven.cruiselink.src.Domain.Guest;
import Cruiselink.maven.cruiselink.src.Domain.Reservation;

import java.util.*;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }
}
