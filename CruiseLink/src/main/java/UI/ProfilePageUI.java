// Author: Emma Aars
package UI;

import Domain.Person;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ProfilePageUI {
    public static final int TEXT_BOX_WIDTH = 20;

    private static Person user;
    private static JFrame frame;
    private static JPanel information, picture;
    private static JLabel label, name, username, newPassword, oldPassword, dob,
            email, uUsername, uOldPassword, backslash;
    private static ImageIcon profPic;
    private static Image image;
    private static JTextField uName, year, uEmail, day, month;
    private static JPasswordField uPassword;

    private static Font defaultFont = new Font("Serif", Font.PLAIN, 16);
    private static Font defaultHeader = new Font("Serif", Font.ITALIC, 20);

    //this is a hardcoded WIP
    public static void createGUI() {
        // for testing purposes
        user = new Person();
        user.setName("Tom Brooks");
        user.setUsername("blahblah42");
        user.setAge(34);
        user.setEmail("tbrooksss@gmail.com");
        user.setPassword("imCool123");
        // this constructor adds 1900 to the year given and 1 to the month given
        // I have no idea why
        Date d = new Date(2003,04,12);

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

        // previous attempts
        /*DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setColumns(TEXT_BOX_WIDTH);
        dateTextField.setFont(defaultFont);
        dateTextField.setText(format.format(d));
        information.add(dateTextField, constraints);*/
        /*uDOB = new JTextField(TEXT_BOX_WIDTH);
        uDOB.setText(Integer.toString(user.getAge()));
        uDOB.setFont(defaultFont);
        information.add(uDOB, constraints);*/

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
