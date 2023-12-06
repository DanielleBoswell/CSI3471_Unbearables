package Controller;

import UI.UINavigator;
import UI.ViewReservationsGUI;

public class GuestControllerImpl implements GuestController {

    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public GuestControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    public void onSearchCruises() {
        uiNavigator.showCard(UINavigator.CHOOSE_CRUISE_PANEL);
        System.out.println("Searching Cruises");
    }

    public void onViewReservation() {

        UINavigator.addCard(new ViewReservationsGUI(uiNavigator), UINavigator.VIEW_GUEST_RESERVATIONS);
        UINavigator.showCard(UINavigator.VIEW_GUEST_RESERVATIONS);
        System.out.println("Viewing all reservations");
    }

    public void onCancelReservation() {

        System.out.println("Cancelling Reservation");
    }

    public void onModifyReservation() {
        System.out.println("Modifying Reservation");
        UINavigator.addCard(new ViewReservationsGUI(uiNavigator), UINavigator.VIEW_GUEST_RESERVATIONS);
        UINavigator.showCard(UINavigator.VIEW_GUEST_RESERVATIONS);
        System.out.println("viewing all reservations");
    }

    public void onViewProfile() {
        //ProfileControllerImpl.onViewProfile();

        uiNavigator.showCard(UINavigator.GUEST_PROFILE_PAGE);

        System.out.println("Viewing Profile");
    }
}