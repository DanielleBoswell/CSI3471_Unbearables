package Controller;

import Domain.Guest;
import Domain.Reservation;
import Domain.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationViewServices {
    private Reservation[] list = null; // save list of reservations of guest
    private Reservation selectedReservation = null;

    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    public String[][] viewUncancelledReservations(long guestID){ // convert to id of Guest???
        //list = ReservationDatabaseController.getReservations(long guestID); //make sure only uncancelled res
        String[][] reservations ={{"123", "AA", "Executive", "12-31-2023","01-14-2024"},
                                    {"333", "EA", "Business", "12-31-2023","01-14-2024"}}; //connect to list
        return reservations;
    }

    public Object[] viewReservation(long reservationID) throws ParseException { //based on database
        //selectedReservation = ReservationDatabaseController.getReservation(long reservationID);
        selectedReservation = new Reservation(sdf.parse("01-14-2024"),sdf.parse("01-28-2024"),false,new Room()); //mock reservation
        Object[] reservation = {selectedReservation.getID(),
                selectedReservation.getShipName(),
                sdf.format(selectedReservation.getStartDate()),
                sdf.format(selectedReservation.getEndDate())};

        return reservation;
    }

    public String[] viewReservation(int row){ //based on list
        String[] reservation = new String[0];
        selectedReservation = list[row];

        return reservation;
    }
}
