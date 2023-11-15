package UI;

import javax.swing.*;
import java.awt.*;

public class ProfilePageUI {
    public static final int TEXT_BOX_WIDTH = 20;

    private static JFrame frame;
    private static JPanel information, picture;
    private static JLabel label, name, username, password, dob, email;
    private static ImageIcon profPic;
    private static Image image;
    private static JTextField uName, uUsername, uPassword, uDOB, uEmail;

    private static Font defaultFont = new Font("Serif", Font.PLAIN, 16);
    private static Font defaultHeader = new Font("Serif", Font.ITALIC, 20);

    //this is a hardcoded WIP
    public static void createGUI() {
        // init frame and panels
        frame = new JFrame("CruiseLink Application");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        information = new JPanel();
        picture = new JPanel();

        // adding profile picture to top, right side of frame
        profPic = new ImageIcon("CareBEARProfile.png");
        image = profPic.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        profPic = new ImageIcon(image);
        label = new JLabel(profPic);
        label.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
        picture.add(label);

        // set up info layout
        information.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.gridy = 0;

        // adding name
        name = new JLabel("Name:");
        name.setFont(defaultFont);
        ++constraints.gridy;
        information.add(name, constraints);
        uName = new JTextField(TEXT_BOX_WIDTH);
        uName.setFont(defaultFont);
        information.add(uName, constraints);

        // add DOB
        dob = new JLabel("Date of Birth:");
        dob.setFont(defaultFont);
        ++constraints.gridy;
        information.add(dob, constraints);
        uDOB = new JTextField(TEXT_BOX_WIDTH);
        uDOB.setFont(defaultFont);
        information.add(uDOB, constraints);

        // add email
        email = new JLabel("Email:");
        email.setFont(defaultFont);
        ++constraints.gridy;
        information.add(email, constraints);
        uEmail = new JTextField(TEXT_BOX_WIDTH);
        uEmail.setFont(defaultFont);
        information.add(uEmail, constraints);

        // add username
        username = new JLabel("Username:");
        username.setFont(defaultFont);
        ++constraints.gridy;
        information.add(username, constraints);
        uUsername = new JTextField(TEXT_BOX_WIDTH);
        uUsername.setFont(defaultFont);
        information.add(uUsername, constraints);

        // add password
        password = new JLabel("Password:");
        password.setFont(defaultFont);
        ++constraints.gridy;
        information.add(password, constraints);
        uPassword = new JTextField(TEXT_BOX_WIDTH);
        uPassword.setFont(defaultFont);
        information.add(uPassword, constraints);

        // organize panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(picture);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        mainPanel.add(information);

        // make frame visible
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}
