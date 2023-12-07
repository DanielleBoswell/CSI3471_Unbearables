package UI;

import Controller.AddRoomController;
import Controller.AddRoomControllerImpl;
import Controller.CheckInControllerImpl;

import javax.swing.*;
import java.awt.*;

public class AddRoomGUI extends JPanel {
    // global constants
    private static final int COLUMNS = 5;

    // drop down selection items
    private static String[] qLevels = {"EXECUTIVE", "BUSINESS", "COMFORT", "ECONOMY"};
    private static String[] bedTypes = {"TWIN", "FULL", "QUEEN", "KING"};
    private static String[] numBeds = {"1", "2", "3"};

    // other components
    private static JFrame frame;
    private static JLabel roomNumLbl, smokingLbl, qualityLbl, bedTypeLbl, bedNumLbl;
    private static JComboBox qualityLvl, bedType, bedNum;
    private static JComponent content;
    private static JCheckBox isSmoking;
    private static JTextField roomNum;
    private static JButton cancel, add;

    private static JMenuBar menuBar;
    private static JMenu menu;
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 14);
    private static AddRoomController controller;

    //AddRoomGUI constructor takes the AddRoomController and sets it
    public AddRoomGUI(AddRoomController controller) {
        this.controller = controller;
    }

    // Sets the controller
    public void setController (AddRoomControllerImpl addRoomController) { this.controller = addRoomController; }


    // Making a UINavigator instance for check in
    private UINavigator uiNavigator;

    // Constructor accepting UINavigator instance - Need this for switching panels
    public AddRoomGUI (UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }


    /**
     * @author Kyle Hoang
     * This method is a modified version of Emma's createGUI method. It has been updated for use
     * with UINavigator. Instead of adding everything to a frame and displaying the frame, the method now
     * adds everything to an instance of an AddRoom JPanel, then returns the JPanel
     * @return JPanel of the AddRoomUI
     */
    public JPanel createAddRoomUIPanel() {
        // Create and set up the window.
        //frame = new JFrame("Cruiselink Application");
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.gridy = 0;

        // Menu Bar
        menuBar = new JMenuBar();
        menu = new JMenu("Add a Room");
        menu.setFont(defaultFont);
        menuBar.add(menu);
        this.add(menuBar);

        // Quality Level label and comboBox
        qualityLbl = new JLabel("Quality Level:");
        qualityLbl.setFont(defaultFont);
        ++constraints.gridy;
        this.add(qualityLbl, constraints);

        qualityLvl = new JComboBox(qLevels);
        qualityLvl.setFont(defaultFont);
        qualityLvl.setSelectedIndex(0);
        this.add(qualityLvl, constraints);

        // Bed Type label and comboBox
        bedTypeLbl = new JLabel("Bed Type(s):");
        bedTypeLbl.setFont(defaultFont);
        ++constraints.gridy;
        this.add(bedTypeLbl, constraints);

        bedType = new JComboBox(bedTypes);
        bedType.setFont(defaultFont);
        bedType.setSelectedIndex(0);
        this.add(bedType, constraints);

        // Bed Number label and comboBox
        bedNumLbl = new JLabel("Number of Beds:");
        bedNumLbl.setFont(defaultFont);
        ++constraints.gridy;
        this.add(bedNumLbl, constraints);

        bedNum = new JComboBox(numBeds);
        bedNum.setFont(defaultFont);
        bedNum.setSelectedIndex(0);
        this.add(bedNum, constraints);

        // Room Number label and textField
        roomNumLbl = new JLabel("Room #:");
        roomNumLbl.setFont(defaultFont);
        ++constraints.gridy;
        this.add(roomNumLbl, constraints);
        roomNum = new JTextField(" ", COLUMNS);
        this.add(roomNum, constraints);

        // Smoking Status label and checkBox
        smokingLbl = new JLabel("Smoking:");
        smokingLbl.setFont(defaultFont);
        ++constraints.gridy;
        this.add(smokingLbl, constraints);
        isSmoking = new JCheckBox();
        this.add(isSmoking, constraints);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setFont(defaultFont);
        cancel.addActionListener(e -> onCancel(uiNavigator));
        ++constraints.gridy;
        this.add(cancel, constraints);

        // Add Room button
        add = new JButton("Add");
        add.setFont(defaultFont);
        this.add(add, constraints);
        add.addActionListener(e -> {
            controller.onAddPressed(qualityLvl, bedType, bedNum, roomNum, isSmoking);
        }); // add button actionListener

        //Display the window.
        //this.pack();
        //this.setVisible(true);
        return this;
    }


    /**
     * @author originally Kyle Thomspon, modified for use by Kyle Hoang
     * This method sends user to Travel Agent Landing Page
     * @param UINavigator
     */
    private void onCancel(UINavigator UINavigator){

        JOptionPane.showMessageDialog(null, "Add Room canceled",
                "Returning to travel agent home page", JOptionPane.ERROR_MESSAGE);

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }


