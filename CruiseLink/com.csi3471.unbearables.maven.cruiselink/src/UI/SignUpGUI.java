package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import javax.swing.*;
import java.awt.*;

public class SignUpGUI {

    //Frame
    private JFrame frame;

    //Labels
    private Label cruiseLinkLabel;
    private Label signUpLabel;

    //Text fields for username, password, etc
    private JTextField firstNameField, lastNameField, emailField, userNameField;
    private JPasswordField passwordField, confirmPasswordField;

    //Menu bar
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem exitMenuItem;

    //Buttons
    private JButton createAccountButton;

    //This method creates a GUI for signup page
    public void createGUI() {

        //Initialize main frame
        frame = new JFrame("Cruise Account Login");
        frame.setUndecorated(true);  //This makes the GUI have no window decorations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the window close when exit button clicked
        frame.setResizable(false);   //Disables resizing

        //This block allows fullscreen mode
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setAlwaysOnTop(true);
        env.getDefaultScreenDevice().setFullScreenWindow(frame); //Enables Fullscreen

        //Setting layout to Grid Bag Layout
        frame.setLayout(new GridBagLayout());

        //Create the menu bar
        menuBar = new JMenuBar();
        menu = new JMenu("Menu"); //Call it menu
        exitMenuItem = new JMenuItem("Exit Program"); //Make an exit option
        exitMenuItem.addActionListener(e -> System.exit(0)); //Close the application when Exit Program is clicked
        menu.add(exitMenuItem); //Adding the exit menu
        menuBar.add(menu); //Adding the menu to the bar
        frame.setJMenuBar(menuBar); //Adding the menu bar to the frame

        //Initializing UI components
        cruiseLinkLabel = new Label("CruiseLink");
        cruiseLinkLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40)); //Sets the font type and size of label

        signUpLabel = new Label("Sign Up");
        signUpLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        //Text fields
        firstNameField = new JTextField(20); //Makes the first name text box
        lastNameField = new JTextField(20); //Makes the last name box
        emailField = new JTextField(20);
        userNameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        //Creating create account button
        createAccountButton = new JButton("Create Account"); //Makes create account button

        //Add action listener for create account button
        createAccountButton.addActionListener(e -> {

            System.out.println("Create Account button pressed");

            //Gathering the strings from the text fields when create account button pressed
            String firstName = firstNameField.getText().trim(); //Must use getText()
            String lastName = lastNameField.getText().trim();
            String email = emailField.getText().trim();
            String username = userNameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            //For testing, print them to the console --------- works ---------
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Confirm Password: " + confirmPassword);


            //Will need to pass this information to program logic
            //Should test to see if username and password are valid or taken already
            //guestInfoExpert guestInfoExpertObj = new guestInfoExpert();

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
        frame.add(new JLabel("Email:"), constraints);
        constraints.gridy = 7;
        frame.add(emailField, constraints);

        constraints.gridy = 8;
        frame.add(new JLabel("Username:"), constraints);
        constraints.gridy = 9;
        frame.add(userNameField, constraints);

        constraints.gridy = 10;
        frame.add(new JLabel("Password:"), constraints);
        constraints.gridy = 11;
        frame.add(passwordField, constraints);

        constraints.gridy = 12;
        frame.add(new JLabel("Confirm Password:"), constraints);
        constraints.gridy = 13;
        frame.add(confirmPasswordField, constraints);

        constraints.gridy = 14;
        frame.add(createAccountButton, constraints);

        frame.setVisible(true);
    }
}