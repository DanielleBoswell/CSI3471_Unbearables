package Controller;

public class AllReservationsGuestViewController {

    AllReservationsViewServices reservationViewServices;

    public AllReservationsGuestViewController(){
        reservationViewServices = new AllReservationsViewServices();
    }
    public Object[][] viewReservationsGuest(){
        return reservationViewServices.viewUncancelledReservations(0l); //how to access Guest info
    }


    public ReservationGuestViewController viewReservationGuest(int row){
        return new ReservationGuestViewController(reservationViewServices.viewReservation(row));
    }



}
