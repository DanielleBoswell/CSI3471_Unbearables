// Author: Emma Aars
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

    // TODO: make usable for guest AND travel agents
    public void returnToLandingPage() {
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }

    public void alterInformation() {
        // TODO: add functionality here (go to different controller/services??)
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }
}
