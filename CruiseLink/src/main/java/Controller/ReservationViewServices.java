package Controller;

import Domain.Reservation;

import java.text.SimpleDateFormat;

public class ReservationViewServices {
    private Reservation selectedReservation;

    private final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public ReservationViewServices(Reservation r){
        this.selectedReservation = r;
    }

    public Reservation getSelectedReservation() {
        return selectedReservation;
    }

    public void setSelectedReservation(Reservation r){
        this.selectedReservation = r;
    }

    public String getShipName(){
        return selectedReservation.getShipName();
    }

    public String getStartDate(){
        return sdf.format(selectedReservation.getStartDate());
    }

    public String getEndDate(){
        return sdf.format(selectedReservation.getEndDate());
    }

    public String getNoSmoking(){
        if(selectedReservation.getRoom().isSmoking()){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    public String getBedType(){
        return selectedReservation.getRoom().getBedType().toString();
    }
    public int getNumBeds(){
        return selectedReservation.getRoom().getNumBeds();
    }

    public String getQualityLevel(){
        return selectedReservation.getRoom().getQualityLevel().toString();
    }


}
