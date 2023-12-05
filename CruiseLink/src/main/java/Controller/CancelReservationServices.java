package Controller;

import Domain.Reservation;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;

import java.util.Date;
import java.util.logging.Logger;

public class CancelReservationServices {
    Reservation reservation;
    //Logger logger = new Logger(this.getClass().getName());
    boolean ok = false;

    public CancelReservationServices(){}

    public CancelReservationServices(Reservation r){
        reservation = r;
    }

    private void setReservation(long reservationID){

        reservation = new Reservation(); // connect to Reservation Database
    }


    public boolean canCancelReservation(){
        Date d = new Date();
        long diff = d.getTime() - reservation.getCreationDate().getTime();
        diff = (diff / (1000 * 60 * 60 * 24)) % 365;
        ok = diff < 2;
        return ok;
    }

    public String getCancellationDesc(){
        return "Do you want to cancel this reservation?"; // connect to billinginfo
    }

    public boolean confirmCancellation(){
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
            ReservationDatabase rd = new ReservationDatabase();
            ReservationDBO dbo = new ReservationDBO(rd.getDBConnection());
            reservation.setCanceled(true);
            dbo.save(reservation);
            isCancelled = true;
            // basically connect to reservationDatabase
        }
        return charged && isCancelled;
    }
}
