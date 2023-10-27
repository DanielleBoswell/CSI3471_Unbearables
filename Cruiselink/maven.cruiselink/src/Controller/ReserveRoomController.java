package Cruiselink.maven.cruiselink.src.Controller;

import Cruiselink.maven.cruiselink.src.Domain.Guest;
import Cruiselink.maven.cruiselink.src.Domain.Room;
import Cruiselink.maven.cruiselink.src.Domain.Ship;

public class ReserveRoomController {
    public void reserveRoom(ReservationDatabase d, Guest p, Ship s, Room r){
        if(s.roomMap.containsKey(r.getRoomNumber()) && !s.roomMap.get(r.getRoomNumber()).getIsReserved()){
            createReservation(d,p,s,r);
            r.setReserved(Boolean.TRUE);
        }else{
            System.out.println("Already reserved");
        }
    }

    public Reservation createReservation(ReservationDatabase d, Guest p, Ship s, Room r){

        Reservation newRes = new Reservation(s.path.getStartDate(), s.path.getEndDate(), Boolean.FALSE, r);

        ReservationDatabaseController resController = new ReservationDatabaseController();
        resController.addReservation(d, p, newRes);


        return newRes;
    }
}
