package Controller;

import UI.UINavigator;

public class ProfileControllerImpl implements ProfileController{
    private UINavigator uiNavigator;

    public ProfileControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    public void onViewProfile() {
        // switch to profile page
        uiNavigator.showCard(UINavigator.PROFILE_PAGE);
    }

    public void returnToLandingPage() {
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }
}
