package UI;

import Controller.SignUpControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.format.DateTimeParseException;


public class SignUpGUI extends JPanel {

    //Constant for setting the text box width
    public static final int TEXT_BOX_WIDTH = 20;

    //Labels
    private Label cruiseLinkLabel;
    private Label signUpLabel;

    //Text fields for first name, last name, email, username, age, and passwords
    private JTextField firstNameField, lastNameField, emailField, userNameField, dateOfBirthField;
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
        dateOfBirthField = new JTextField(TEXT_BOX_WIDTH);
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
            String dateOfBirth = dateOfBirthField.getText().trim();
            String email = emailField.getText().trim();
            String username = userNameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            int age = 0;

            //Need to test date of birth and convert it
            try {

                //Parse the date string into a LocalDate object
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirthObj = LocalDate.parse(dateOfBirth, formatter);

                //Calculate the age
                LocalDate currentDate = LocalDate.now();
                age = Period.between(dateOfBirthObj, currentDate).getYears();

                //Test the age
                //System.out.println("Age: " + age);

            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter the date in yyyy-MM-dd format.",
                        "Invalid Date of Birth", JOptionPane.ERROR_MESSAGE);
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
            else if (age < 18) {
                JOptionPane.showMessageDialog(this, "Must be at least 18 years of age to sign up",
                        "Age Restriction", JOptionPane.WARNING_MESSAGE);
            }
            else {

                //Creation was successful


                //Pass the Strings to the controller for account creation
                try {
                    String returnMessage = null;
                    signUpController = new SignUpControllerImpl();
                    returnMessage = signUpController.onSignUpSubmit(firstName, lastName, String.valueOf(age),
                            email, username, password, confirmPassword);
                    if(returnMessage.equals("email")){
                        JOptionPane.showMessageDialog(this, "Must select a new email",
                                "Email Taken", JOptionPane.WARNING_MESSAGE);
                    }else if(returnMessage.equals("username")){
                        JOptionPane.showMessageDialog(this, "Must select a new Username",
                                "Username Taken", JOptionPane.WARNING_MESSAGE);
                    }else if(returnMessage.equals("true")){
                        JOptionPane.showMessageDialog(this,  "Account successfully created",
                                "Account status", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Must select a new Account made",
                                "Account Saved", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //Clear the text boxes
                this.clearTextFields();

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

            //Clear the text boxes
            this.clearTextFields();

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

        //constraints.anchor = GridBagConstraints.WEST; //Make labels align to the left, will make buttons off
        constraints.gridy = 2;
        this.add(new JLabel("First Name:"), constraints);
        constraints.gridy = 3;
        this.add(firstNameField, constraints);

        constraints.gridy = 4;
        this.add(new JLabel("Last Name:"), constraints);
        constraints.gridy = 5;
        this.add(lastNameField, constraints);

        constraints.gridy = 6;
        this.add(new JLabel("Date of Birth: (yyyy-MM-dd)"), constraints);
        constraints.gridy = 7;
        this.add(dateOfBirthField, constraints);

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

    //For clearing the text fields when create account button or cancel button is selected
    private void clearTextFields() {

        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        userNameField.setText("");
        dateOfBirthField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }
}