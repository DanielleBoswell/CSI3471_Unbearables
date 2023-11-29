package Controller;

public class AllReservationsGuestViewController {

    AllReservationsViewServices reservationViewServices;
    CancelReservationServices cancelReservationServices;

    public AllReservationsGuestViewController(){
        reservationViewServices = new AllReservationsViewServices();
        cancelReservationServices = new CancelReservationServices();
    }
    public String[][] viewReservationsGuest(){
        return reservationViewServices.viewUncancelledReservations(0l); //how to access Guest info
    }

    public String[] viewReservationGuest(int row){
        return reservationViewServices.viewReservation(row);
    }

    public String cancelReservationGuest(long reservationID){
        String confirmDialog = "Would you like to cancel this reservation?";
        boolean ok = cancelReservationServices.canCancelReservation(reservationID);
        if(!ok){
            confirmDialog = cancelReservationServices.getCancellationDesc() + confirmDialog;
        }
        return confirmDialog;
    }

    public boolean confirmCancellationGuest(){
        boolean ok = cancelReservationServices.confirmCancellation(0l,0l);
        return ok;
    }
}
