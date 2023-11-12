package Cruiselink.maven.cruiselink.src.Controller;

import javax.swing.*;

public interface AddRoomController {
    //void onAddPressed(JComboBox, JComboBox, JComboBox, JTextField, JCheckBox);
    void onCancelPressed();

    void onAddPressed(JComboBox qualityLvl, JComboBox bedType, JComboBox bedNum, JTextField roomNum, JCheckBox isSmoking);
}
