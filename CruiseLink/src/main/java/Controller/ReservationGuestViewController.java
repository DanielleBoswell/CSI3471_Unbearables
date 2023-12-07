package Controller;

import UI.UINavigator;

/**
 * Controller to view information of a single reservation
 * Can be used to cancel or modify a reservation as a Guest
 * @author Danielle Boswell
 */
public class ReservationGuestViewController {

    //add more services if needed
    /**
     * Services to view reservation information
     */
    private ReservationViewServices reservationViewServices;
    /**
     * services to cancel reservation
     */
    private CancelReservationServices cancelReservationServices;

    /**
     * Constructor for storing and setting up services
     * @param r
     * @author Danielle Boswell
     */
    public ReservationGuestViewController(ReservationViewServices r){
        this.reservationViewServices = r;
        this.cancelReservationServices = new CancelReservationServices(r.getSelectedReservation());

    }

    /**
     * Used to confirm if Guest wants to cancel reservation
     * @return confirmDialog
     * @author Danielle Boswell
     */
    public String cancelReservationGuest(){
        String confirmDialog = "Would you like to cancel this reservation?";
        boolean ok = cancelReservationServices.canCancelReservation();
        if(!ok){
            confirmDialog = cancelReservationServices.getCancellationDesc() + confirmDialog;
        }
        return confirmDialog;
    }

    /**
     * Actually cancels reservation and returns if it is successful
     * @return ok
     * @author Danielle Boswell
     */
    public boolean confirmCancellationGuest(){
        boolean ok = cancelReservationServices.confirmCancellation();
        return ok;
    }

    /**
     * Gets reservation ship name
     * @return ship name
     * @author Danielle Boswell
     */
    public String getShipName(){
        return reservationViewServices.getShipName();
    }
    /**
     * Gets reservation start date
     * @return start date
     * @author Danielle Boswell
     */
    public String getStartDate(){
        return reservationViewServices.getStartDate();
    }

    /**
     * Gets reservation end date
     * @return start date
     * @author Danielle Boswell
     */
    public String getEndDate(){
        return reservationViewServices.getEndDate();
    }

    /**
     * Gets reservation room smoking status
     * @return smoking
     * @author Danielle Boswell
     */
    public String getNoSmoking(){
        return reservationViewServices.getNoSmoking();
    }
    /**
     * Gets reservation room bed type
     * @return bed type
     * @author Danielle Boswell
     */
    public String getBedType(){
        return reservationViewServices.getBedType();
    }
    /**
     * Gets reservation room number of beds
     * @return bed number
     * @author Danielle Boswell
     */
    public int getNumBeds(){
        return reservationViewServices.getNumBeds();
    }
    /**
     * Gets reservation room quality level
     * @return quality level
     * @author Danielle Boswell
     */
    public String getQualityLevel(){
        return reservationViewServices.getQualityLevel();
    }


}
