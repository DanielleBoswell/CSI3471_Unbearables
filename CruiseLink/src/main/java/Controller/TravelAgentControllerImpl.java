package Controller;

import UI.UINavigator;

public class TravelAgentControllerImpl implements TravelAgentController { // ---- This is where travel agent logic is carried out ----

    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public TravelAgentControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    public void onViewRoomStatus(){

        System.out.println("Viewing Room Status");
    }

    public void onModifyReservation(){

        System.out.println("Modifying Reservation");
    }

    public void onProcessCheckInOut(){

        System.out.println("Processing Check-In/Out");
    }

    public void onGenerateBillingInfo(){

        System.out.println("Generating Billing Information");
    }

    public void onMakeReservation(){

        System.out.println("Making a Reservation");
    }

    public void onCancelReservation() {

        System.out.println("Cancelling Reservation");
    }

    public void onModifyProfile(){

        System.out.println("Modifying Profile");
    }

    public void onModifyRoom(){

        System.out.println("Modifying Room");
    }
}