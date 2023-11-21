package Controller;

import Domain.Guest;
import Domain.Reservation;

public class ReservationViewServices {
    private Reservation[] list = null;
    public String[][] viewReservations(long guestID){ // convert to int id of Guest???
        //list = ReservationDatabaseController.getReservations(Guest g);
        String[][] reservations = new String[0][]; //connect to list
        return reservations;
    }

    public String[] viewReservation(int row){ //
        String[] reservation = new String[0];
        Reservation r = list[row];

        return reservation;
    }
}
