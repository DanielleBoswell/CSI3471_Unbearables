package UI;

import Controller.LoginLandingController;
import Controller.LoginLandingControllerImpl;
import Controller.MyMenuBarControllerImpl;

import java.awt.*;
import javax.swing.*;

public class LoginLandingGUI extends JPanel {
    // components
    private static JFrame frame;
    private static MyMenuBar menuBar;
    private static JButton reserveCruiseBtn, myReservationsBtn;
    private static JPanel btnPanel;
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 14);
    private static LoginLandingController controller;

    public LoginLandingGUI(LoginLandingController controller) { this.controller = controller; }

    public static void createGUI() {
        // Create and set up window
        frame = new JFrame("CruiseLink Landing Page");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up layout
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));


        // menu bar
        menuBar = new MyMenuBar(new MyMenuBarControllerImpl());
        frame.setJMenuBar(menuBar);

        // create button panel for position buttons
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(0,1, 10, 10));

        // reserve a cruise button
        reserveCruiseBtn = new JButton("Reserve a Cruise");
        reserveCruiseBtn.setForeground(Color.BLUE);
        reserveCruiseBtn.setFont(defaultFont);
        //reserveCruiseBtn.setLocation(200, 200);
        reserveCruiseBtn.addActionListener(e -> {
            controller.onReserveCruisePressed();
        });
        btnPanel.add(reserveCruiseBtn);

        // my reservations button
        myReservationsBtn = new JButton("My Reservations");
        myReservationsBtn.setForeground(Color.BLUE);
        myReservationsBtn.setFont(defaultFont);
        //myReservationsBtn.set
        myReservationsBtn.addActionListener(e -> {
            controller.onMyReservationsPressed();
        });
        btnPanel.add(myReservationsBtn);

        // add button panel to frame
        frame.add(btnPanel);

        /// FIX ME: THIS SHOULD RETRIEVE A TABLE OF GUEST'S DATABASES AND DISPLAY IT

        // dsplay window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Making sure it is running on the correct thread
        SwingUtilities.invokeLater(() -> {

            //Need to create an instance of the concrete implementation of LoginController
            LoginLandingController controller = new LoginLandingControllerImpl();

            //Will pass controller to LoginGUI and create the login GUI
            LoginLandingGUI LoginLandingGUI = new LoginLandingGUI(controller);

            //Create login GUI
            LoginLandingGUI.createGUI();
        });
    }
}
