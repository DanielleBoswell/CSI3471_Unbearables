package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.awt.*;
import javax.swing.*;

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

    public static void createGUI() {
        // Create and set up the window.
        frame = new JFrame("Cruiselink Application");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up layout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.gridy = 0;

        // Menu Bar
        menuBar = new JMenuBar();
        menu = new JMenu("Add a Room");
        menu.setFont(defaultFont);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Quality Level label and comboBox
        qualityLbl = new JLabel("Quality Level:");
        qualityLbl.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(qualityLbl, constraints);

        qualityLvl = new JComboBox(qLevels);
        qualityLvl.setFont(defaultFont);
        qualityLvl.setSelectedIndex(0);
        frame.add(qualityLvl, constraints);

        // Bed Type label and comboBox
        bedTypeLbl = new JLabel("Bed Type(s):");
        bedTypeLbl.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(bedTypeLbl, constraints);

        bedType = new JComboBox(bedTypes);
        bedType.setFont(defaultFont);
        bedType.setSelectedIndex(0);
        frame.add(bedType, constraints);

        // Bed Number label and comboBox
        bedNumLbl = new JLabel("Number of Beds:");
        bedNumLbl.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(bedNumLbl, constraints);

        bedNum = new JComboBox(numBeds);
        bedNum.setFont(defaultFont);
        bedNum.setSelectedIndex(0);
        frame.add(bedNum, constraints);

        // Room Number label and textField
        roomNumLbl = new JLabel("Room #:");
        roomNumLbl.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(roomNumLbl, constraints);
        roomNum = new JTextField(" ", COLUMNS);
        frame.add(roomNum, constraints);

        // Smoking Status label and checkBox
        smokingLbl = new JLabel("Smoking:");
        smokingLbl.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(smokingLbl, constraints);
        isSmoking = new JCheckBox();
        frame.add(isSmoking, constraints);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setFont(defaultFont);
        ++constraints.gridy;
        frame.add(cancel, constraints);

        // Add Room button
        add = new JButton("Add");
        add.setFont(defaultFont);
        frame.add(add, constraints);
        add.addActionListener(e -> {
            controller.onAddPressed(qualityLvl, bedType, bedNum, roomNum, isSmoking);
        }); // add button actionListener

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Making sure it is running on the correct thread
        SwingUtilities.invokeLater(() -> {

            //Need to create an instance of the concrete implementation of LoginController
            AddRoomController controller = new AddRoomControllerImpl();

            //Will pass controller to LoginGUI and create the login GUI
            AddRoomGUI AddRoomGUI = new AddRoomGUI(controller);

            //Create login GUI
            AddRoomGUI.createGUI();
        });
    }
}
