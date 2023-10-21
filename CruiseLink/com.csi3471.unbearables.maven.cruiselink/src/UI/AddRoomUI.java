package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddRoomUI extends JPanel{
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

    private static void createGUI() {
        //Create and set up the window.
        frame = new JFrame("Cruiselink Application");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up layout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        // Quality Level label and comboBox
        qualityLbl = new JLabel("Quality Level:");
        constraints.gridy = 0;
        frame.add(qualityLbl, constraints);
        qualityLvl = new JComboBox(qLevels);
        qualityLvl.setSelectedIndex(0);
        frame.add(qualityLvl, constraints);

        // Bed Type label and comboBox
        bedTypeLbl = new JLabel("Bed Type(s):");
        constraints.gridy = 1;
        frame.add(bedTypeLbl, constraints);
        bedType = new JComboBox(bedTypes);
        bedType.setSelectedIndex(0);
        frame.add(bedType, constraints);

        // Bed Number label and comboBox
        bedNumLbl = new JLabel("Number of Beds:");
        constraints.gridy = 2;
        frame.add(bedNumLbl, constraints);
        bedNum = new JComboBox(numBeds);
        bedNum.setSelectedIndex(0);
        frame.add(bedNum, constraints);

        // Room Number label and textField
        roomNumLbl = new JLabel("Room #:");
        constraints.gridy = 3;
        frame.add(roomNumLbl, constraints);
        roomNum = new JTextField(" ", COLUMNS);
        frame.add(roomNum, constraints);

        // Smoking Status label and checkBox
        smokingLbl = new JLabel("Smoking:");
        constraints.gridy = 4;
        frame.add(smokingLbl, constraints);
        isSmoking = new JCheckBox();
        frame.add(isSmoking, constraints);

        // Cancel button
        cancel = new JButton("Cancel");
        constraints.gridy = 5;
        frame.add(cancel, constraints);

        // Add Room button
        add = new JButton("Add");
        constraints.gridy = 5;
        frame.add(add, constraints);

        //Display the window.
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
