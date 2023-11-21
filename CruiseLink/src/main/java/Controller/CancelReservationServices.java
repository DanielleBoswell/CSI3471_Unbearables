package Controller;

import Domain.Reservation;

import java.util.Date;

public class CancelReservationServices {
    Reservation reservation;
    boolean ok;

    private void setReservation(long reservationID){

        reservation = new Reservation(); // connect to Reservation Database
    }
    public boolean canCancelReservation(long reservationID){
        setReservation(reservationID);
        Date d = new Date();
            long diff = d.getTime() - reservation.getCreationDate().getTime();
            diff = (diff / (1000 * 60 * 60 * 24)) % 365;
            ok = diff < 2;
            return ok;
    }

    public String getCancellationDesc(){
        return ""; // connect to billinginfo
    }

    public boolean confirmCancellation(long guestID, long reservationID){
        boolean charged, isCancelled = true;
        if(!ok){
            charged = true; // connect to billing info
        }
        else{
            charged = true;
        }

        if(charged){
            //isCancelled = ReservationDatabaseController.setReservationStatus(reservationID,"CANCELLED");
            // basically connect to reservationDatabase
        }
        return charged && isCancelled;
    }
}
