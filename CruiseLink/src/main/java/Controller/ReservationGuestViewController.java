package Controller;

import UI.UINavigator;

public class ReservationGuestViewController {

    //add more services if needed
    private ReservationViewServices reservationViewServices;
    private CancelReservationServices cancelReservationServices;

    public ReservationGuestViewController(ReservationViewServices r){
        this.reservationViewServices = r;
        this.cancelReservationServices = new CancelReservationServices(r.getSelectedReservation());

    }

    public String cancelReservationGuest(){
        String confirmDialog = "Would you like to cancel this reservation?";
        boolean ok = cancelReservationServices.canCancelReservation();
        if(!ok){
            confirmDialog = cancelReservationServices.getCancellationDesc() + confirmDialog;
        }
        return confirmDialog;
    }

    public boolean confirmCancellationGuest(){
        boolean ok = cancelReservationServices.confirmCancellation();
        return ok;
    }

    public String getShipName(){
        return reservationViewServices.getShipName();
    }

    public String getStartDate(){
        return reservationViewServices.getStartDate();
    }

    public String getEndDate(){
        return reservationViewServices.getEndDate();
    }

    public String getNoSmoking(){
        return reservationViewServices.getNoSmoking();
    }

    public String getBedType(){
        return reservationViewServices.getBedType();
    }
    public int getNumBeds(){
        return reservationViewServices.getNumBeds();
    }

    public String getQualityLevel(){
        return reservationViewServices.getQualityLevel();
    }


}
