package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.UI;

import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.Room;

import javax.swing.*;

public class AddRoomControllerImpl implements AddRoomController {
    @Override
    public void onAddPressed(JComboBox qualityLvl, JComboBox bedType, JComboBox bedNum, JTextField roomNum, JCheckBox isSmoking) {
        System.out.println("Add Button pressed!");
        // Get the selected values from the JComboBox components
        Room.QualityLevel selectedQuality = Room.QualityLevel.valueOf((String) qualityLvl.getSelectedItem());
        Room.BedType selectedBedType = Room.BedType.valueOf((String) bedType.getSelectedItem());
        int selectedBedNum = Integer.parseInt((String) bedNum.getSelectedItem());

        // FIX ME: ADD ERROR CHECKING FOR NON NUMERICS, FOR NEGATIVE NUMBERS
        int roomNumber = -1;
        if (!(roomNum.getText().isBlank())) {
            roomNumber = Integer.parseInt(roomNum.getText().trim());
        }

        boolean isSmokingRoom = isSmoking.isSelected();

        // Create a new object using the selected values
        Room newRoom = new Room(isSmokingRoom, selectedBedType, roomNumber, selectedBedNum, selectedQuality);
        System.out.println(newRoom);

        // Do something with the new object, e.g., add it to a list or perform other operations.
    }

    @Override
    public void onCancelPressed() {

    }
}
