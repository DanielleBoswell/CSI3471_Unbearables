package Controller;

import Domain.Reservation;

import java.util.Date;

public class CancelReservationServices {
    Reservation reservation;

    public void setReservation(long reservationID){

        reservation = new Reservation(); // connect to Reservation Database
    }
    public boolean canCancelReservation(long reservationID){
        return reservation.canCancelReservation(new Date());
    }
}
