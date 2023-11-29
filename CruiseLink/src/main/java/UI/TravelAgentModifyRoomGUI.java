package UI;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TravelAgentModifyRoomGUI { // ------------- This UI should only have to access a given ship and change the room information of a given room -------------

    private UINavigator UINavigator;

    public TravelAgentModifyRoomGUI(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    //Text fields, buttons, combo boxes, and text areas
    private JTextField cruiseNameField, roomNumberField;
    private JButton searchCruiseShipButton, modifyRoomButton, cancelButton;
    private JTextArea roomDetailsTextArea;

    private JComboBox<String> qualityLevelComboBox, smokingStatusComboBox, bedTypeComboBox;

    public JPanel createTravelAgentModifyRoom(){

        JPanel travelAgentModifyRoomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Insets insets = new Insets(10, 10, 10, 10);
        gbc.insets = insets;

        //Title of page
        JLabel modifyRoomLabel = new JLabel("Modify Room");
        modifyRoomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        //Set GridBagConstraints for the label
        gbc.gridx = 0; //Align to the first column
        gbc.gridy = 0; //Place at the first row
        gbc.gridwidth = 2; //Span across two columns
        gbc.insets = new Insets(10, 10, 20, 10); //Add some padding
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(modifyRoomLabel, gbc);

        JLabel searchForCruiseLabel = new JLabel("Enter Cruise Ship Name:");
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(searchForCruiseLabel, gbc);

        cruiseNameField = new JTextField(15);
        roomNumberField = new JTextField(15);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(cruiseNameField, gbc);

        JLabel roomNumberLabel = new JLabel("Enter Room Number:");
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(roomNumberLabel, gbc);

        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(roomNumberField, gbc);

        //Search for a cruise button
        searchCruiseShipButton = new JButton("Search");
        gbc.gridy = 5;
        travelAgentModifyRoomPanel.add(searchCruiseShipButton, gbc);

        JLabel roomDetailsLabel = new JLabel("Room Details:");
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(roomDetailsLabel, gbc);

        //Text area for room details
        roomDetailsTextArea = new JTextArea(5, 20);
        roomDetailsTextArea.setEditable(false);
        JScrollPane billScrollPane = new JScrollPane(roomDetailsTextArea);
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(billScrollPane, gbc);

        JLabel makeChangesLabel = new JLabel("Select Changes to be Made:");
        makeChangesLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(makeChangesLabel, gbc);

        //Quality Level Dropdown
        JLabel qualityLevelLabel = new JLabel("Quality Level:");
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(qualityLevelLabel, gbc);

        qualityLevelComboBox = new JComboBox<>(new String[]{"Executive", "Business", "Comfort", "Economy"});
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(qualityLevelComboBox, gbc);

        //Bed Type Dropdown
        JLabel bedTypeLabel = new JLabel("Bed Type:");
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(bedTypeLabel, gbc);

        bedTypeComboBox = new JComboBox<>(new String[]{"Queen - 1", "Twin - 2", "King - 1", "Full - 2"});
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(bedTypeComboBox, gbc);

        //Smoking Status Dropdown
        JLabel smokingStatusLabel = new JLabel("Smoking/Non-Smoking Status:");
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(smokingStatusLabel, gbc);

        smokingStatusComboBox = new JComboBox<>(new String[]{"Smoking", "Non-Smoking"});
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(smokingStatusComboBox, gbc);

        //Modify Room button
        modifyRoomButton = new JButton("Modify Room");
        gbc.gridy++;
        travelAgentModifyRoomPanel.add(modifyRoomButton, gbc);

        //Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.RED);
        gbc.gridy++;
        gbc.gridwidth = 2; //Span two columns
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentModifyRoomPanel.add(cancelButton, gbc);

        //Action listeners for buttons
        searchCruiseShipButton.addActionListener(e -> onSearch());
        modifyRoomButton.addActionListener(e -> onModifyRoom());
        cancelButton.addActionListener(e -> onCancel(UINavigator));

        return travelAgentModifyRoomPanel;
    }

    private void onSearch() {

        String roomNumber = roomNumberField.getText();
        String roomDetails = CSVFileHandler.searchRoom(roomNumber);

        if (roomDetails != null) {
            String[] details = roomDetails.split(",");
            if (details.length == 4) {
                qualityLevelComboBox.setSelectedItem(details[1].trim());
                bedTypeComboBox.setSelectedItem(details[2].trim()); //Update for combo box
                smokingStatusComboBox.setSelectedItem(details[3].trim());

                roomDetailsTextArea.setText("Quality Level: " + details[1].trim() + "\n" +
                        "Bed Type and Number: " + details[2].trim() + "\n" +
                        "Smoking/Non-Smoking Status: " + details[3].trim());
            }
        } else {
            roomDetailsTextArea.setText("Room not found.");
        }
    }

    private void onModifyRoom() {

        //Retrieve the text from the fields
        String cruiseName = cruiseNameField.getText().trim();
        String roomNumber = roomNumberField.getText().trim();
        String roomDetails = roomDetailsTextArea.getText().trim();

        //Check if any of the fields are empty
        if (cruiseName.isEmpty() || roomNumber.isEmpty() || roomDetails.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields before modifying the room.",
                    "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if(roomDetails.equals("Room not found.")){
            JOptionPane.showMessageDialog(null, "Room cannot be found, please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String qualityLevel = (String) qualityLevelComboBox.getSelectedItem();
        String bedType = (String) bedTypeComboBox.getSelectedItem();
        String smokingStatus = (String) smokingStatusComboBox.getSelectedItem();

        String[] newDetails = {roomNumber, qualityLevel, bedType, smokingStatus};
        CSVFileHandler.updateRoom(roomNumber, newDetails);

        JOptionPane.showMessageDialog(null, "Room details updated successfully",
                "Room Modified", JOptionPane.INFORMATION_MESSAGE);

        //Clearing fields related to room modification
        cruiseNameField.setText("");
        roomNumberField.setText("");
        roomDetailsTextArea.setText("");
        qualityLevelComboBox.setSelectedIndex(0);
        bedTypeComboBox.setSelectedIndex(0);
        smokingStatusComboBox.setSelectedIndex(0);

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }

    private void onCancel(UINavigator UINavigator){

        JOptionPane.showMessageDialog(null, "Modify Room Canceled",
                "Returning to travel agent home page", JOptionPane.ERROR_MESSAGE);

        //Clearing fields related to room modification
        cruiseNameField.setText("");
        roomNumberField.setText("");
        roomDetailsTextArea.setText("");
        qualityLevelComboBox.setSelectedIndex(0);
        bedTypeComboBox.setSelectedIndex(0);
        smokingStatusComboBox.setSelectedIndex(0);

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }
}

//For testing with a csv...
class CSVFileHandler {

    private static final String CSV_FILE_PATH = "Rooms_for_modify_room.csv";

    public static String searchRoom(String roomNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].trim().equals(roomNumber.trim())) {
                    return line; //Return the matching line
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //Return null if no match is found
    }

    public static void updateRoom(String roomNumber, String[] newDetails) {

        File inputFile = new File(CSV_FILE_PATH);
        File tempFile = new File("temp.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].trim().equals(roomNumber.trim())) {
                    line = String.join(",", newDetails); //Replace with new details
                }
                writer.write(line + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename file");
        }
    }
}