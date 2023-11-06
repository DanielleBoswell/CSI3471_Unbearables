package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.LoginControllerImpl;

import java.awt.*;
import javax.swing.*;

public class UINavigator extends JFrame {

    //Declaring a CardLayout to manage navigation of panels (GUIs)
    private static CardLayout cardLayout = null;

    //Declaring a JPanel that will hold the different cards (panels)
    private static JPanel cardPanel = null;

    //Constant identifiers for our panels --- Add one for each page in software, or can add using addCard() ---
    public static final String LAUNCH_PANEL = "Launch Panel";
    public static final String LOGIN_PANEL = "Login Panel";
    public static final String SIGNUP_PANEL = "Sign Up Panel";







    //Main frame for our software (Main window)
    private JFrame frame;

    //Constructor for UINavigator class
    public UINavigator() {

        //Creating a new JFrame with the title CruiseLink
        frame = new JFrame("CruiseLink");

        //Setting the default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initializing the CardLayout
        cardLayout = new CardLayout();

        //Initializing the cardPanel with the CardLayout
        cardPanel = new JPanel(cardLayout);

        //Add the cards (panels) to the cardPanel with the respective identifiers
        // --- This is where we add the panels to the main frame (panels = pages in software) ---
        //or can add dynamically using addCard()
        cardPanel.add(createLaunchPanel(), LAUNCH_PANEL);
        cardPanel.add(createLoginPanel(), LOGIN_PANEL);
        cardPanel.add(createSignupPanel(), SIGNUP_PANEL);






        //Add the main panel to the frame in the center
        frame.add(cardPanel, BorderLayout.CENTER);

        //Maximize the frame (fullscreen)
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Make the frame visible after all components have been added
        frame.setVisible(true);
    }

    //Method to create the launch panel
    private JPanel createLaunchPanel() {

        LaunchGUI launchGUIInstance = new LaunchGUI(this);

        //This will return the launch panel
        return launchGUIInstance.createLaunchPanel();
    }

    //Method to create the login panel
    private JPanel createLoginPanel() {

        LoginGUI loginGUIInstance = new LoginGUI(this);

        //Create an instance of controller
        LoginControllerImpl loginController = new LoginControllerImpl(this);

        //Set the controller to the LoginGUI
        loginGUIInstance.setController(loginController);

        //This will return the log in panel
        return loginGUIInstance.createLoginPanel();
    }

    //Method to create the signup panel
    private JPanel createSignupPanel() {
        SignUpGUI signUpGUIInstance = new SignUpGUI(this);
        return signUpGUIInstance.createSignupPanel(); //This will return the signup panel
    }

    //Method to add a new card to the cardPanel dynamically
    public void addCard(JPanel card, String identifier) {
        //Adds a new panel with a given identifier to the card layout
        cardPanel.add(card, identifier);
    }

    //Method to show a card by its identifier --- This switches the GUI we are on ---
    public static void showCard(String identifier) {
        //Tells the card layout to show the panel with the specified identifier
        cardLayout.show(cardPanel, identifier);
    }
}