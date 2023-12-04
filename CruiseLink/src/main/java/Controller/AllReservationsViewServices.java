package Controller;

import Domain.Reservation;
import Domain.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

public class AllReservationsViewServices {
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private List<Reservation> list; // save list of reservations of guest

    public Object[][] viewUncancelledReservations(long guestID){ // convert to id of Guest???
        //list = ReservationDatabaseController.getReservations(long guestID); //make sure only uncancelled res
        try {
            list = List.of(new Reservation[]{new Reservation(sdf.parse("01-14-2024"), sdf.parse("01-28-2024"), false, new Room())
                    , new Reservation(sdf.parse("01-14-2024"), sdf.parse("01-28-2024"), false, new Room())});
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Object[][] reservations ={{"123", "AA", "Executive", "12-31-2023","01-14-2024"},
                                    {"333", "EA", "Business", "12-31-2023","01-14-2024"}};//connect to list
        Vector<Object[]> a = new Vector<>();
        for(Reservation r : list){
            a.add(new Object[]{r.getReservationId(), r.getShipName(),r.getRoom().getQualityLevel().name(),
                    sdf.format(r.getStartDate()), sdf.format(r.getEndDate())});
        }

        a.copyInto(reservations);
        return reservations;
    }

    public ReservationViewServices viewReservation(long reservationID) throws ParseException { //based on database
        //selectedReservation = ReservationDatabaseController.getReservation(long reservationID);
        Reservation selectedReservation = new Reservation(sdf.parse("01-14-2024"),sdf.parse("01-28-2024"),false,new Room()); //mock reservation
//        Object[] reservation = {selectedReservation.getReservationId(),
//                selectedReservation.getShipName(),
//                sdf.format(selectedReservation.getStartDate()),
//                sdf.format(selectedReservation.getEndDate())};

        return new ReservationViewServices(selectedReservation);
    }

    public ReservationViewServices viewReservation(int row) { //based on list
        Reservation selectedReservation = list.get(row);
        try {
            selectedReservation = new Reservation(sdf.parse("01-14-2024"), sdf.parse("01-28-2024"), false, new Room()); //mock reservation
        }
        catch(ParseException e){

        }
        return new ReservationViewServices(selectedReservation);
    }
}
