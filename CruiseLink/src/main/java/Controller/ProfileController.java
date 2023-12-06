package Controller;

/**
 * This interface is used to connect the profile page UI's
 * to their functionality. It serves as a controller. Both
 * Trvael Agent and Guest profile page use this interface.
 * @author Emma
 */
public interface ProfileController {
    /**
     * This method returns to the guest landing page from
     * the guest profile page. It is meant to be called by
     * the cancel button.
     */
    void returnToGuestLandingPage();

    /**
     * This method returns to the guest landing page from
     * the guest profile page. It is meant to be called when
     * altering the information in the guest's profile.
     */
    void alterGuestInformation();

    /**
     * This method returns to the travel agent landing page from
     * the travel agent profile page. It is meant to be called by
     * the cancel button.
     */
    void returnToAgentLandingPage();

    /**
     * This method returns to the travel agent landing page from
     * the travel agent profile page. It is meant to be called when
     * altering the information in the travel agent's profile.
     */
    void alterAgentInformation();

}
