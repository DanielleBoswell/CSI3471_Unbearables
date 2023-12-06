package Controller;

import Domain.Room;
import UI.UINavigator;

import javax.swing.*;

public class AddRoomControllerImpl implements AddRoomController {

    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public AddRoomControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }


    @Override
    public void onAddPressed(JComboBox qualityLvl, JComboBox bedType, JComboBox bedNum, JTextField roomNum, JCheckBox isSmoking) {
        System.out.println("Add Button pressed!");
        // Get the selected values from the JComboBox components
        Room.QualityLevel selectedQuality = Room.QualityLevel.valueOf((String) qualityLvl.getSelectedItem());
        Room.BedType selectedBedType = Room.BedType.valueOf((String) bedType.getSelectedItem());
        int selectedBedNum = Integer.parseInt((String) bedNum.getSelectedItem());


        int roomNumber = -1;
        if (!(roomNum.getText().isBlank())) {
            try {
                roomNumber = Integer.parseInt(roomNum.getText().trim());
                if (roomNumber < 0) {
                    // Handle the case of a negative room number
                    // Display an error message or take appropriate action
                    roomNumber = -1; // Set to -1 to indicate an error
                }
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                // Display an error message or take appropriate action
                roomNumber = -1; // Set to -1 to indicate an error
            }

            boolean isSmokingRoom = isSmoking.isSelected();

            // Create a new object using the selected values
            Room newRoom = new Room(isSmokingRoom, selectedBedType, roomNumber, selectedBedNum, selectedQuality);
            System.out.println(newRoom);

            // Do something with the new object, e.g., add it to a list or perform other operations.
        }
    }

    @Override
    public void onCancelPressed(UINavigator UINavigator) {
        System.out.println("Cancel Button pressed!");
        JOptionPane.showMessageDialog(null, "Check In/Check Out canceled",
                "Returning to travel agent home page", JOptionPane.ERROR_MESSAGE);

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }
}
