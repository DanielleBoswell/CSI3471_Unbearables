package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.MyMenuBarController;

import javax.swing.*;
import java.awt.*;

// This class is used to generate the menu bar that should always be present
public class MyMenuBar extends JMenuBar {
    JMenu menu;
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 14);
    private static MyMenuBarController controller;

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
