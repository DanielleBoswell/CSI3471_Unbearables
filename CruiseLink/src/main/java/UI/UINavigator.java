package UI;

import Controller.*;
import Domain.Agent;
import Domain.Guest;

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
    public static final String TRAVEL_AGENT_BILLING_PANEL = "Travel Agent Billing Panel";
    public static final String TRAVEL_AGENT_MODIFY_ROOM_PANEL = "Travel Agent Modify Room Panel";
    public static final String SIGNUP_PANEL = "Sign Up Panel";


    /* ----------- ADD IDENTIFIERS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    //Example: public static final String TEST_PANEL = "Test Panel";

    public static final String TRAVEL_AGENT_LANDING_PANEL = "Travel Agent Landing Panel";
    public static final String ADMIN_LANDING_PANEL = "Admin Landing Panel";
    public static final String GUEST_LANDING_PANEL = "Guest Landing Panel";
    public static final String CHOOSE_ROOM_PANEL = "Choose Room Panel";
    public static final String CHOOSE_CRUISE_PANEL = "Choose Cruise Panel";
    public static final String CHOOSE_GUEST_PANEL = "Choose Guest Panel";

    public static final String GUEST_PROFILE_PAGE = "Guest Profile Page";
    public static final String AGENT_PROFILE_PAGE = "Agent Profile Page";

    public static final String CHECK_IN_PANEL = "Check In Panel";
    public static final String ADD_ROOM_PANEL = "Add Room Panel";

    public static final String VIEW_GUEST_RESERVATIONS = "View Guest Reservations";
    public static final String RESERVATION_VIEW = "View Guest Reservation";

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
        cardPanel.add(createTravelAgentBilling(), TRAVEL_AGENT_BILLING_PANEL);
        cardPanel.add(createTravelAgentModifyRoom(),TRAVEL_AGENT_MODIFY_ROOM_PANEL);


        /* ----------- ADD PANELS HERE FOR EACH GUI PAGE ----------- */

        //Example: cardPanel.add(createTest(), TEST_PANEL);

        cardPanel.add(createTravelAgentLanding(), TRAVEL_AGENT_LANDING_PANEL);
        cardPanel.add(createAdminLanding(), ADMIN_LANDING_PANEL);
        cardPanel.add(createGuestLanding(), GUEST_LANDING_PANEL);
        cardPanel.add(createChooseRoom(), CHOOSE_ROOM_PANEL);
        cardPanel.add(createChooseCruise(), CHOOSE_CRUISE_PANEL);
        cardPanel.add(createChooseGuest(), CHOOSE_GUEST_PANEL);

        cardPanel.add(createGuestProfilePage(), GUEST_PROFILE_PAGE);
        cardPanel.add(createAgentProfilePage(), AGENT_PROFILE_PAGE);
        cardPanel.add(createCheckIn(), CHECK_IN_PANEL);
        cardPanel.add(createAddRoom(), ADD_ROOM_PANEL);

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
    private JPanel createChooseRoom() {
        CreateReservation_ChooseRoom x = new CreateReservation_ChooseRoom(this);
        return x.CreateReservation_ChooseRoom_creator();
    }
    private JPanel createChooseCruise() {
        CreateReservation_ChooseCruise x = new CreateReservation_ChooseCruise(this);
        return x.CreateReservation_ChooseCruise_creator();
    }
    private JPanel createChooseGuest() {
        CreateReservation_ChooseGuest x = new CreateReservation_ChooseGuest(this);
        return x.CreateReservation_ChooseGuest_creator();
    }

    private JPanel createTravelAgentBilling() {
        TravelAgentGenerateBillGUI travelAgentGenerateBillGUIInstance = new TravelAgentGenerateBillGUI(this);
        TravelAgentControllerImpl agentController = new TravelAgentControllerImpl(this);
        travelAgentGenerateBillGUIInstance.setController(agentController);
        return travelAgentGenerateBillGUIInstance.createTravelAgentBilling();
    }

    private JPanel createTravelAgentModifyRoom() {
        TravelAgentModifyRoomGUI travelAgentModifyRoomGUIInstance = new TravelAgentModifyRoomGUI(this);
        TravelAgentControllerImpl agentController = new TravelAgentControllerImpl(this);
        travelAgentModifyRoomGUIInstance.setController(agentController);
        return travelAgentModifyRoomGUIInstance.createTravelAgentModifyRoom();
    }

    private JPanel createGuestProfilePage() {
        GuestProfilePageUI profilePageGUIInstance = new GuestProfilePageUI(this);
        ProfileControllerImpl profileController= new ProfileControllerImpl(this);
        profilePageGUIInstance.setController(profileController);
        return profilePageGUIInstance.createGuestProfilePagePanel();
    }

    private JPanel createAgentProfilePage() {
        AgentProfilePageUI profilePageGUIInstance = new AgentProfilePageUI(this);
        ProfileControllerImpl profileController= new ProfileControllerImpl(this);
        profilePageGUIInstance.setController(profileController);
        return profilePageGUIInstance.createAgentProfilePagePanel();
    }

    private JPanel createCheckIn() {
        CheckInUI checkInUIInstance = new CheckInUI(this);
        CheckInControllerImpl checkInController = new CheckInControllerImpl(this);
        checkInUIInstance.setController(checkInController);
        return checkInUIInstance.createCheckInUIPanel();
    }

    private JPanel createAddRoom() {
        AddRoomGUI addRoomGUIInstance = new AddRoomGUI(this);
        AddRoomControllerImpl addRoomController = new AddRoomControllerImpl(this);
        addRoomGUIInstance.setController(addRoomController);
        return addRoomGUIInstance.createAddRoomUIPanel();
    }

    /* ----------- ADD PANEL METHODS HERE FOR EACH GUI PAGE LIKE ABOVE ----------- */

    //Method to show a card by its identifier --- This switches the GUI we are on ---
    public static void showCard(String identifier) {

        //Tells the card layout to show the panel with the specified identifier
        cardLayout.show(cardPanel, identifier);
    }

    public static void addCard(JPanel panel, String identifier){
        cardPanel.add(panel, identifier);}

    public static void goBack(){
        cardLayout.previous(cardPanel);
    }

}