package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.LoginController;
import Cruiselink.maven.cruiselink.src.Controller.LoginControllerImpl;
import Cruiselink.maven.cruiselink.src.Controller.SignUpController;

import javax.swing.*;
import java.awt.*;

public class SignUpGUI {

    private SignUpController controller;

    public SignUpGUI(SignUpController controller) {
        this.controller = controller;
    }

    //Frame
    private JFrame frame;

    //Labels
    private Label cruiseLinkLabel;
    private Label signUpLabel;

    //Text fields for first name, last name, email, username, age, and passwords
    private JTextField firstNameField, lastNameField, emailField, userNameField, ageField;
    private JPasswordField passwordField, confirmPasswordField;

    //Buttons for create account and cancel
    private JButton createAccountButton, cancelButton;

    //This method creates a GUI for signup page
    public void createGUI() {

        //Initialize main frame
        frame = new JFrame("Cruise Account Creation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        signUpLabel = new Label("Sign Up");
        signUpLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        //Text fields
        firstNameField = new JTextField(20); //Makes the first name text box
        lastNameField = new JTextField(24); //Makes the last name box
        ageField = new JTextField(24);
        emailField = new JTextField(24);
        userNameField = new JTextField(24);
        passwordField = new JPasswordField(24);
        confirmPasswordField = new JPasswordField(24);

        //Creating create account button and cancel button
        createAccountButton = new JButton("Create Account");
        cancelButton = new JButton("Cancel");

        //Setting width and height of create account and cancel up buttons to be the same as the text fields
        createAccountButton.setPreferredSize(new Dimension(firstNameField.getPreferredSize().width, createAccountButton.getPreferredSize().height));
        cancelButton.setPreferredSize(new Dimension(firstNameField.getPreferredSize().width, cancelButton.getPreferredSize().height));

        //Add action listener for create account button
        createAccountButton.addActionListener(e -> {

            //System.out.println("Create Account button pressed");

            //Gathering the strings from the text fields when create account button pressed
            String firstName = firstNameField.getText().trim(); //Must use getText()
            String lastName = lastNameField.getText().trim();
            String age = ageField.getText().trim();
            String email = emailField.getText().trim();
            String username = userNameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            //Need to test age and convert it
            boolean ageIsOnlyDigits = isOnlyDigits(age);
            int convertedAge = 0;

            if (ageIsOnlyDigits) {
                try {
                    convertedAge = Integer.parseInt(age);
                } catch (Exception issue) {
                    System.out.println("Converting issue with age");
                }
            }

            //Need to check for valid entries into text fields ---------- Will need to add username and email verification (through database) ----------
            if (!isOnlyLetters(firstName)) {
                JOptionPane.showMessageDialog(frame, "Must contain only letters A-Z", "Invalid first name", JOptionPane.WARNING_MESSAGE);
            }
            else if (!isOnlyLetters(lastName)) {
                JOptionPane.showMessageDialog(frame, "Must contain only letters A-Z", "Invalid last name", JOptionPane.WARNING_MESSAGE);
            }
            else if (!ageIsOnlyDigits) {
                JOptionPane.showMessageDialog(frame, "Age must be digits only", "Invalid age input", JOptionPane.WARNING_MESSAGE);
            }
            else if (convertedAge < 18) {
                JOptionPane.showMessageDialog(frame, "Must be at least 18 years of age to sign up", "Age Restriction", JOptionPane.WARNING_MESSAGE);
            }
            else {

                //Creation was successful
                JOptionPane.showMessageDialog(frame,  "Account successfully created", "Account status", JOptionPane.INFORMATION_MESSAGE);

                //Pass the Strings to the controller for account creation
                controller.onSignUpSubmit(firstName, lastName, age, email, username, password, confirmPassword);

                //Return back to log in screen
                returnToLoginScreen();
            }
        });

        //This is for the cancel button to go back to the login page
        cancelButton.addActionListener(e1 -> {

            //System.out.println("Cancel button Hit");

            JOptionPane.showMessageDialog(frame, "Returning to login page", "Sign up canceled", JOptionPane.ERROR_MESSAGE);

            returnToLoginScreen();
        });

        //Layout the components using GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 5, 15); //Padding (spacing) for the components (buttons, labels, etc)

        //Adding labels and buttons to the frame
        constraints.gridy = 0; //stands for grid for the y axis - 0 will be at the top
        frame.add(cruiseLinkLabel, constraints);
        constraints.gridy = 1;
        frame.add(signUpLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST; //Make labels align to the left
        constraints.gridy = 2;
        frame.add(new JLabel("First Name:"), constraints);
        constraints.gridy = 3;
        frame.add(firstNameField, constraints);

        constraints.gridy = 4;
        frame.add(new JLabel("Last Name:"), constraints);
        constraints.gridy = 5;
        frame.add(lastNameField, constraints);

        constraints.gridy = 6;
        frame.add(new JLabel("Age:"), constraints);
        constraints.gridy = 7;
        frame.add(ageField, constraints);

        constraints.gridy = 8;
        frame.add(new JLabel("Email:"), constraints);
        constraints.gridy = 9;
        frame.add(emailField, constraints);

        constraints.gridy = 10;
        frame.add(new JLabel("Username:"), constraints);
        constraints.gridy = 11;
        frame.add(userNameField, constraints);

        constraints.gridy = 12;
        frame.add(new JLabel("Password:"), constraints);
        constraints.gridy = 13;
        frame.add(passwordField, constraints);

        constraints.gridy = 14;
        frame.add(new JLabel("Confirm Password:"), constraints);
        constraints.gridy = 15;
        frame.add(confirmPasswordField, constraints);

        constraints.gridy = 16;
        frame.add(createAccountButton, constraints);

        constraints.gridy = 17;
        cancelButton.setForeground(Color.RED);
        frame.add(cancelButton, constraints);

        frame.setVisible(true);
    }

    //For testing if a string has only digits (0-9)
    public static boolean isOnlyDigits (String myString){

        return myString.matches("\\d+");
    }

    //For testing if a string has only letters a-z (upper and lower)
    public static boolean isOnlyLetters (String myString){

        return myString.matches("[a-zA-Z]+");
    }

    //For going back to login page
    private void returnToLoginScreen() {
        SwingUtilities.invokeLater(() -> {
            LoginController controller = new LoginControllerImpl();
            LoginGUI loginGUI = new LoginGUI(controller);
            loginGUI.createGUI();
        });
    }
}