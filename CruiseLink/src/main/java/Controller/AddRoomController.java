package Controller;

import UI.UINavigator;

import javax.swing.*;

public interface AddRoomController {
    //void onAddPressed(JComboBox, JComboBox, JComboBox, JTextField, JCheckBox);
    void onCancelPressed(UINavigator UINavigator);

    void onAddPressed(JComboBox qualityLvl, JComboBox bedType, JComboBox bedNum, JTextField roomNum, JCheckBox isSmoking);
}
