package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class loginLandingGUI extends JFrame {
//    private JButton reserveACruiseButton;
//    private JLabel logoLbl;
//    private JButton myReservationsButton;
//    private JButton myAccountButton;
//
//    public loginLandingGUI() {
//        setTitle("CruiseLink");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//
//        // Top panel for the "CruiseLink" label
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//        // Label in the top-left corner
//        logoLbl = new JLabel("CruiseLink");
//        topPanel.add(logoLbl);
//
//        // Top-right panel for the "My Account" button
//        JPanel topRightPanel = new JPanel();
//        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
//
//        // My Account button in the top-right corner
//        myAccountButton = new JButton("My Account");
//        topRightPanel.add(myAccountButton);
//
//        // Center panel for the "Reserve a Cruise" and "My Reservations" buttons
//        JPanel centerPanel = new JPanel();
//        centerPanel.setLayout(new GridBagLayout());
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.insets = new Insets(5, 5, 5, 5);
//
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
//        constraints.anchor = GridBagConstraints.WEST; // Align buttons to the left
//
//        reserveACruiseButton = new JButton("Reserve a Cruise");
//        centerPanel.add(reserveACruiseButton, constraints);
//
//        constraints.gridy = 1;
//
//        myReservationsButton = new JButton("My Reservations");
//        centerPanel.add(myReservationsButton, constraints);
//
//        // Add the top panel to the main panel
//        mainPanel.add(topPanel, BorderLayout.NORTH);
//
//        // Add the center panel to the main panel
//        mainPanel.add(centerPanel, BorderLayout.WEST);
//
//        // Add the top-right panel to the main panel
//        mainPanel.add(topRightPanel, BorderLayout.EAST);
//
//        add(mainPanel);
//
//        // Add action listeners to the buttons
//        reserveACruiseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Handle the action for the "Reserve a Cruise" button
//
//            }
//        });
//
//        myReservationsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Handle the action for the "My Reservations" button
//            }
//        });
//
//        myAccountButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Handle the action for the "My Account" button
//            }
//        });
//
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            loginLandingGUI gui = new loginLandingGUI();
//            gui.setVisible(true);
//        });
//    }
//}






//import javax.swing.*;
//import java.awt.*;
//import com.intellij.uiDesigner.core.GridConstraints;
//import com.intellij.uiDesigner.core.GridLayoutManager;
//
//public class loginLandingUI extends JPanel {
//    private JPanel mainPanel;
//    private JButton reserveACruiseButton;
//    private JLabel logoLbl;
//    private JButton myReservationsButton;
//    private JButton myAccountButton;
//
//    public loginLandingUI() {
//        // Your GUI components are initialized and configured here based on the generated code.
//        // You should add components to the mainPanel.
//
//        // Initialize the main panel
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayoutManager(5, 3));
//
//        // Create and configure the components based on the generated code
//        reserveACruiseButton = new JButton("Reserve a Cruise");
//        logoLbl = new JLabel("CruiseLink");
//        myReservationsButton = new JButton("My Reservations");
//        myAccountButton = new JButton("My Account");
//
//        // Add components to the mainPanel with constraints
//
//        mainPanel.add(logoLbl, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
//        mainPanel.add(reserveACruiseButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 30), null, 0, false));
//        mainPanel.add(myReservationsButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 30), null, 0, false));
//        mainPanel.add(myAccountButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 30), null, 0, false));
//        // Add other components and constraints as needed
//
//        // Set the layout of this panel to GridLayoutManager
//        setLayout(new GridLayoutManager(1, 1));
//
//        // Add the mainPanel to this panel
//        add(mainPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//    }
//
//    // Other methods and event handlers can be added here
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("CruiseLink");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new loginLandingUI());
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//}



//import javax.swing.*;
//import java.awt.*;
//
//public class loginLandingUI extends JFrame {
//    private JPanel mainPanel;
//    private JButton reserveACruiseButton;
//    private JLabel logoLbl;
//    private JButton myReservationsButton;
//    private JButton myAccountButton;
//
//    public loginLandingUI() {
//        setTitle("CruiseLink");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new GridBagLayout());
//        add(mainPanel);
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.fill = GridBagConstraints.BOTH;
//        constraints.insets = new Insets(5, 5, 5, 5);
//
//        logoLbl = new JLabel("CruiseLink");
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
//        mainPanel.add(logoLbl, constraints);
//
//        reserveACruiseButton = new JButton("Reserve a Cruise");
//        constraints.gridx = 0;
//        constraints.gridy = 2;
//        mainPanel.add(reserveACruiseButton, constraints);
//
//        myReservationsButton = new JButton("My Reservations");
//        constraints.gridx = 0;
//        constraints.gridy = 3;
//        mainPanel.add(myReservationsButton, constraints);
//
//        myAccountButton = new JButton("My Account");
//        constraints.gridx = 2;
//        constraints.gridy = 0;
//        mainPanel.add(myAccountButton, constraints);
//
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            loginLandingUI gui = new loginLandingUI();
//            gui.setVisible(true);
//        });
//    }
//}

