package UI;

import Controller.ProfileControllerImpl;
import Domain.Person;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * This class contains the code for the travel agent's profile page.
 * It uses the profile controller to actually function.
 * @author Emma
 */
public class AgentProfilePageUI {
    /**
     * This is the standard width of the text boxes used.
     */
    public static final int TEXT_BOX_WIDTH = 20;

    /**
     * This is the user whose information should be displayed.
     */
    private static Person user;
    /**
     * These are the various panels used to organize the UI components.
     */
    private static JPanel information, picture, buttons;
    /**
     * These are the labels used in the UI.
     */
    private static JLabel label, name, username, newPassword, oldPassword, dob,
            email, uUsername, uOldPassword, backslash;
    /**
     * This is the user's profile picture. Used to resize the image.
     */
    private static ImageIcon profPic;
    /**
     * This is used to actually apply the image to the UI.
     */
    private static Image image;
    /**
     * These are the text fields used to show user data, and they are editable.
     */
    private static JTextField uName, year, uEmail, day, month;
    /**
     * This is used to hide the new password being entered.
     */
    private static JPasswordField uPassword;

    /**
     * These are the buttons that save the changes or return to the travel
     * agent's landing page.
     */
    private static JButton confirm, cancel;

    /**
     * This is the default font and size used for much of the text components.
     */
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 16);

    /**
     * This is the controller to be used to connect functionality.
      */
    private static ProfileControllerImpl profileController;

    /**
     * This initializes the controller for the travel agent profile page.
     * @param profileController
     */
    public void setController(ProfileControllerImpl profileController) {
        this.profileController = profileController;
    }

    /**
     * This is the UI navigator used to switch between pages.
     */
    private static UINavigator UINavigator;

    /**
     * This initializes the Ui navigator to be used when switching pages.
     * @param UINavigator
     */
    public AgentProfilePageUI(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    /**
     * This defines the functionality of the confirm and cancel buttons.
     * It uses the profile controller.
     */
    public static void AgentFunctionality() {
        cancel.addActionListener(e -> profileController.returnToAgentLandingPage());
        confirm.addActionListener(e -> profileController.alterAgentInformation());
    }

    //this is a hardcoded WIP
    public static JPanel createAgentProfilePagePanel() {
        // for testing purposes
        // TODO: find way to get the agent's info for this part
        user = new Person();
        user.setName("Bob Johnson");
        user.setUsername("bobJ");
        user.setAge(34);
        user.setEmail("bob.johnson@gmail.com");
        user.setPassword("bob2");
        Date d = new Date(1989,11,04);

        // init picture
        information = new JPanel();
        buttons = new JPanel();
        picture = new JPanel();

        // adding profile picture to top, right side of frame
        profPic = new ImageIcon("CareBEARProfile.png");
        image = profPic.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        profPic = new ImageIcon(image);
        label = new JLabel(profPic);
        label.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        picture.add(label);

        // set up info layout for information
        information.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 5, 15, 5);
        constraints.gridy = 0;

        // adding name
        name = new JLabel("Name:");
        name.setFont(defaultFont);
        ++constraints.gridy;
        information.add(name, constraints);
        uName = new JTextField(TEXT_BOX_WIDTH);
        uName.setText(user.getName());
        uName.setFont(defaultFont);
        information.add(uName, constraints);

        // add DOB
        // day, month, and year are individual text fields
        JPanel dobPanel = new JPanel();
        dob = new JLabel("Date of Birth (dd/MM/yyyy):");
        dob.setFont(defaultFont);
        ++constraints.gridy;
        information.add(dob, constraints);
        backslash = new JLabel("/");
        backslash.setFont(defaultFont);

        JLabel backslash2 = new JLabel("/");
        backslash2.setFont(defaultFont);

        day = new JTextField(4);
        day.setFont(defaultFont);
        day.setText(String.valueOf(d.getDay()));
        dobPanel.add(day);
        dobPanel.add(backslash);

        month = new JTextField(4);
        month.setFont(defaultFont);
        month.setText(String.valueOf(d.getMonth()));
        dobPanel.add(month);
        dobPanel.add(backslash2);

        year = new JTextField(4);
        year.setFont(defaultFont);
        year.setText(String.valueOf(d.getYear()));
        dobPanel.add(year);
        information.add(dobPanel, constraints);

        // add email
        email = new JLabel("Email:");
        email.setFont(defaultFont);
        ++constraints.gridy;
        information.add(email, constraints);
        uEmail = new JTextField(TEXT_BOX_WIDTH);
        uEmail.setText(user.getEmail());
        uEmail.setFont(defaultFont);
        information.add(uEmail, constraints);

        // add username
        username = new JLabel("Username:");
        username.setFont(defaultFont);
        ++constraints.gridy;
        information.add(username, constraints);
        uUsername = new JLabel(user.getUsername());
        uUsername.setFont(defaultFont);
        information.add(uUsername, constraints);

        // add current password
        oldPassword = new JLabel("Current Password:");
        oldPassword.setFont(defaultFont);
        ++constraints.gridy;
        information.add(oldPassword, constraints);
        uOldPassword = new JLabel(user.getPassword());
        uOldPassword.setFont(defaultFont);
        information.add(uOldPassword, constraints);

        // add box for new password
        // should we allow this to be empty, or must it filled
        // (even with current password if not changing)
        newPassword = new JLabel("New Password:");
        newPassword.setFont(defaultFont);
        ++constraints.gridy;
        information.add(newPassword, constraints);
        uPassword = new JPasswordField(TEXT_BOX_WIDTH);
        uPassword.setFont(defaultFont);
        information.add(uPassword, constraints);

        // add confirm and cancel buttons
        confirm = new JButton("confirm");
        confirm.setFont(defaultFont);
        cancel = new JButton("cancel");
        cancel.setFont(defaultFont);
        cancel.setForeground(Color.RED);
        buttons.add(cancel);
        buttons.add(confirm);

        // organize panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(picture);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        mainPanel.add(information);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        mainPanel.add(buttons);

        // action listeners for the buttons
        AgentFunctionality();

        return mainPanel;
    }
}
