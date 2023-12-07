package UI;

import Controller.AddRoomController;
import Controller.AddRoomControllerImpl;
import Controller.CheckInControllerImpl;

import javax.swing.*;
import java.awt.*;

/**
 * This class contains the code for the travel agent's profile page.
 * It uses the profile controller to actually function.
 * @author Emma and Kyle Hoang
 */
public class AddRoomGUI extends JPanel {
    /**
     * This is the number of columns.
     */
    private static final int COLUMNS = 5;

    /**
     * These are the lists for the combo box options.
     */
    private static String[] qLevels = {"EXECUTIVE", "BUSINESS", "COMFORT", "ECONOMY"};
    private static String[] bedTypes = {"TWIN", "FULL", "QUEEN", "KING"};
    private static String[] numBeds = {"1", "2", "3"};

    /**
     * This is the frame.
     */
    private static JFrame frame;
    /**
     * These are the labels.
     */
    private static JLabel roomNumLbl, smokingLbl, qualityLbl, bedTypeLbl, bedNumLbl;
    /**
     * These are the combo boxes for limited options.
     */
    private static JComboBox qualityLvl, bedType, bedNum;
    /**
     * This is the checkbox for smoking status.
     */
    private static JCheckBox isSmoking;
    /**
     * This is the text field to decide the room number.
     */
    private static JTextField roomNum;
    /**
     * These are the concel and add buttons.
     */
    private static JButton cancel, add;

    /**
     * This is the menu bar.
     */
    private static JMenuBar menuBar;
    /**
     * This is the actual menu.
     */
    private static JMenu menu;
    /**
     * This is the default font for this UI.
     */
    private static Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 14);
    /**
     * This is the controller for this page.
     */
    private static AddRoomController controller;

    /**
     * This initializes the controller to be used.
     */
    public AddRoomGUI(AddRoomController controller) {
        this.controller = controller;
    }

    /**
     * This initializes the controller to be used.
     */
    public void setController (AddRoomControllerImpl addRoomController) { this.controller = addRoomController; }


    /**
     * This is the UI navigator for this UI.
     */
    private UINavigator uiNavigator;

    /**
     * This initializes the UI navigator to be used to switch pages.
     */
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

    /**
     * @author Emma Aars
     * This method is from an old version of the UI, before UINavigator. It creates a standalone AddRoomUI.
     */
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
