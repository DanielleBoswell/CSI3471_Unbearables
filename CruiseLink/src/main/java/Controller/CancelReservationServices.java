package Controller;

import Domain.Reservation;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Services to allow user to cancel a reservation
 *
 * @author Danielle Boswell
 */
public class CancelReservationServices {
    /**
     * Reservation to be cancelled
     */
    Reservation reservation;

    /**
     * Tracks if the guest has to be charged a fee
     * for cancellation
     */
    boolean ok = false;

    public CancelReservationServices(){}

    /**
     * Sets the reservation to be cancelled
     *
     * @param r
     * @author Danielle Boswell
     */
    public CancelReservationServices(Reservation r){
        reservation = r;
    }

    /**
     * Makes sure that the reservation can be cancelled with no fee
     * @return ok
     * @author Danielle Boswell
     */
    public boolean canCancelReservation(){
        Date d = new Date();
        long diff = d.getTime() - reservation.getCreationDate().getTime();
        diff = (diff / (1000 * 60 * 60 * 24)) % 365;
        ok = diff < 2;
        return ok;
    }

    /**
     * Displays if there is a fee to be paid
     * @return String
     * @author Danielle Boswell
     */
    public String getCancellationDesc(){
        return "Sorry, but a fee of $50.00 will be charged to your account \n";
    }

    /**
     * actually cancels the reservation (after charging the guest
     * a fee if cancellation is past the limit)
     * Confirms cancellation by returning if true or false
     *
     * @return boolean
     * @author Danielle Boswell
     */
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
