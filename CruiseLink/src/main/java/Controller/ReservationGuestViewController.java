package Controller;

import Domain.Reservation;

public class ReservationGuestViewController {

    ReservationViewServices reservationViewServices;
    CancelReservationServices cancelReservationServices;

    public ReservationGuestViewController(){
        reservationViewServices = new ReservationViewServices();
        cancelReservationServices = new CancelReservationServices();
    }
    public String[][] viewReservationsGuest(){
        return reservationViewServices.viewReservations(0l); //how to access Guest info
    }

    public String[] viewReservationGuest(int row){
        return reservationViewServices.viewReservation(row);
    }

    public boolean cancelReservationGuest(long reservationID){
        return cancelReservationServices.canCancelReservation(reservationID);
    }

    public void confirmCancellationGuest(Reservation r){

    }
}
