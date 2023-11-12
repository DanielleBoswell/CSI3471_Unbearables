package UI;

import Controller.LoginControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI extends JPanel {

    //Constant for setting the text box width
    public static final int TEXT_BOX_WIDTH = 25;

    //Labels
    private Label cruiseLinkLabel;
    private Label sailAwayToParadiseLabel;
    private Label startJourney;

    //Text fields for username and password
    private JTextField usernameField;
    private JPasswordField passwordField;

    //Buttons for log in and sign up
    private JButton loginButton;
    private JButton signUpButton;  // -------- FOR GUESTS ONLY --------

    private JLabel forgotPasswordLink;

    //Making a Login controller impl object
    private LoginControllerImpl loginController;

    //Sets the controller
    public void setController(LoginControllerImpl loginController) {
        this.loginController = loginController;
    }

    //Making a UINavigator instance for login
    private UINavigator uiNavigator;

    //Constructor accepting UINavigator instance - Need this for switching panels
    public LoginGUI(UINavigator uiNavigator) {

        this.uiNavigator = uiNavigator;
    }

    //This method creates the login GUI, will return the panel
    public JPanel createLoginPanel() {

        //Setting layout to GridBagLayout
        this.setLayout(new GridBagLayout());

        //Initializing UI components
        cruiseLinkLabel = new Label("CruiseLink");
        cruiseLinkLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        sailAwayToParadiseLabel = new Label("Sail away to paradise");
        sailAwayToParadiseLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        startJourney = new Label("Start your journey with us");
        startJourney.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        usernameField = new JTextField(TEXT_BOX_WIDTH);
        passwordField = new JPasswordField(TEXT_BOX_WIDTH);

        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        //Set the buttons to the same width as the text fields and also a preferred height. ------------ Makes the buttons centered ------------
        Dimension textFieldSize = usernameField.getPreferredSize(); //Use the preferred size of the username field for reference
        loginButton.setMaximumSize(new Dimension(textFieldSize.width, loginButton.getPreferredSize().height));
        signUpButton.setMaximumSize(new Dimension(textFieldSize.width, signUpButton.getPreferredSize().height));

        forgotPasswordLink = new JLabel("<HTML><U>Forgot Password?</U></HTML>");
        forgotPasswordLink.setForeground(Color.BLUE);

        //Add action listener for login button
        loginButton.addActionListener(e -> {

            //Gathering the username and password
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            //Pass to controller
            loginController.onLoginPressed(username, password);
        });

        //Sign up button action listener
        signUpButton.addActionListener(e -> {

            //Call sign up through controller
            if (loginController != null) {
                loginController.onSignUpPressed();
            }
        });

        //Listens for mouse clicks on the forgot password link
        forgotPasswordLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                //Prompt for user's email
                String email = JOptionPane.showInputDialog(
                        LoginGUI.this, //This refers to the outer class instance
                        "Enter your email for password reset:",
                        "Forgot Password",
                        JOptionPane.QUESTION_MESSAGE
                );

                //Check if the input was canceled
                if (email == null) {

                    //User canceled the operation
                    JOptionPane.showMessageDialog(
                            LoginGUI.this,
                            "Password reset canceled",
                            "Canceled",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
                else if (email.isEmpty()) {

                    //No input entered, show try again message
                    JOptionPane.showMessageDialog(
                            LoginGUI.this,
                            "Try again, nothing was entered",
                            "No Input",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                else if (!email.isEmpty()) {

                    //Handle the input email here
                    //loginController.onForgotPasswordPressed(email); ------ This is where I would check the
                    //database for the email in the system ------

                    //Display a message saying the reset link has been sent
                    JOptionPane.showMessageDialog(
                            LoginGUI.this,
                            "Your reset link has been sent",
                            "Email Sent",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        //Layout the components using GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); //Padding for the components

        //Center alignment for components
        constraints.anchor = GridBagConstraints.CENTER;

        //Layout the usernameField with the constraints set to fill horizontally
        constraints.gridx = 0;
        constraints.gridy++;
        this.add(usernameField, constraints);

        //Layout the passwordField with the same constraints
        constraints.gridy++;
        this.add(passwordField, constraints);

        //To make sure the components don't stretch horizontally, set fill to NONE
        constraints.fill = GridBagConstraints.NONE;

        //Set weightx and weighty to 0 to prevent components from filling the entire space
        constraints.weightx = 0;
        constraints.weighty = 0;

        //Layout the components in the center
        constraints.gridx = 0; //Set the single column to 0 to center it
        constraints.gridy = 0;
        this.add(cruiseLinkLabel, constraints);

        constraints.gridy++;
        this.add(sailAwayToParadiseLabel, constraints);

        constraints.gridy++;

        //Create labels for the username and password fields
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        //Wrap the username and password fields in their own JPanel to prevent stretching
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS)); //Use BoxLayout for vertical stacking

        inputPanel.add(usernameLabel);

        inputPanel.add(usernameField);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 30))); //This adds a small space between the fields

        inputPanel.add(passwordLabel);

        inputPanel.add(passwordField);
        constraints.gridy++; //Increment gridy to move down in the layout
        this.add(inputPanel, constraints); //Add the input panel to the main panel

        //Place the buttons in their own JPanel
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        buttonPanel.add(loginButton);

        //Add an area for spacing between the login and sign up buttons
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        buttonPanel.add(signUpButton);

        //Aligning the panel itself to the center of its grid cell
        constraints.fill = GridBagConstraints.VERTICAL; //Allows the buttons to fill vertically
        constraints.anchor = GridBagConstraints.CENTER; //Center the panel in the cell

        //Add vertical glue to push the button panel down
        constraints.gridy++;
        this.add(Box.createVerticalGlue(), constraints);

        constraints.gridy++; //Increment gridy to move down in the layout
        this.add(buttonPanel, constraints); //Add the button panel to the main panel

        //Putting the link in its own panel
        JPanel linkPanel = new JPanel();
        linkPanel.add(forgotPasswordLink);
        constraints.gridy++; //Increment gridy to move down in the layout
        this.add(linkPanel, constraints); //Add the link panel to the main panel

        //Returning the JPanel
        return this;
    }
}