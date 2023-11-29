package UI;

import Controller.AdminControllerImpl;
import Controller.GuestControllerImpl;
import Controller.LoginControllerImpl;
import Controller.TravelAgentControllerImpl;

import javax.swing.*;
import java.awt.*;

public class UINavigator extends JFrame {

    //Declaring a CardLayout to manage navigation of panels (GUIs)
    private static CardLayout cardLayout = null;

    //Declaring a JPanel that will hold the different cards (panels)
    private static JPanel cardPanel = null;

    //String identifiers in CardLayout are used to reference and switch between different panels (cards) within
    //a container managed by CardLayout manager. They are unique keys for each card in the layout.
    //They are needed for the functionality of the CardLayout when we need to change the visible component.

    //Constant identifiers for our panels --- Add one for each page in software ---
    public static final String LAUNCH_PANEL = "Launch Panel";
    public static final String LOGIN_PANEL = "Login Panel";
    public static final String SIGNUP_PANEL = "Sign Up Panel";

    /* ----------- ADD IDENTIFIERS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    //Example: public static final String TEST_PANEL = "Test Panel";

    public static final String TRAVEL_AGENT_LANDING_PANEL = "Travel Agent Landing Panel";
    public static final String ADMIN_LANDING_PANEL = "Admin Landing Panel";
    public static final String GUEST_LANDING_PANEL = "Guest Landing Panel";



    /* ----------- ADD IDENTIFIERS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    //Main frame for our software (Main window)
    private JFrame frame;

    //Constructor for UINavigator class
    public UINavigator() {

        //Creating a new JFrame with the title CruiseLink
        frame = new JFrame("CruiseLink");

        //Load the image for the icon -------------- For the thumbnail image --------------
        ImageIcon icon = new ImageIcon("Cuddly Bear.png");
        Image image = icon.getImage();

        //Set the icon
        frame.setIconImage(image);

        //Setting the default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initializing the CardLayout
        cardLayout = new CardLayout();

        //Initializing the cardPanel with the CardLayout
        cardPanel = new JPanel(cardLayout);

        //Add the cards (panels) to the cardPanel with the respective identifiers
        // --- This is where we add the panels to the main frame (panels = pages in software) ---
        cardPanel.add(createLaunch(), LAUNCH_PANEL);
        cardPanel.add(createLogin(), LOGIN_PANEL);
        cardPanel.add(createSignup(), SIGNUP_PANEL);

        /* ----------- ADD PANELS HERE FOR EACH GUI PAGE ----------- */

        //Example: cardPanel.add(createTest(), TEST_PANEL);

        cardPanel.add(createTravelAgentLanding(), TRAVEL_AGENT_LANDING_PANEL);
        cardPanel.add(createAdminLanding(), ADMIN_LANDING_PANEL);
        cardPanel.add(createGuestLanding(), GUEST_LANDING_PANEL);



        /* ----------- ADD PANELS HERE FOR EACH GUI PAGE ----------- */

        //Add the main panel to the frame in the center
        frame.add(cardPanel, BorderLayout.CENTER);

        //Maximize the frame (fullscreen)
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Make the frame visible after all components have been added
        frame.setVisible(true);
    }

    //Method to create the launch panel
    private JPanel createLaunch() {

        //Make a new page object and pass this UINavigator to its constructor - essential
        LaunchGUI launchGUIInstance = new LaunchGUI(this);

        //This will return the launch panel
        return launchGUIInstance.createLaunchPanel();
    }

    //Method to create the login panel
    private JPanel createLogin() {

        //Make a new page object and pass this UINavigator to its constructor - essential
        LoginGUI loginGUIInstance = new LoginGUI(this);

        //Create an instance of controller
        LoginControllerImpl loginController = new LoginControllerImpl(this);

        //Set the controller to the LoginGUI
        loginGUIInstance.setController(loginController);

        //This will return the log in panel
        return loginGUIInstance.createLoginPanel();
    }

    //Method to create the signup panel
    private JPanel createSignup() {

        //Make a new page object and pass this UINavigator to its constructor - essential
        SignUpGUI signUpGUIInstance = new SignUpGUI(this);

        return signUpGUIInstance.createSignupPanel(); //This will return the signup panel
    }

    /* ----------- ADD PANEL METHODS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    private JPanel createTravelAgentLanding() {
        TravelAgentLandingPage travelAgentLandingGUIInstance = new TravelAgentLandingPage(this);
        TravelAgentControllerImpl travelAgentController = new TravelAgentControllerImpl(this);
        travelAgentLandingGUIInstance.setController(travelAgentController);
        return travelAgentLandingGUIInstance.createTravelAgentLandingPanel();
    }

    private JPanel createAdminLanding() {
        AdminLandingPage adminLandingGUIInstance = new AdminLandingPage(this);
        AdminControllerImpl adminController = new AdminControllerImpl(this);
        adminLandingGUIInstance.setController(adminController);
        return adminLandingGUIInstance.createAdminLandingPanel();
    }

    private JPanel createGuestLanding() {
        GuestLandingPage guestLandingGUIInstance = new GuestLandingPage(this);
        GuestControllerImpl guestController = new GuestControllerImpl(this);
        guestLandingGUIInstance.setController(guestController);
        return guestLandingGUIInstance.createGuestLandingPanel();
    }









    /* ----------- ADD PANEL METHODS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    //Method to show a card by its identifier --- This switches the GUI we are on ---
    public static void showCard(String identifier) {

        //Tells the card layout to show the panel with the specified identifier
        cardLayout.show(cardPanel, identifier);
    }

    public static void addCard(JPanel panel, String identifier){
        cardPanel.add(panel, identifier);
    }

    public static void goBack(){
        cardLayout.previous(cardPanel);
    }

}