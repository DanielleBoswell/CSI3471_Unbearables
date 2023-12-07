package UI;

import Controller.MyMenuBarController;

import javax.swing.*;
import java.awt.*;

// This class is used to generate the menu bar that should always be present
public class MyMenuBar extends JMenuBar {
    JMenu menu;
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 14);
    private static MyMenuBarController controller;

    /**
     * @author Kyle Hoang
     * This constructs a menu bar to be added to a JFrame. It is also able to be added to a JPanel, which does not
     * have a specific method for adding a menu bar. Thus, the MyMenuBar would have to be formatted manually.
     * @param controller
     */
    public MyMenuBar(MyMenuBarController controller) {
        this.controller = controller;

        this.add(Box.createHorizontalGlue());
        menu = new JMenu("My Account");
        menu.setFont(defaultFont);

        // define options in menu
        // account details option
        JMenuItem accountDetails = new JMenuItem("Account Details");
        accountDetails.addActionListener(e -> {
            controller.onAccountDetailsPressed();
        });
        menu.add(accountDetails);

        // log out option
        JMenuItem logOut = new JMenuItem("Log Out");
        logOut.addActionListener(e -> {
            controller.onLogOutPressed();
        });
        menu.add(logOut);

        this.add(menu);
    }
}