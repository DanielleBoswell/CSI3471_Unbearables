package Controller;

/**
 * Controller to view all reservations of a Guest
 * To allow a Guest to view select to view one of
 * their reservations
 *
 * @author Danielle Boswell
 */
public class AllReservationsGuestViewController {

    /**
     * services to allow for Guest to view all reservations
     */
    AllReservationsViewServices reservationViewServices;

    /**
     * constructor creating new services
     */
    public AllReservationsGuestViewController(){
        reservationViewServices = new AllReservationsViewServices();
    }

    /**
     * view all uncancelled reservations of a Guest
     * @return object[][] of reservations
     * @author Danielle Boswell
     */
    public Object[][] viewReservationsGuest(){
        return reservationViewServices.viewUncancelledReservations(1L); //how to access Guest info
    }

    /**
     * prepares to view a single reservation of a guest
     *
     * @param row row of selected reservation
     * @return ReservationGuestViewController
     * @author Danielle Boswell
     */
    public ReservationGuestViewController viewReservationGuest(int row){
        return new ReservationGuestViewController(reservationViewServices.viewReservation(row));
    }



}