//    /**
//     * @author Emma Aars
//     * This method is from an old version of the UI, before UINavigator. It creates a standalone AddRoomUI.
//     */
//    public static void createGUI() {
//        // Create and set up the window.
//        frame = new JFrame("Cruiselink Application");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // set up layout
//        frame.setLayout(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(15, 15, 15, 15);
//        constraints.gridy = 0;
//
//        // Menu Bar
//        menuBar = new JMenuBar();
//        menu = new JMenu("Add a Room");
//        menu.setFont(defaultFont);
//        menuBar.add(menu);
//        frame.setJMenuBar(menuBar);
//
//        // Quality Level label and comboBox
//        qualityLbl = new JLabel("Quality Level:");
//        qualityLbl.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(qualityLbl, constraints);
//
//        qualityLvl = new JComboBox(qLevels);
//        qualityLvl.setFont(defaultFont);
//        qualityLvl.setSelectedIndex(0);
//        frame.add(qualityLvl, constraints);
//
//        // Bed Type label and comboBox
//        bedTypeLbl = new JLabel("Bed Type(s):");
//        bedTypeLbl.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(bedTypeLbl, constraints);
//
//        bedType = new JComboBox(bedTypes);
//        bedType.setFont(defaultFont);
//        bedType.setSelectedIndex(0);
//        frame.add(bedType, constraints);
//
//        // Bed Number label and comboBox
//        bedNumLbl = new JLabel("Number of Beds:");
//        bedNumLbl.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(bedNumLbl, constraints);
//
//        bedNum = new JComboBox(numBeds);
//        bedNum.setFont(defaultFont);
//        bedNum.setSelectedIndex(0);
//        frame.add(bedNum, constraints);
//
//        // Room Number label and textField
//        roomNumLbl = new JLabel("Room #:");
//        roomNumLbl.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(roomNumLbl, constraints);
//        roomNum = new JTextField(" ", COLUMNS);
//        frame.add(roomNum, constraints);
//
//        // Smoking Status label and checkBox
//        smokingLbl = new JLabel("Smoking:");
//        smokingLbl.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(smokingLbl, constraints);
//        isSmoking = new JCheckBox();
//        frame.add(isSmoking, constraints);
//
//        // Cancel button
//        cancel = new JButton("Cancel");
//        cancel.setForeground(Color.RED);
//        cancel.setFont(defaultFont);
//        ++constraints.gridy;
//        frame.add(cancel, constraints);
//
//        // Add Room button
//        add = new JButton("Add");
//        add.setFont(defaultFont);
//        frame.add(add, constraints);
//        add.addActionListener(e -> {
//            controller.onAddPressed(qualityLvl, bedType, bedNum, roomNum, isSmoking);
//        }); // add button actionListener
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    /**
//     * @author Emma Aars
//     * This method is from an old version of the UI, before the implentation of UINavigator. It was used to open the
//     * standalone AddRoomUI
//     * @param args
//     */
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createGUI();
//            }
//        });
//    }
}
