package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI {

    //Frame
    private JFrame frame;

    //Labels
    private Label cruiseLinkLabel;
    private Label sailAwayToParadiseLabel;
    private Label startJourney;

    //Text fields for username and password
    private JTextField usernameField;
    private JPasswordField passwordField;

    //Buttons for log in and sign up
    private JButton loginButton;
    private JButton signUpButton; // -------- FOR GUESTS ONLY --------

    private JLabel forgotPasswordLink;

    //Making a Login controller object
    private LoginController controller;

    //LoginGUI constructor takes the Login controller and sets it
    public LoginGUI(LoginController controller) {
        this.controller = controller;
    }

    //This method creates the GUI
    public void createGUI() {

        //Initialize main frame
        frame = new JFrame("Cruise Account Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the window close when exit button clicked
        frame.setResizable(false);   //Disables resizing

        //This block allows fullscreen mode
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setAlwaysOnTop(true);
        env.getDefaultScreenDevice().setFullScreenWindow(frame); //Enables Fullscreen

        //Setting layout to Grid Bag Layout
        frame.setLayout(new GridBagLayout());

        //Initializing UI components
        cruiseLinkLabel = new Label("CruiseLink");
        cruiseLinkLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40)); //Sets the font type and size of label

        sailAwayToParadiseLabel = new Label("Sail away to paradise");
        sailAwayToParadiseLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        startJourney = new Label("Start your journey with us");
        startJourney.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        usernameField = new JTextField(20); //Makes the username text box
        passwordField = new JPasswordField(20); //Makes the password text box

        loginButton = new JButton("Login"); //Makes login button
        signUpButton = new JButton("Sign Up"); //Making the signUp button

        forgotPasswordLink = new JLabel("<HTML><U>Forgot Password?</U></HTML>"); //Styled to look like a link
        forgotPasswordLink.setForeground(Color.BLUE); //Blue link color setting for forgotpasswordlink

        //Add action listener for login button
        loginButton.addActionListener(e -> {

            //Need to Implement the callLogin operation
            System.out.println("Login button pressed");

            //Passing username and password to controller
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            //Call controller
            controller.onLoginPressed(username, password);
        });

        //Sign up button action listener
        signUpButton.addActionListener(e -> controller.onSignUpPressed());

        //Listens for mouse clicks on the forgot password link
        forgotPasswordLink.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                //Need to Implement the forgotPasswordLink operation
                System.out.println("Forgot Password link clicked");

                //Call controller
                controller.onForgotPasswordPressed();
            }
        });

        //Layout the components using GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15); //Padding for the components (buttons, labels, etc)

        //Adding labels and buttons to the frame, using y axis on grid
        constraints.gridy = 0; //0 starts at the top, etc
        frame.add(cruiseLinkLabel, constraints);

        constraints.gridy = 1;
        frame.add(sailAwayToParadiseLabel, constraints);

        constraints.gridy = 2;
        frame.add(startJourney, constraints);

        constraints.gridy = 3;
        frame.add(signUpButton, constraints);

        constraints.gridy = 4;
        frame.add(new JLabel("Username:"), constraints);
        constraints.gridy = 5;
        frame.add(usernameField, constraints);

        constraints.gridy = 6;
        frame.add(new JLabel("Password:"), constraints);
        constraints.gridy = 7;
        frame.add(passwordField, constraints);

        constraints.gridy = 8;
        frame.add(loginButton, constraints);

        constraints.gridy = 9;
        frame.add(forgotPasswordLink, constraints);

        //Instead of pack, directly set the frame to be visible
        frame.setVisible(true);
    }
}