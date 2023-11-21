package Controller;

import UI.UINavigator;

public class AdminControllerImpl implements AdminController {

    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public AdminControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    public void onCreateTravelAgentAccount(){

        System.out.println("Creating a travel agent account");
    }

    public void onResetUserAccountPassword(){

        System.out.println("Resetting user account password");
    }
}