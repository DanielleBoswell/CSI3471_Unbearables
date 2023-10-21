package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

import person.Guest;

public class ReserveRoomController {
    public void reserveRoom(ReservationDatabase d, Guest p, Ship s, Room r){
        if(s.roomMap.containsKey(r.getRoomNumber())){
            createReservation(d,p,s,r);
            r.setReserved(Boolean.TRUE);
        }
    }

    public Reservation createReservation(ReservationDatabase d, Guest p, Ship s, Room r){

        Reservation newRes = new Reservation(s.path.getStartDate(), s.path.getEndDate(), Boolean.TRUE ,r);

        ReservationDatabaseController resController = new ReservationDatabaseController();
        resController.addReservation(d, p, newRes);


        return newRes;
    }
}
