package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink;

public class ReserveRoomController {
    public void reserveRoom(ReservationDatabase d, Person p, Ship s, Room r){
        if(s.roomMap.containsKey(r.getRoomNumber())){

        }
    }

    public Reservation createReservation(ReservationDatabase d,Person p, Ship s, Room r){

        Reservation newRes = new Reservation(s.path.getStartDate(), s.path.getEndDate(), Boolean.TRUE ,r);

        ReservationDatabaseController resController = new ReservationDatabaseController();
        resController.addReservation(d, p, newRes);


        return newRes;
    }
}
