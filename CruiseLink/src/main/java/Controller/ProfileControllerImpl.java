// Author: Emma Aars
package Controller;

import UI.UINavigator;

/**
 * This class implements the Profile Controller to connect
 * the profile page UI and its functionality. It serves as a
 * controller. Both Trvael Agent and Guest profile page use
 * this class.
 * @author Emma
 */
public class ProfileControllerImpl implements ProfileController{
    /**
     * UI navigator that switches between panels.
     */
    private UINavigator uiNavigator;

    /**
     * This constructor initializes which UI navigator to use when
     * switching panels.
     * @param uiNavigator
     */
    public ProfileControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    /**
     * This method returns to the guest landing page from
     * the guest profile page. It is meant to be called by
     * the cancel button.
     */
    public void returnToGuestLandingPage() {
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }

    /**
     * This method returns to the guest landing page from
     * the guest profile page. It is meant to be called when
     * altering the information in the guest's profile.
     */
    public void alterGuestInformation() {
        // TODO: add functionality here (go to different controller/services??)
        uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
    }

    /**
     * This method returns to the travel agent landing page from
     * the travel agent profile page. It is meant to be called by
     * the cancel button.
     */
    public void returnToAgentLandingPage() {
        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }

    /**
     * This method returns to the travel agent landing page from
     * the travel agent profile page. It is meant to be called when
     * altering the information in the travel agent's profile.
     */
    public void alterAgentInformation() {
        uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }
}
