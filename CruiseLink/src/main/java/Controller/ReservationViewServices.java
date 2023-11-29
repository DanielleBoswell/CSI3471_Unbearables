package Controller;

import Domain.Reservation;

public class ReservationViewServices {
    private Reservation selectedReservation;

    public ReservationViewServices(Reservation r){
        this.selectedReservation = r;
    }

}
