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
        //uiNavigator.showCard(UINavigator.PROFILE_PAGE);
    }

    public void returnToGuestLandingPage() {
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }

    public void alterGuestInformation() {
        // TODO: add functionality here (go to different controller/services??)
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }

    public void returnToAgentLandingPage() {
        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }

    public void alterAgentInformation() {
        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }
}
