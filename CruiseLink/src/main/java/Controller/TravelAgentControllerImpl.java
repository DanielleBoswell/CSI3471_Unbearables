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

        //System.out.println("Generating Billing Information");

        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_BILLING_PANEL);
    }

    public void onMakeReservation(){
        uiNavigator.showCard(UINavigator.CHOOSE_GUEST_PANEL);
        System.out.println("Making a Reservation");
    }

    public void onCancelReservation() {

        System.out.println("Cancelling Reservation");
    }

    public void onModifyProfile(){
        uiNavigator.showCard(UINavigator.AGENT_PROFILE_PAGE);
        System.out.println("Modifying Profile");
    }

    public void onModifyRoom(){

        //System.out.println("Modifying Room");

        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_MODIFY_ROOM_PANEL);
    }
}