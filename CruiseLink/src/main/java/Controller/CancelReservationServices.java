package Controller;

import Domain.Reservation;

import java.util.Date;
import java.util.logging.Logger;

public class CancelReservationServices {
    Reservation reservation;
    //Logger logger = new Logger(this.getClass().getName());
    boolean ok = false;

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
        return "Do you want to cancel this reservation?"; // connect to billinginfo
    }

    public boolean confirmCancellation(long guestID, long reservationID){
        boolean charged, isCancelled = true;
        if(!ok){
            charged = false; // connect to billing info
            System.out.println("Charging Account");
            charged = true;
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
