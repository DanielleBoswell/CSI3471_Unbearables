package Controller;

import Domain.Reservation;
import Domain.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AllReservationsViewServices {
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private Reservation[] list; // save list of reservations of guest

    public String[][] viewUncancelledReservations(long guestID){ // convert to id of Guest???
        //list = ReservationDatabaseController.getReservations(long guestID); //make sure only uncancelled res
        try {
            list = new Reservation[]{new Reservation(sdf.parse("01-14-2024"),sdf.parse("01-28-2024"),false,new Room())
                    ,new Reservation(sdf.parse("01-14-2024"),sdf.parse("01-28-2024"),false,new Room())};
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String[][] reservations ={{"123", "AA", "Executive", "12-31-2023","01-14-2024"},
                                    {"333", "EA", "Business", "12-31-2023","01-14-2024"}}; //connect to list
        return reservations;
    }

    public ReservationViewServices viewReservation(long reservationID) throws ParseException { //based on database
        //selectedReservation = ReservationDatabaseController.getReservation(long reservationID);
        Reservation selectedReservation = new Reservation(sdf.parse("01-14-2024"),sdf.parse("01-28-2024"),false,new Room()); //mock reservation
        Object[] reservation = {selectedReservation.getReservationId(),
                selectedReservation.getShipName(),
                sdf.format(selectedReservation.getStartDate()),
                sdf.format(selectedReservation.getEndDate())};

        return new ReservationViewServices(selectedReservation);
    }

    public ReservationViewServices viewReservation(int row) { //based on list
        Reservation selectedReservation = list[row];
        try {
            selectedReservation = new Reservation(sdf.parse("01-14-2024"), sdf.parse("01-28-2024"), false, new Room()); //mock reservation
        }
        catch(ParseException e){

        }
        return new ReservationViewServices(selectedReservation);
    }
}
