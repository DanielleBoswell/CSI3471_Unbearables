package Controller;

import Domain.Guest;
import Domain.Reservation;
import Domain.Room;
import Domain.Ship;
import Repository.ReservationDatabase;

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
