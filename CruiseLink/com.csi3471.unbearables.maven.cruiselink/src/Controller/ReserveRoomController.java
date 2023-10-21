package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller;

import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink.Reservation;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink.Room;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Controller.cruiselink.Ship;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Repository.ReservationDatabase;
import person.Guest;

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

        Reservation newRes = new Reservation(s.path.getStartDate(), s.path.getEndDate(), Boolean.TRUE ,r);

        ReservationDatabaseController resController = new ReservationDatabaseController();
        resController.addReservation(d, p, newRes);


        return newRes;
    }
}
