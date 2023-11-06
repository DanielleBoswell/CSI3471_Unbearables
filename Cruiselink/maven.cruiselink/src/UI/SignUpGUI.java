package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.SignUpControllerImpl;

import javax.swing.*;
import java.awt.*;

public class SignUpGUI extends JPanel {

    //Constant for setting the text box width
    public static final int TEXT_BOX_WIDTH = 20;

    //Labels
    private Label cruiseLinkLabel;
    private Label signUpLabel;

    //Text fields for first name, last name, email, username, age, and passwords
    private JTextField firstNameField, lastNameField, emailField, userNameField, ageField;
    private JPasswordField passwordField, confirmPasswordField;

    //Buttons for create account and cancel
    private JButton createAccountButton, cancelButton;

    private SignUpControllerImpl signUpController;

    //Sets the controller
    public void setController(SignUpControllerImpl signUpController) {
        this.signUpController = signUpController;
    }

    //Declare instance of UINavigator to manage navigation in the UI
    private UINavigator UINavigator;

    //Constructor accepting UINavigator instance  - Need this for switching panels
    public SignUpGUI(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    public JPanel createSignupPanel() {

        //Setting layout to Grid Bag Layout
        this.setLayout(new GridBagLayout());

        //Initializing UI components
        cruiseLinkLabel = new Label("CruiseLink");
        cruiseLinkLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40)); //Sets the font type and size of label

        signUpLabel = new Label("Sign Up");
        signUpLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        //Text fields
        firstNameField = new JTextField(TEXT_BOX_WIDTH); //Makes the first name text box
        lastNameField = new JTextField(TEXT_BOX_WIDTH); //Makes the last name box
        ageField = new JTextField(TEXT_BOX_WIDTH);
        emailField = new JTextField(TEXT_BOX_WIDTH);
        userNameField = new JTextField(TEXT_BOX_WIDTH);
        passwordField = new JPasswordField(TEXT_BOX_WIDTH);
        confirmPasswordField = new JPasswordField(TEXT_BOX_WIDTH);

        //Creating create account button and cancel button
        createAccountButton = new JButton("Create Account");
        cancelButton = new JButton("Cancel");

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

            //Need to check for valid entries into text fields
            // ---------- Will need to add username and email verification (through database) ----------
            if (!isOnlyLetters(firstName)) {
                JOptionPane.showMessageDialog(this, "Must contain only letters A-Z",
                        "Invalid first name", JOptionPane.WARNING_MESSAGE);
            }
            else if (!isOnlyLetters(lastName)) {
                JOptionPane.showMessageDialog(this, "Must contain only letters A-Z",
                        "Invalid last name", JOptionPane.WARNING_MESSAGE);
            }
            else if (!ageIsOnlyDigits) {
                JOptionPane.showMessageDialog(this, "Age must be digits only",
                        "Invalid age input", JOptionPane.WARNING_MESSAGE);
            }
            else if (convertedAge < 18) {
                JOptionPane.showMessageDialog(this, "Must be at least 18 years of age to sign up",
                        "Age Restriction", JOptionPane.WARNING_MESSAGE);
            }
            else {

                //Creation was successful
                JOptionPane.showMessageDialog(this,  "Account successfully created",
                        "Account status", JOptionPane.INFORMATION_MESSAGE);

                //Pass the Strings to the controller for account creation
                //signUpController.onSignUpSubmit(firstName, lastName, age, email, username, password, confirmPassword);

                //Return back to log in screen
                UINavigator.showCard(UINavigator.LOGIN_PANEL);
            }
        });

        //This is for the cancel button to go back to the login page after being clicked
        cancelButton.addActionListener(e1 -> {

            //System.out.println("Cancel button Hit");

            //Display window to user about cancellation
            JOptionPane.showMessageDialog(this, "Returning to login page",
                    "Sign up canceled", JOptionPane.ERROR_MESSAGE);

            //Return back to log in screen
            UINavigator.showCard(UINavigator.LOGIN_PANEL);
        });

        //Layout the components using GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        //Padding (spacing) for the components (buttons, labels, etc)
        constraints.insets = new Insets(15, 15, 5, 15);

        //Adding labels and buttons to the frame
        constraints.gridy = 0; //Stands for grid for the y axis - 0 will be at the top
        this.add(cruiseLinkLabel, constraints);
        constraints.gridy = 1;
        this.add(signUpLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST; //Make labels align to the left
        constraints.gridy = 2;
        this.add(new JLabel("First Name:"), constraints);
        constraints.gridy = 3;
        this.add(firstNameField, constraints);

        constraints.gridy = 4;
        this.add(new JLabel("Last Name:"), constraints);
        constraints.gridy = 5;
        this.add(lastNameField, constraints);

        constraints.gridy = 6;
        this.add(new JLabel("Age:"), constraints);
        constraints.gridy = 7;
        this.add(ageField, constraints);

        constraints.gridy = 8;
        this.add(new JLabel("Email:"), constraints);
        constraints.gridy = 9;
        this.add(emailField, constraints);

        constraints.gridy = 10;
        this.add(new JLabel("Username:"), constraints);
        constraints.gridy = 11;
        this.add(userNameField, constraints);

        constraints.gridy = 12;
        this.add(new JLabel("Password:"), constraints);
        constraints.gridy = 13;
        this.add(passwordField, constraints);

        constraints.gridy = 14;
        this.add(new JLabel("Confirm Password:"), constraints);
        constraints.gridy = 15;
        this.add(confirmPasswordField, constraints);

        constraints.gridy = 16;
        this.add(createAccountButton, constraints);

        constraints.gridy = 17;
        cancelButton.setForeground(Color.RED);
        this.add(cancelButton, constraints);

        this.setVisible(true);

        //Return the panel
        return this;
    }

    //For testing if a string has only digits (0-9)
    public static boolean isOnlyDigits (String myString){

        return myString.matches("\\d+");
    }

    //For testing if a string has only letters a-z (upper and lower)
    public static boolean isOnlyLetters (String myString){

        return myString.matches("[a-zA-Z]+");
    }
}