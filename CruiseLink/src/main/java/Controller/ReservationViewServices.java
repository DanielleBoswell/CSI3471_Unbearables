package Controller;

import Domain.Reservation;

import java.text.SimpleDateFormat;

/**
 * Services to view a single reservation
 *
 * @author Danielle Boswell
 */
public class ReservationViewServices {
    /**
     * reservation being viewed
     */
    private Reservation selectedReservation;
    /**
     * for formatting dates to string
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * sets the selected reservation when being constructed
     *
     * @param r reservation
     * @author Danielle Boswell
     */
    public ReservationViewServices(Reservation r){
        this.selectedReservation = r;
    }

    /**
     * returns the selected reservation
     *
     * @return selected reservation
     * @author Danielle Boswell
     */
    public Reservation getSelectedReservation() {
        return selectedReservation;
    }

    /**
     * sets the reservation to be viewed
     * @param r reservation
     */
    public void setSelectedReservation(Reservation r){
        this.selectedReservation = r;
    }

    /**
     * returns the ship Name of the reservation
     * @return ship name
     * @author Danielle Boswell
     */
    public String getShipName(){
        return selectedReservation.getShipName();
    }
    /**
     * Gets reservation start date
     * @return start date
     * @author Danielle Boswell
     */
    public String getStartDate(){
        return sdf.format(selectedReservation.getStartDate());
    }
    /**
     * Gets reservation end date
     * @return start date
     * @author Danielle Boswell
     */
    public String getEndDate(){
        return sdf.format(selectedReservation.getEndDate());
    }
    /**
     * Gets reservation room smoking status
     * @return smoking
     * @author Danielle Boswell
     */
    public String getNoSmoking(){
        if(selectedReservation.getRoom().isSmoking()){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    /**
     * Gets reservation room bed type
     * @return bed type
     * @author Danielle Boswell
     */
    public String getBedType(){
        return selectedReservation.getRoom().getBedType().toString();
    }
    /**
     * Gets reservation room number of beds
     * @return bed number
     * @author Danielle Boswell
     */
    public int getNumBeds(){
        return selectedReservation.getRoom().getNumBeds();
    }
    /**
     * Gets reservation room quality level
     * @return quality level
     * @author Danielle Boswell
     */
    public String getQualityLevel(){
        return selectedReservation.getRoom().getQualityLevel().toString();
    }


}
